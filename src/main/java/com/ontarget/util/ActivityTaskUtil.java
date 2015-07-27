package com.ontarget.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ontarget.api.validator.ActivityTaskValidator;
import com.ontarget.bean.ActivityInfo;
import com.ontarget.bean.ActivityTaskInfo;
import com.ontarget.entities.Project;
import com.ontarget.entities.TaskPriority;
import com.ontarget.request.bean.ActivityTaskRecord;

public class ActivityTaskUtil {
	private List<ActivityTaskRecord> invalidActivityTaskRecords;
	private Project project;
	private Logger logger = Logger.getLogger(ActivityTaskUtil.class);

	public ActivityTaskUtil(Project project) {
		this.invalidActivityTaskRecords = new ArrayList<>();
		this.project = project;
	}

	public List<ActivityInfo> getActivityTaskList(List<ActivityTaskRecord> activityTaskRecords, Map<String, TaskPriority> taskPriorityMap) {
		List<ActivityInfo> activityInfoList = new ArrayList<>();

		Map<String, ActivityInfo> activityTaskMap = new LinkedHashMap<>();

		for (ActivityTaskRecord activityTaskRecord : activityTaskRecords) {
			ActivityTaskValidator activityTaskValidator = new ActivityTaskValidator(activityTaskRecord, project);
			activityTaskValidator.validate();

			if (!activityTaskValidator.isValid()) {
				invalidActivityTaskRecords.add(activityTaskValidator.getActivityTaskRecord());
				continue;
			}
			ActivityTaskInfo activityTaskInfo = new ActivityTaskInfo();

			TaskPriority taskPriority = taskPriorityMap.get(activityTaskRecord.getPriority());
			if (taskPriority == null) {
				activityTaskRecord.setInvalidMsg("task priority is not valid");
				invalidActivityTaskRecords.add(activityTaskRecord);
				continue;
			}
			activityTaskInfo.setPriority(taskPriority.getTaskPriorityId());

			activityTaskInfo.setTaskCode(activityTaskRecord.getTaskCode());
			activityTaskInfo.setTaskName(activityTaskRecord.getTaskName());
			activityTaskInfo.setTaskDescription(activityTaskRecord.getTaskDescription());
			activityTaskInfo.setStartDate(activityTaskRecord.getTaskStartDate());
			activityTaskInfo.setEndDate(activityTaskRecord.getTaskEndDate());
			activityTaskInfo.setPercentageComplete(activityTaskRecord.getPercentageComplete());
			activityTaskInfo.setEstimatedCost(activityTaskRecord.getEstimatedCost());
			activityTaskInfo.setActualCost(activityTaskRecord.getActualCost());
			activityTaskInfo.setIndex(activityTaskRecord.getIndex());

			if (!activityTaskMap.containsKey(activityTaskRecord.getActivityCode())) {
				ActivityInfo activityInfo = new ActivityInfo();
				activityInfo.setActivityCode(activityTaskRecord.getActivityCode());
				activityInfo.setActivityName(activityTaskRecord.getActivityName());
				activityInfo.setStartDate(activityTaskRecord.getActivityStartDate());
				activityInfo.setEndDate(activityTaskRecord.getActivityEndDate());
				activityInfo.addTask(activityTaskInfo);

				activityTaskMap.put(activityInfo.getActivityCode(), activityInfo);
			} else {
				ActivityInfo activityInfo = activityTaskMap.get(activityTaskRecord.getActivityCode());
				activityInfo.addTask(activityTaskInfo);
			}
		}
		activityInfoList = ActivityTaskUtil.convertMapToList(activityTaskMap);
		logger.info(activityInfoList);
		return activityInfoList;
	}

	public static List<ActivityInfo> convertMapToList(Map<String, ActivityInfo> map) {
		ArrayList dataList = new ArrayList(map.entrySet());
		List<ActivityInfo> activityInfoList = new ArrayList<>();

		Iterator i = dataList.iterator();
		while (i.hasNext()) {
			Map.Entry pairs = (Map.Entry) i.next();
			activityInfoList.add((ActivityInfo) pairs.getValue());
		}
		return activityInfoList;
	}

	public List<ActivityTaskRecord> getInvalidActivityTaskRecords() {
		return invalidActivityTaskRecords;
	}

}
