package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY)
public class TaskInfo implements Serializable {
	private int projectTaskId;
	private String title;
	private String description;
	private String status;
	private String severity;
	private Double cost;
	private int numberOfWorkers;
	private double percentageComplete;
	private String startDateText;
	private String endDateText;

	private Date startDate;
	private Date endDate;
	private boolean completed;
	private UserDTO assignedTo;

	private List<UserDTO> assignee;

	private ProjectDTO project;
	private TaskInfo parentTask;
	private List<TaskComment> comments;

	private List<TaskEstimatedCost> costs;
	private List<TaskInfo> childTasks;
	private List<TaskEstimatedCostByMonthYear> costsByMonthYear;

	public int getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(int projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public int getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(int numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

	public double getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public String getStartDateText() {
		return startDateText;
	}

	public void setStartDateText(String startDateText) {
		this.startDateText = startDateText;
	}

	public String getEndDateText() {
		return endDateText;
	}

	public void setEndDateText(String endDateText) {
		this.endDateText = endDateText;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public UserDTO getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(UserDTO assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<UserDTO> getAssignee() {
		return assignee;
	}

	public void setAssignee(List<UserDTO> assignee) {
		this.assignee = assignee;
	}

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public TaskInfo getParentTask() {
		return parentTask;
	}

	public void setParentTask(TaskInfo parentTask) {
		this.parentTask = parentTask;
	}

	public List<TaskComment> getComments() {
		return comments;
	}

	public void setComments(List<TaskComment> comments) {
		this.comments = comments;
	}

	public List<TaskEstimatedCost> getCosts() {
		return costs;
	}

	public void setCosts(List<TaskEstimatedCost> costs) {
		this.costs = costs;
	}

	public List<TaskInfo> getChildTasks() {
		return childTasks;
	}

	public void setChildTasks(List<TaskInfo> childTasks) {
		this.childTasks = childTasks;
	}

	public List<TaskEstimatedCostByMonthYear> getCostsByMonthYear() {
		return costsByMonthYear;
	}

	public void setCostsByMonthYear(
			List<TaskEstimatedCostByMonthYear> costsByMonthYear) {
		this.costsByMonthYear = costsByMonthYear;
	}

}
