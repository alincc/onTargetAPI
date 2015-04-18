package com.ontarget.request.bean;

import javax.annotation.Generated;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "index", "activityCode", "activityName", "taskCode", "taskName", "activityStartDate", "activityEndDate",
		"taskStartDate", "taskEndDate", "estimatedCost", "actualCost", "percentageComplete", "priority" })
public class ActivityTaskRecord {
	@NotEmpty
	@JsonProperty("index")
	private String index;
	@NotEmpty
	@JsonProperty("activityCode")
	private String activityCode;
	@NotEmpty
	@JsonProperty("activityName")
	private String activityName;
	@NotEmpty
	@JsonProperty("activityStartDate")
	private String activityStartDate;
	@NotEmpty
	@JsonProperty("activityEndDate")
	private String activityEndDate;
	@NotEmpty
	@JsonProperty("taskCode")
	private String taskCode;
	@NotEmpty
	@JsonProperty("taskName")
	private String taskName;
	@NotEmpty
	@JsonProperty("taskStartDate")
	private String taskStartDate;
	@NotEmpty
	@JsonProperty("taskEndDate")
	private String taskEndDate;
	@NotEmpty
	@JsonProperty("estimatedCost")
	private String estimatedCost;
	@NotEmpty
	@JsonProperty("actualCost")
	private String actualCost;
	@NotEmpty
	@JsonProperty("percentageComplete")
	private String percentageComplete;
	@NotEmpty
	@JsonProperty("priority")
	private String priority;

	private String invalidMsg;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
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

	public String getActivityStartDate() {
		return activityStartDate;
	}

	public void setActivityStartDate(String activityStartDate) {
		this.activityStartDate = activityStartDate;
	}

	public String getActivityEndDate() {
		return activityEndDate;
	}

	public void setActivityEndDate(String activityEndDate) {
		this.activityEndDate = activityEndDate;
	}

	public String getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public String getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
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

	public String getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(String percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getInvalidMsg() {
		return invalidMsg;
	}

	public void setInvalidMsg(String invalidMsg) {
		this.invalidMsg = invalidMsg;
	}

}
