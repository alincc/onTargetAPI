package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.api.repository.TaskPercentageLogRepository;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.TaskPercentageLog;
import com.ontarget.entities.User;
import com.ontarget.request.bean.TaskProgress;
import com.ontarget.util.DateFormater;

@Repository("taskPercentageJpaDAOImpl")
public class TaskPercentageJpaDAOImpl implements TaskPercentageDAO {

	private Logger logger = Logger.getLogger(TaskPercentageJpaDAOImpl.class);

	@Resource
	private TaskPercentageLogRepository taskPercentageLogRepository;
	@Resource
	private ProjectTaskRepository projectTaskRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Map<ProjectTaskInfo, List<TaskPercentage>> getTaskPercentageCompletes(int projectId) throws Exception {
		logger.info("getting percentage for project Id: " + projectId);
		Map<ProjectTaskInfo, List<TaskPercentage>> taskToPercentageMap = new LinkedHashMap<>();

		jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE, new Object[] { projectId }, (resultSet, i) -> {
			TaskPercentage percentage = new TaskPercentage();
			percentage.setId(resultSet.getInt("task_percentage_log_id"));
			Date fromDate = resultSet.getDate("start_date");
			percentage.setFromDate(fromDate);
			percentage.setToDate(resultSet.getDate("end_date"));
			percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
			percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));

			int year = 0;
			int month = 0;
			if (fromDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH);
			}
			percentage.setMonth(month);
			percentage.setYear(year);

			ProjectTaskInfo task = new ProjectTaskInfo();
			task.setProjectTaskId(resultSet.getInt("project_task_id"));
			task.setTitle(resultSet.getString("title"));
			List<TaskPercentage> percentageList = taskToPercentageMap.get(task);
			if (percentageList == null) {
				percentageList = new ArrayList<>();
			}
			percentageList.add(percentage);

			// sorting by month and year using java 8 lambda
			// expression.
				Comparator<TaskPercentage> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
				Comparator<TaskPercentage> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(Integer.valueOf(o2.getMonth()));

				percentageList.stream().sorted(byYear.thenComparing(byMonth));

				taskToPercentageMap.put(task, percentageList);

				return null;
			});

		return taskToPercentageMap;
	}

	@Override
	public Map<TaskInfo, Map<TaskInterval, TaskPercentage>> getTaskPercentageCompletesByMonthYear(long projectId) throws Exception {
		logger.info("getting percentage for project Id: " + projectId);
		Map<TaskInfo, Map<TaskInterval, TaskPercentage>> taskToPercentageMap = new LinkedHashMap<>();

		jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE, new Object[] { projectId }, (resultSet, i) -> {
			TaskPercentage percentage = new TaskPercentage();
			percentage.setId(resultSet.getInt("task_percentage_log_id"));
			Date fromDate = resultSet.getDate("start_date");
			percentage.setFromDate(fromDate);
			percentage.setToDate(resultSet.getDate("end_date"));
			percentage.setTaskPercentageType(resultSet.getString("percentage_type"));
			percentage.setTaskPercentageComplete(resultSet.getDouble("percentage_complete"));

			int year = 0;
			int month = 0;
			if (fromDate != null) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
			}
			percentage.setMonth(month);
			percentage.setYear(year);

			TaskInfo task = new TaskInfo();
			task.setProjectTaskId(resultSet.getInt("project_task_id"));
			task.setTitle(resultSet.getString("title"));

			Map<TaskInterval, TaskPercentage> percentageMapByMonthYear = taskToPercentageMap.get(task);
			if (percentageMapByMonthYear == null) {
				percentageMapByMonthYear = new LinkedHashMap<>();
			}
			percentageMapByMonthYear.put(new TaskInterval(month, year), percentage);

			/**
			 * if percentage complete is zero for this month year, use the
			 * previous month/year
			 */
			double percentageComplete = percentage.getTaskPercentageComplete();
			while (percentageComplete == 0) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fromDate);
				cal.add(Calendar.MONTH, -1);

				year = cal.get(Calendar.YEAR);
				month = cal.get(Calendar.MONTH) + 1;
				fromDate = cal.getTime();

				TaskPercentage lastMonthPercentage = percentageMapByMonthYear.get(new TaskInterval(month, year));
				percentageComplete = lastMonthPercentage.getTaskPercentageComplete();
			}

			percentage.setTaskPercentageComplete(percentageComplete);

			taskToPercentageMap.put(task, percentageMapByMonthYear);
			return null;
		});
		return taskToPercentageMap;
	}

	@Override
	public int addTaskPercentageComplete(TaskProgress taskProgress, int addedBy) throws Exception {
		logger.info("Adding task percentage: " + taskProgress);

		TaskPercentageLog taskPercentageLog = new TaskPercentageLog();
		taskPercentageLog.setProjectTask(new ProjectTask(taskProgress.getTaskId()));
		taskPercentageLog.setStartDate(new Date());
		taskPercentageLog.setEndDate(DateFormater.convertToDate("9999-12-31"));
		taskPercentageLog.setPercentageType(taskProgress.getPercentageType());
		taskPercentageLog.setPercentageComplete(taskProgress.getPercentageComplete());
		taskPercentageLog.setCreatedBy(new User(addedBy));
		taskPercentageLog.setCreatedDate(new Date());
		taskPercentageLogRepository.save(taskPercentageLog);

		return taskPercentageLog.getTaskPercentageLogId();
	}

	@Override
	public int updateTaskPercentageComplete(TaskProgress taskProgress, int addedBy) throws Exception {
		logger.info("Updating task percentage: " + taskProgress);
		ProjectTask projectTask = projectTaskRepository.findByProjectTaskId(taskProgress.getTaskId());
		projectTask.setTaskPercentage(taskProgress.getPercentageComplete().intValue());
		projectTask.setModifiedBy(new User(addedBy));
		projectTask.setModifiedDate(new Date());
		projectTaskRepository.save(projectTask);
		return 1;
	}

	// @Override
	// public boolean updateTaskPercentageComplete(TaskProgressInfo
	// taskProgressOfTask, int modifiedBy) throws Exception {
	// TaskPercentageLog taskPercentageLog =
	// taskPercentageLogRepository.findByTaskPercentageLogId(taskProgressOfTask
	// .getTaskPercentageLogId());
	// taskPercentageLog.setPercentageComplete(taskProgressOfTask.getPercentageComplete());
	// taskPercentageLog.setModifiedBy(new User(modifiedBy));
	// taskPercentageLog.setModifiedDate(new Date());
	// taskPercentageLogRepository.save(taskPercentageLog);
	// return true;
	// }

	@Override
	public boolean expireTaskPercentage(int taskPercentageLogId) throws Exception {
		TaskPercentageLog taskPercentageLog = taskPercentageLogRepository.findByTaskPercentageLogId(taskPercentageLogId);
		taskPercentageLog.setEndDate(DateFormater.convertToDate("9999-12-31"));
		taskPercentageLogRepository.save(taskPercentageLog);
		return true;
	}

	@Override
	public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception {
		List<TaskPercentage> taskPercentageList = new ArrayList<>();

		String hql = "select tpl from TaskPercentageLog tpl where tpl.projectTask.projectTaskId = :projectTaskId"
				+ " order by tpl.createdDate desc";
		Query query = entityManager.createQuery(hql);
		query.setParameter("projectTaskId", projectTaskId);
		@SuppressWarnings("unchecked")
		List<TaskPercentageLog> logs = query.getResultList();

		if (logs != null && !logs.isEmpty()) {
			for (TaskPercentageLog taskPercentageLog : logs) {

				TaskPercentage percentage = new TaskPercentage();
				percentage.setId(taskPercentageLog.getTaskPercentageLogId());
				percentage.setFromDate(taskPercentageLog.getStartDate());
				percentage.setToDate(taskPercentageLog.getEndDate());
				percentage.setTaskPercentageType(taskPercentageLog.getPercentageType());
				percentage.setTaskPercentageComplete(taskPercentageLog.getPercentageComplete());
				percentage.setCreatedBy(String.valueOf(taskPercentageLog.getCreatedBy().getUserId()));

				int year = 0;
				int month = 0;
				if (percentage.getFromDate() != null) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(percentage.getFromDate());
					year = cal.get(Calendar.YEAR);
					month = cal.get(Calendar.MONTH) + 1;
				}
				percentage.setMonth(month);
				percentage.setYear(year);

				taskPercentageList.add(percentage);
				return taskPercentageList;
			}
		}

		return taskPercentageList;
	}

	@Override
	public TaskPercentage getExistingTaskPercentageForTheMonth(int taskId) throws Exception {
		logger.debug("Getting existing task percentage for task Id: " + taskId);
		TaskPercentage taskPercentage = new TaskPercentage();
		jdbcTemplate.query(OnTargetQuery.GET_TASK_PERCENTAGE_FOR_THIS_MONTH, new Object[] { taskId }, (resultSet, i) -> {
			taskPercentage.setId(resultSet.getInt("task_percentage_log_id"));
			return null;
		});

		return taskPercentage;
	}

}
