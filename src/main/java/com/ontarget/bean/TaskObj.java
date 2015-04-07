package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY)
public class TaskObj implements Serializable {
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

	private Date startDate;
	private Date endDate;
	private boolean completed;

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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		TaskObj task = (TaskObj) o;

		// if (Double.compare(task.cost, cost) != 0) return false;
		// if (percentageComplete != task.percentageComplete) return false;
		// if (projectTaskId != thi.projectTaskId)
		// return false;
		// if (description != null ? !description.equals(task.description) :
		// task.description != null) return false;
		// if (!endDate.equals(task.endDate)) return false;
		// if (!severity.equals(task.severity)) return false;
		// if (!startDate.equals(task.startDate)) return false;
		// if (!status.equals(task.status)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = projectTaskId;
		// result = 31 * result + title.hashCode();
		/*
		 * result = 31 * result + (description != null ? description.hashCode()
		 * : 0); result = 31 * result + status.hashCode(); result = 31 * result
		 * + severity.hashCode(); temp = Double.doubleToLongBits(cost); result =
		 * 31 * result + (int) (temp ^ (temp >>> 32)); result = 31 * result +
		 * percentageComplete; result = 31 * result + startDate.hashCode();
		 * result = 31 * result + endDate.hashCode();
		 */
		return result;
	}

	@Override
	public String toString() {
		return "Task{" + "projectTaskId=" + projectTaskId + ", title='" + title + '\'' + ", description='" + description + '\''
				+ ", status='" + status + '\'' + ", severity='" + severity + '\'' + ", cost=" + cost + ", numberOfWorkers="
				+ numberOfWorkers + ", percentageComplete=" + percentageComplete + ", startDateText='" + startDateText + '\''
				+ ", endDateText='" + endDateText + '\'' + ", startDate=" + startDate + ", endDate=" + endDate + '}';
	}

}
