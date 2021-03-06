package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY)
public class ProjectTaskInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer projectTaskId;
	private String title;
	private String description;
	private String status;
	private String severity;
	private Double cost;
	private Integer numberOfWorkers;
	private Integer percentageComplete;
	private String startDateText;
	private String endDateText;

	private Integer creatorId;
	private Integer modifierId;

	private Date startDate;
	private Date endDate;
	private boolean completed;
	private Integer projectId;
	private List<TaskEstimatedCostByMonthYear> costsByMonthYear;

	public Integer getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(Integer projectTaskId) {
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

	public Integer getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(Integer numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

	public Integer getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(Integer percentageComplete) {
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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public List<TaskEstimatedCostByMonthYear> getCostsByMonthYear() {
		return costsByMonthYear;
	}

	public void setCostsByMonthYear(List<TaskEstimatedCostByMonthYear> costsByMonthYear) {
		this.costsByMonthYear = costsByMonthYear;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public Integer getModifierId() {
		return modifierId;
	}

	public void setModifierId(Integer modifierId) {
		this.modifierId = modifierId;
	}

}
