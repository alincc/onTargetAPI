package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Owner on 11/17/14.
 */
public class TaskEstimatedCost implements Serializable {

	private Integer id;
	private Date fromDate;
	private Date toDate;
	private String costType; // PLANNED OR ESTIMATED
	private Double cost;
	private Integer month;
	private Integer year;
	private Integer createdBy;
	private Integer modifiedBy;
	private Integer taskId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Override
	public String toString() {
		return "TaskEstimatedCost{" + "taskid=" + taskId + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", costType='" + costType
				+ '\'' + ", cost=" + cost + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TaskEstimatedCost))
			return false;

		TaskEstimatedCost cost1 = (TaskEstimatedCost) o;

		if (id != cost1.id)
			return false;
		if (month != cost1.month)
			return false;
		if (year != cost1.year)
			return false;
		if (!cost.equals(cost1.cost))
			return false;
		if (!costType.equals(cost1.costType))
			return false;
		if (!fromDate.equals(cost1.fromDate))
			return false;
		if (!toDate.equals(cost1.toDate))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + fromDate.hashCode();
		result = 31 * result + toDate.hashCode();
		result = 31 * result + costType.hashCode();
		result = 31 * result + cost.hashCode();
		result = 31 * result + month;
		result = 31 * result + year;
		return result;
	}

}
