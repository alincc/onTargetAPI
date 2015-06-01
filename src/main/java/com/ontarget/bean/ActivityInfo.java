package com.ontarget.bean;

import java.util.ArrayList;
import java.util.List;

public class ActivityInfo {
	private String activityCode;
	private String activityName;
	private String startDate;
	private String endDate;
	private List<ActivityTaskInfo> taskList;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public List<ActivityTaskInfo> getTaskList() {
		if (taskList == null) {
			taskList = new ArrayList<ActivityTaskInfo>();
		}
		return taskList;
	}

	public void setTaskList(List<ActivityTaskInfo> taskList) {
		this.taskList = taskList;
	}

	public void addTask(ActivityTaskInfo activityTaskInfo) {
		if (taskList == null) {
			taskList = new ArrayList<>();
		}
		taskList.add(activityTaskInfo);
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("activityCode : "+activityCode);
		sb.append(",activityName : "+activityName);
		sb.append(",task: "+taskList);
		return sb.toString();
	}

}
