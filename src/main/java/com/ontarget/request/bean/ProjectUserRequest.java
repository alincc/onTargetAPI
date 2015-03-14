package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "userId" })
public class ProjectUserRequest {
	@NotNull
	@JsonProperty("userId")
	private Integer userId;

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
}
