package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "dependentTask" })
public class DependentTaskRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@Valid
	@JsonProperty("dependentTask")
	private DependentTask dependentTask;

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
	 * @return The dependentTask
	 */
	@JsonProperty("dependentTask")
	public DependentTask getDependentTask() {
		return dependentTask;
	}

	/**
	 * 
	 * @param dependentTask
	 *            The dependentTask
	 */
	@JsonProperty("dependentTask")
	public void setDependentTask(DependentTask dependentTask) {
		this.dependentTask = dependentTask;
	}

}