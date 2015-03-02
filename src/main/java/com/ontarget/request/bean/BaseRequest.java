package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "loggedInUserId", "loggedInUserprojectId" })
public class BaseRequest {
	@NotNull
	@JsonProperty("loggedInUserId")
	private Integer loggedInUserId;
	@NotNull
	@JsonProperty("loggedInUserProjectId")
	private Integer loggedInUserProjectId;

	/**
	 * 
	 * @return The loggedInUserId
	 */
	@JsonProperty("loggedInUserId")
	public Integer getLoggedInUserId() {
		return loggedInUserId;
	}

	/**
	 * 
	 * @param loggedInUserId
	 *            The loggedInUserId
	 */
	@JsonProperty("loggedInUserId")
	public void setLoggedInUserId(Integer loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}

	/**
	 * 
	 * @return The loggedInUserprojectId
	 */
	@JsonProperty("loggedInUserprojectId")
	public Integer getLoggedInUserProjectId() {
		return loggedInUserProjectId;
	}

	/**
	 * 
	 * @param loggedInUserprojectId
	 *            The loggedInUserprojectId
	 */
	@JsonProperty("loggedInUserprojectId")
	public void setLoggedInUserProjectId(Integer loggedInUserprojectId) {
		this.loggedInUserProjectId = loggedInUserprojectId;
	}
}
