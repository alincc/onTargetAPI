package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "userId", "username" })
public class Assignee {
	@NotNull
	@JsonProperty("userId")
	private Integer userId;
	@JsonProperty("username")
	private String username;

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

}
