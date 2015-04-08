package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "project", "baseRequest", "user" })
public class ProjectRequest {
	// @NotNull
	// @Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@Valid
	@JsonProperty("project")
	private ProjectDetailInfo project;
	@NotNull
	@JsonProperty("userId")
	private Integer userId;
	@JsonProperty("accountStatus")
	private String accountStatus;

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
	 * @return The project
	 */
	@JsonProperty("project")
	public ProjectDetailInfo getProject() {
		return project;
	}

	/**
	 * 
	 * @param project
	 *            The project
	 */
	@JsonProperty("project")
	public void setProject(ProjectDetailInfo project) {
		this.project = project;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("accountStatus")
	public String getAccountStatus() {
		return accountStatus;
	}

	@JsonProperty("accountStatus")
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}