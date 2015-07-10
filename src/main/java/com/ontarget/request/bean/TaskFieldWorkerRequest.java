package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "taskId" })
public class TaskFieldWorkerRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("taskId")
	private Integer taskId;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("taskId")
	public Integer getTaskId() {
		return taskId;
	}

	@JsonProperty("taskId")
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

}
