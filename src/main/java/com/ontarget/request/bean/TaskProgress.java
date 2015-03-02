package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "percentageType", "percentageComplete", "taskId" })
public class TaskProgress {
	@NotEmpty
	@JsonProperty("percentageType")
	private String percentageType;
	@NotNull
	@JsonProperty("percentageComplete")
	private Double percentageComplete;
	@NotNull
	@JsonProperty("taskId")
	private Integer taskId;

	/**
	 * 
	 * @return The percentageType
	 */
	@JsonProperty("percentageType")
	public String getPercentageType() {
		return percentageType;
	}

	/**
	 * 
	 * @param percentageType
	 *            The percentageType
	 */
	@JsonProperty("percentageType")
	public void setPercentageType(String percentageType) {
		this.percentageType = percentageType;
	}

	/**
	 * 
	 * @return The percentageComplete
	 */
	@JsonProperty("percentageComplete")
	public Double getPercentageComplete() {
		return percentageComplete;
	}

	/**
	 * 
	 * @param percentageComplete
	 *            The percentageComplete
	 */
	@JsonProperty("percentageComplete")
	public void setPercentageComplete(Double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	/**
	 * 
	 * @return The taskId
	 */
	@JsonProperty("taskId")
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * 
	 * @param taskId
	 *            The taskId
	 */
	@JsonProperty("taskId")
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

}