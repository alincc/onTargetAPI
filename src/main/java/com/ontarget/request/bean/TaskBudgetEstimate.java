package com.ontarget.request.bean;

import java.sql.Date;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "taskId", "fromDate", "toDate", "costType", "cost" })
public class TaskBudgetEstimate {

	@JsonProperty("id")
	private Integer id;
	@NotNull
	@JsonProperty("taskId")
	private Integer taskId;
	@NotNull
	@JsonProperty("fromDate")
	private Date fromDate;
	@NotNull
	@JsonProperty("toDate")
	private Date toDate;
	@NotNull
	@JsonProperty("costType")
	private String costType;
	@NotNull
	@JsonProperty("cost")
	private Double cost;

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
}
