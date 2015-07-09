package com.ontarget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ontarget.bean.TaskComment;
import com.ontarget.bean.UserDTO;

public class ProjectTask implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private String status;
	private String severity;
	private Integer projectTaskId;
	private Date startDate;
	private Date endDate;
	private boolean completed;
	private List<ProjectTask> childTasks;
	private List<UserDTO> assignee;
	private List<TaskComment> comments;
	private double percentageComplete;

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

	public Integer getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
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

	public List<ProjectTask> getChildTasks() {
		return childTasks;
	}

	public void setChildTasks(List<ProjectTask> childTasks) {
		this.childTasks = childTasks;
	}

	public List<UserDTO> getAssignee() {
		return assignee;
	}

	public void setAssignee(List<UserDTO> assignee) {
		this.assignee = assignee;
	}

	public List<TaskComment> getComments() {
		return comments;
	}

	public void setComments(List<TaskComment> comments) {
		this.comments = comments;
	}

	public double getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

}
