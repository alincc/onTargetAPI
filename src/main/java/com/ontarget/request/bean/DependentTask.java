package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "taskId", "dependentTaskId", "categoryId" })
public class DependentTask {
	@NotNull
	@JsonProperty("taskId")
	private Integer taskId;
	@NotNull
	@JsonProperty("dependentTaskId")
	private Integer dependentTaskId;
	@NotNull
	@JsonProperty("categoryId")
	private Integer categoryId;

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

	/**
	 * 
	 * @return The dependentTaskId
	 */
	@JsonProperty("dependentTaskId")
	public Integer getDependentTaskId() {
		return dependentTaskId;
	}

	/**
	 * 
	 * @param dependentTaskId
	 *            The dependentTaskId
	 */
	@JsonProperty("dependentTaskId")
	public void setDependentTaskId(Integer dependentTaskId) {
		this.dependentTaskId = dependentTaskId;
	}

	/**
	 * 
	 * @return The categoryId
	 */
	@JsonProperty("categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * 
	 * @param categoryId
	 *            The categoryId
	 */
	@JsonProperty("categoryId")
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}
