package com.ontarget.bean;

public class ActivityTaskInfo {
	private String taskCode;
	private String taskName;
	private String startDate;
	private String endDate;
	private String percentageComplete;
	private String estimatedCost;
	private String actualCost;
	private String index;
	private String priority;

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

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

	public String getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(String percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public String getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public String getActualCost() {
		return actualCost;
	}

	public void setActualCost(String actualCost) {
		this.actualCost = actualCost;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("taskCode : " + taskCode);
		sb.append(",taskName : " + taskName);
		sb.append(",startDate: " + startDate);
		sb.append(",endDate: " + endDate);
		sb.append(",percentageCompleed : " + percentageComplete);
		sb.append(",estimatedCost: " + estimatedCost);
		sb.append(",actualCost: " + actualCost);
		sb.append(",index : " + index);
		return sb.toString();
	}

}
