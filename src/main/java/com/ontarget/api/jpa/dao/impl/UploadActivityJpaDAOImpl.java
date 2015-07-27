package com.ontarget.api.jpa.dao.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ontarget.api.dao.UploadActivityDAO;
import com.ontarget.api.repository.ProjectRepository;
import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.api.repository.TaskPriorityRepository;
import com.ontarget.bean.ActivityInfo;
import com.ontarget.bean.ActivityTaskInfo;
import com.ontarget.constant.BulkActivityAttributeConstant;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.BulkActivityAttribute;
import com.ontarget.entities.BulkActivityLog;
import com.ontarget.entities.PlannedActualsCost;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.TaskAssignee;
import com.ontarget.entities.TaskPercentageLog;
import com.ontarget.entities.TaskPriority;
import com.ontarget.entities.User;
import com.ontarget.request.bean.ActivityTaskRecord;
import com.ontarget.util.DateFormater;
import com.ontarget.util.DateValidator;

@Repository("uploadActivityJpaDAOImpl")
public class UploadActivityJpaDAOImpl implements UploadActivityDAO {
	@Resource
	private ProjectRepository projectRepository;
	@Resource
	private ProjectTaskRepository projectTaskRepository;
	@Resource
	private TaskPriorityRepository taskPriorityRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public boolean createActivity(List<ActivityInfo> activityInfoList, List<ActivityTaskRecord> invalidActivityRecords, String filename,
			int userId, int projectId) throws Exception {
		int batchSize = 1000;
		int i = 0;

		BulkActivityLog bulkActivityLog = new BulkActivityLog();
		bulkActivityLog.setFileName(filename);
		bulkActivityLog.setUploadedBy(new User(userId));
		bulkActivityLog.setUploadedDate(new Date());
		entityManager.persist(bulkActivityLog);

		Project parentProject = projectRepository.findByProjectId(projectId);

		for (ActivityInfo activityInfo : activityInfoList) {
			Project project = new Project();
			project.setProjectCode(activityInfo.getActivityCode());
			project.setProjectName(activityInfo.getActivityName());
			project.setProjectDescription(activityInfo.getActivityName());
			project.setProjectType(parentProject.getProjectType());
			project.setProjectStatus(OnTargetConstant.ProjectStatus.ACTIVE);
			project.setProjectParentId(projectId);
			project.setProjectStartDate(DateFormater.convertToDate(activityInfo.getStartDate(), DateValidator.dateFormat));
			project.setProjectEndDate(DateFormater.convertToDate(activityInfo.getEndDate(), DateValidator.dateFormat));
			project.setCreatedBy(new User(userId));
			project.setCreatedDate(new Date());
			project.setProjectOwnerId(userId);
			project.setCompanyInfo(parentProject.getCompanyInfo());
			project.setType(OnTargetConstant.ProjectInfoType.ACTIVITY);
			entityManager.persist(project);

			List<ActivityTaskInfo> taskInfoList = activityInfo.getTaskList();
			for (ActivityTaskInfo activityTaskInfo : taskInfoList) {
				ProjectTask projectTask = new ProjectTask();
				projectTask.setProject(new Project(project.getProjectId()));
				projectTask.setTitle(activityTaskInfo.getTaskName());
				projectTask.setDescription(activityTaskInfo.getTaskDescription());
				projectTask.setStatus(OnTargetConstant.TaskStatus.ACTIVE);
				projectTask.setStartDate(DateFormater.convertToDate(activityTaskInfo.getStartDate(), DateValidator.dateFormat));
				projectTask.setEndDate(DateFormater.convertToDate(activityTaskInfo.getEndDate(), DateValidator.dateFormat));
				projectTask.setCreatedBy(new User(userId));
				projectTask.setCreatedDate(new Date());
				projectTask.setSeverity(String.valueOf(activityTaskInfo.getPriority()));
				entityManager.persist(projectTask);

				TaskAssignee taskAssignee = new TaskAssignee();
				taskAssignee.setCreatedBy(new User(userId));
				taskAssignee.setCreatedDate(new Date());
				taskAssignee.setProjectTask(projectTask);
				taskAssignee.setTaskAssignee(userId);
				taskAssignee.setStatus(OnTargetConstant.TaskAssigneeStatus.ASSIGNED);
				entityManager.persist(taskAssignee);

				TaskPercentageLog taskPercentageLog = new TaskPercentageLog();
				taskPercentageLog.setProjectTask(projectTask);
				taskPercentageLog.setStartDate(new Date());
				taskPercentageLog.setEndDate(DateFormater.convertToDate("9999-12-31"));
				taskPercentageLog.setPercentageType("PERCENTAGE");
				taskPercentageLog.setPercentageComplete(Double.parseDouble(activityTaskInfo.getPercentageComplete()));
				taskPercentageLog.setCreatedBy(new User(userId));
				taskPercentageLog.setCreatedDate(new Date());
				entityManager.persist(taskPercentageLog);

				PlannedActualsCost estimatedCost = new PlannedActualsCost();
				estimatedCost.setProjectTask(projectTask);
				estimatedCost.setFromDate(DateFormater.convertToDate(activityTaskInfo.getStartDate(), DateValidator.dateFormat));
				estimatedCost.setToDate(DateFormater.convertToDate(activityTaskInfo.getEndDate(), DateValidator.dateFormat));
				estimatedCost.setCostType(OnTargetConstant.CostType.PLANNED);
				estimatedCost.setValue(new BigDecimal(activityTaskInfo.getEstimatedCost()));
				estimatedCost.setExpiryDate(DateFormater.convertToDate("9999-12-31"));
				estimatedCost.setCreatedBy(new User(userId));
				estimatedCost.setCreatedDate(new Date());
				entityManager.persist(estimatedCost);

				PlannedActualsCost actualCost = new PlannedActualsCost();
				actualCost.setProjectTask(projectTask);
				actualCost.setFromDate(DateFormater.convertToDate(activityTaskInfo.getStartDate(), DateValidator.dateFormat));
				actualCost.setToDate(DateFormater.convertToDate(activityTaskInfo.getEndDate(), DateValidator.dateFormat));
				actualCost.setCostType(OnTargetConstant.CostType.ACTUAL);
				actualCost.setValue(new BigDecimal(activityTaskInfo.getActualCost()));
				actualCost.setExpiryDate(DateFormater.convertToDate("9999-12-31"));
				actualCost.setCreatedBy(new User(userId));
				actualCost.setCreatedDate(new Date());
				entityManager.persist(actualCost);

				persistLog(bulkActivityLog, activityInfo, activityTaskInfo);

				i++;
				if (i % batchSize == 0) {
					entityManager.flush();
					entityManager.clear();
				}
			}
		}
		if (invalidActivityRecords != null && !invalidActivityRecords.isEmpty()) {
			for (ActivityTaskRecord activityTaskRecord : invalidActivityRecords) {
				persistInvalidLog(bulkActivityLog, activityTaskRecord);
			}
		}
		entityManager.flush();
		entityManager.clear();

		return true;
	}

	private void persistLog(BulkActivityLog bulkActivityLog, ActivityInfo activityInfo, ActivityTaskInfo activityTaskInfo) {
		BulkActivityAttribute activityCodeAttribute = new BulkActivityAttribute();
		activityCodeAttribute.setAttributeKey(BulkActivityAttributeConstant.activityCode);
		activityCodeAttribute.setAttributeValue(activityInfo.getActivityCode());
		activityCodeAttribute.setBulkActivityLog(bulkActivityLog);
		activityCodeAttribute.setIndex(activityTaskInfo.getIndex());
		activityCodeAttribute.setValid("Y");
		entityManager.persist(activityCodeAttribute);

		BulkActivityAttribute activityNameAttribute = new BulkActivityAttribute();
		activityNameAttribute.setAttributeKey(BulkActivityAttributeConstant.activityName);
		activityNameAttribute.setAttributeValue(activityInfo.getActivityName());
		activityNameAttribute.setBulkActivityLog(bulkActivityLog);
		activityNameAttribute.setIndex(activityTaskInfo.getIndex());
		activityNameAttribute.setValid("Y");
		entityManager.persist(activityNameAttribute);

		BulkActivityAttribute activityStartDateAttribute = new BulkActivityAttribute();
		activityStartDateAttribute.setAttributeKey(BulkActivityAttributeConstant.activityStartDate);
		activityStartDateAttribute.setAttributeValue(activityInfo.getStartDate());
		activityStartDateAttribute.setBulkActivityLog(bulkActivityLog);
		activityStartDateAttribute.setIndex(activityTaskInfo.getIndex());
		activityStartDateAttribute.setValid("Y");
		entityManager.persist(activityStartDateAttribute);

		BulkActivityAttribute activityEndDateAttribute = new BulkActivityAttribute();
		activityEndDateAttribute.setAttributeKey(BulkActivityAttributeConstant.activityEndDate);
		activityEndDateAttribute.setAttributeValue(activityInfo.getEndDate());
		activityEndDateAttribute.setBulkActivityLog(bulkActivityLog);
		activityEndDateAttribute.setIndex(activityTaskInfo.getIndex());
		activityEndDateAttribute.setValid("Y");
		entityManager.persist(activityEndDateAttribute);

		BulkActivityAttribute taskCodeAttribute = new BulkActivityAttribute();
		taskCodeAttribute.setAttributeKey(BulkActivityAttributeConstant.taskCode);
		taskCodeAttribute.setAttributeValue(activityTaskInfo.getTaskCode());
		taskCodeAttribute.setBulkActivityLog(bulkActivityLog);
		taskCodeAttribute.setIndex(activityTaskInfo.getIndex());
		taskCodeAttribute.setValid("Y");
		entityManager.persist(taskCodeAttribute);

		BulkActivityAttribute taskNameAttribute = new BulkActivityAttribute();
		taskNameAttribute.setAttributeKey(BulkActivityAttributeConstant.taskName);
		taskNameAttribute.setAttributeValue(activityTaskInfo.getTaskName());
		taskNameAttribute.setBulkActivityLog(bulkActivityLog);
		taskNameAttribute.setIndex(activityTaskInfo.getIndex());
		taskNameAttribute.setValid("Y");
		entityManager.persist(taskNameAttribute);
		
		BulkActivityAttribute taskDescriptionAttribute = new BulkActivityAttribute();
		taskDescriptionAttribute.setAttributeKey(BulkActivityAttributeConstant.taskDescription);
		taskDescriptionAttribute.setAttributeValue(activityTaskInfo.getTaskDescription());
		taskDescriptionAttribute.setBulkActivityLog(bulkActivityLog);
		taskDescriptionAttribute.setIndex(activityTaskInfo.getIndex());
		taskDescriptionAttribute.setValid("Y");
		entityManager.persist(taskDescriptionAttribute);

		BulkActivityAttribute taskStartDateAttribute = new BulkActivityAttribute();
		taskStartDateAttribute.setAttributeKey(BulkActivityAttributeConstant.taskStartDate);
		taskStartDateAttribute.setAttributeValue(activityTaskInfo.getStartDate());
		taskStartDateAttribute.setBulkActivityLog(bulkActivityLog);
		taskStartDateAttribute.setIndex(activityTaskInfo.getIndex());
		taskStartDateAttribute.setValid("Y");
		entityManager.persist(taskStartDateAttribute);

		BulkActivityAttribute taskEndDateAttribute = new BulkActivityAttribute();
		taskEndDateAttribute.setAttributeKey(BulkActivityAttributeConstant.taskEndDate);
		taskEndDateAttribute.setAttributeValue(activityTaskInfo.getEndDate());
		taskEndDateAttribute.setBulkActivityLog(bulkActivityLog);
		taskEndDateAttribute.setIndex(activityTaskInfo.getIndex());
		taskEndDateAttribute.setValid("Y");
		entityManager.persist(taskEndDateAttribute);

		BulkActivityAttribute percentageCompleteAttribute = new BulkActivityAttribute();
		percentageCompleteAttribute.setAttributeKey(BulkActivityAttributeConstant.percentageComplete);
		percentageCompleteAttribute.setAttributeValue(activityTaskInfo.getPercentageComplete());
		percentageCompleteAttribute.setBulkActivityLog(bulkActivityLog);
		percentageCompleteAttribute.setIndex(activityTaskInfo.getIndex());
		percentageCompleteAttribute.setValid("Y");
		entityManager.persist(percentageCompleteAttribute);

		BulkActivityAttribute actualCostAttribute = new BulkActivityAttribute();
		actualCostAttribute.setAttributeKey(BulkActivityAttributeConstant.actualCost);
		actualCostAttribute.setAttributeValue(activityTaskInfo.getActualCost());
		actualCostAttribute.setBulkActivityLog(bulkActivityLog);
		actualCostAttribute.setIndex(activityTaskInfo.getIndex());
		actualCostAttribute.setValid("Y");
		entityManager.persist(actualCostAttribute);

		BulkActivityAttribute estimatedCostAttribute = new BulkActivityAttribute();
		estimatedCostAttribute.setAttributeKey(BulkActivityAttributeConstant.estimatedCost);
		estimatedCostAttribute.setAttributeValue(activityTaskInfo.getEstimatedCost());
		estimatedCostAttribute.setBulkActivityLog(bulkActivityLog);
		estimatedCostAttribute.setIndex(activityTaskInfo.getIndex());
		estimatedCostAttribute.setValid("Y");
		entityManager.persist(estimatedCostAttribute);
	}

	private void persistInvalidLog(BulkActivityLog bulkActivityLog, ActivityTaskRecord activityTaskRecord) {
		BulkActivityAttribute activityCodeAttribute = new BulkActivityAttribute();
		activityCodeAttribute.setAttributeKey(BulkActivityAttributeConstant.activityCode);
		activityCodeAttribute.setAttributeValue(activityTaskRecord.getActivityCode());
		activityCodeAttribute.setBulkActivityLog(bulkActivityLog);
		activityCodeAttribute.setIndex(activityTaskRecord.getIndex());
		activityCodeAttribute.setValid("N");
		entityManager.persist(activityCodeAttribute);

		BulkActivityAttribute activityNameAttribute = new BulkActivityAttribute();
		activityNameAttribute.setAttributeKey(BulkActivityAttributeConstant.activityName);
		activityNameAttribute.setAttributeValue(activityTaskRecord.getActivityName());
		activityNameAttribute.setBulkActivityLog(bulkActivityLog);
		activityNameAttribute.setIndex(activityTaskRecord.getIndex());
		activityNameAttribute.setValid("N");
		entityManager.persist(activityNameAttribute);

		BulkActivityAttribute activityStartDateAttribute = new BulkActivityAttribute();
		activityStartDateAttribute.setAttributeKey(BulkActivityAttributeConstant.activityStartDate);
		activityStartDateAttribute.setAttributeValue(activityTaskRecord.getActivityStartDate());
		activityStartDateAttribute.setBulkActivityLog(bulkActivityLog);
		activityStartDateAttribute.setIndex(activityTaskRecord.getIndex());
		activityStartDateAttribute.setValid("N");
		entityManager.persist(activityStartDateAttribute);

		BulkActivityAttribute activityEndDateAttribute = new BulkActivityAttribute();
		activityEndDateAttribute.setAttributeKey(BulkActivityAttributeConstant.activityEndDate);
		activityEndDateAttribute.setAttributeValue(activityTaskRecord.getActivityEndDate());
		activityEndDateAttribute.setBulkActivityLog(bulkActivityLog);
		activityEndDateAttribute.setIndex(activityTaskRecord.getIndex());
		activityEndDateAttribute.setValid("N");
		entityManager.persist(activityEndDateAttribute);

		BulkActivityAttribute taskCodeAttribute = new BulkActivityAttribute();
		taskCodeAttribute.setAttributeKey(BulkActivityAttributeConstant.taskCode);
		taskCodeAttribute.setAttributeValue(activityTaskRecord.getTaskCode());
		taskCodeAttribute.setBulkActivityLog(bulkActivityLog);
		taskCodeAttribute.setIndex(activityTaskRecord.getIndex());
		taskCodeAttribute.setValid("N");
		entityManager.persist(taskCodeAttribute);

		BulkActivityAttribute taskNameAttribute = new BulkActivityAttribute();
		taskNameAttribute.setAttributeKey(BulkActivityAttributeConstant.taskName);
		taskNameAttribute.setAttributeValue(activityTaskRecord.getTaskName());
		taskNameAttribute.setBulkActivityLog(bulkActivityLog);
		taskNameAttribute.setIndex(activityTaskRecord.getIndex());
		taskNameAttribute.setValid("N");
		entityManager.persist(taskNameAttribute);
		
		BulkActivityAttribute taskDescriptionAttribute = new BulkActivityAttribute();
		taskDescriptionAttribute.setAttributeKey(BulkActivityAttributeConstant.taskDescription);
		taskDescriptionAttribute.setAttributeValue(activityTaskRecord.getTaskDescription());
		taskDescriptionAttribute.setBulkActivityLog(bulkActivityLog);
		taskDescriptionAttribute.setIndex(activityTaskRecord.getIndex());
		taskDescriptionAttribute.setValid("N");
		entityManager.persist(taskDescriptionAttribute);

		BulkActivityAttribute taskStartDateAttribute = new BulkActivityAttribute();
		taskStartDateAttribute.setAttributeKey(BulkActivityAttributeConstant.taskStartDate);
		taskStartDateAttribute.setAttributeValue(activityTaskRecord.getTaskStartDate());
		taskStartDateAttribute.setBulkActivityLog(bulkActivityLog);
		taskStartDateAttribute.setIndex(activityTaskRecord.getIndex());
		taskStartDateAttribute.setValid("N");
		entityManager.persist(taskStartDateAttribute);

		BulkActivityAttribute taskEndDateAttribute = new BulkActivityAttribute();
		taskEndDateAttribute.setAttributeKey(BulkActivityAttributeConstant.taskEndDate);
		taskEndDateAttribute.setAttributeValue(activityTaskRecord.getTaskEndDate());
		taskEndDateAttribute.setBulkActivityLog(bulkActivityLog);
		taskEndDateAttribute.setIndex(activityTaskRecord.getIndex());
		taskEndDateAttribute.setValid("N");
		entityManager.persist(taskEndDateAttribute);

		BulkActivityAttribute percentageCompleteAttribute = new BulkActivityAttribute();
		percentageCompleteAttribute.setAttributeKey(BulkActivityAttributeConstant.percentageComplete);
		percentageCompleteAttribute.setAttributeValue(activityTaskRecord.getPercentageComplete());
		percentageCompleteAttribute.setBulkActivityLog(bulkActivityLog);
		percentageCompleteAttribute.setIndex(activityTaskRecord.getIndex());
		percentageCompleteAttribute.setValid("N");
		entityManager.persist(percentageCompleteAttribute);

		BulkActivityAttribute actualCostAttribute = new BulkActivityAttribute();
		actualCostAttribute.setAttributeKey(BulkActivityAttributeConstant.actualCost);
		actualCostAttribute.setAttributeValue(activityTaskRecord.getActualCost());
		actualCostAttribute.setBulkActivityLog(bulkActivityLog);
		actualCostAttribute.setIndex(activityTaskRecord.getIndex());
		actualCostAttribute.setValid("N");
		entityManager.persist(actualCostAttribute);

		BulkActivityAttribute estimatedCostAttribute = new BulkActivityAttribute();
		estimatedCostAttribute.setAttributeKey(BulkActivityAttributeConstant.estimatedCost);
		estimatedCostAttribute.setAttributeValue(activityTaskRecord.getEstimatedCost());
		estimatedCostAttribute.setBulkActivityLog(bulkActivityLog);
		estimatedCostAttribute.setIndex(activityTaskRecord.getIndex());
		estimatedCostAttribute.setValid("N");
		entityManager.persist(estimatedCostAttribute);
	}

	@Override
	public Map<String, TaskPriority> getTaskPriorityMap() {
		List<TaskPriority> taskPriorityList = taskPriorityRepository.getAllTaskPriority();
		Map taskPriorityMap = new HashMap<String, TaskPriority>();
		for (TaskPriority taskPriority : taskPriorityList) {
			taskPriorityMap.put(taskPriority.getCode(), taskPriority);
		}
		return taskPriorityMap;
	}

}
