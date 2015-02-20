package com.ontarget.request.bean;

import java.util.Date;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "taskId", "fromDate", "toDate", "costType", "cost",
		"month", "year" })
public class TaskBudgetEstimate {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("taskId")
	private Integer taskId;
	@JsonProperty("fromDate")
	private Date fromDate;
	@JsonProperty("toDate")
	private Date toDate;
	@JsonProperty("costType")
	private String costType;
	@JsonProperty("cost")
	private Double cost;
	@JsonProperty("month")
	private Integer month;
	@JsonProperty("year")
	private Integer year;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("taskId")
	public Integer getTaskId() {
		return taskId;
	}

	@JsonProperty("taskId")
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@JsonProperty("fromDate")
	public Date getFromDate() {
		return fromDate;
	}

	@JsonProperty("fromDate")
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@JsonProperty("toDate")
	public Date getToDate() {
		return toDate;
	}

	@JsonProperty("toDate")
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@JsonProperty("costType")
	public String getCostType() {
		return costType;
	}

	@JsonProperty("costType")
	public void setCostType(String costType) {
		this.costType = costType;
	}

	@JsonProperty("cost")
	public Double getCost() {
		return cost;
	}

	@JsonProperty("cost")
	public void setCost(Double cost) {
		this.cost = cost;
	}

	@JsonProperty("month")
	public Integer getMonth() {
		return month;
	}

	@JsonProperty("month")
	public void setMonth(Integer month) {
		this.month = month;
	}

	@JsonProperty("year")
	public Integer getYear() {
		return year;
	}

	@JsonProperty("year")
	public void setYear(Integer year) {
		this.year = year;
	}

}
