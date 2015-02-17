package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "userId", "task" })
public class TaskRequest {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("userId")
	private Integer userId;
	@JsonProperty("task")
	private Task task;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	/**
	 * 
	 * @return The userId
	 */
	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 *            The userId
	 */
	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @return The task
	 */
	@JsonProperty("task")
	public Task getTask() {
		return task;
	}

	/**
	 * 
	 * @param task
	 *            The task
	 */
	@JsonProperty("task")
	public void setTask(Task task) {
		this.task = task;
	}
}