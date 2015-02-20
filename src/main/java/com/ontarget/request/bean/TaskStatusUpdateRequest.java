package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "taskId", "taskStatus" })
public class TaskStatusUpdateRequest {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("taskId")
	private Integer taskId;
	@JsonProperty("taskStatus")
	private String taskStatus;

	/**
	 * 
	 * @return The baseRequest
	 */
	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	/**
	 * 
	 * @param baseRequest
	 *            The baseRequest
	 */
	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
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

	/**
	 * 
	 * @return The taskStatus
	 */
	@JsonProperty("taskStatus")
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * 
	 * @param taskStatus
	 *            The taskStatus
	 */
	@JsonProperty("taskStatus")
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

}