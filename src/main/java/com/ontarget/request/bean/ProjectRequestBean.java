package com.ontarget.request.bean;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "project", "baseRequest", "user" })
public class ProjectRequestBean {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("project")
	private ProjectBean project;
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
	public ProjectBean getProject() {
		return project;
	}

	/**
	 * 
	 * @param project
	 *            The project
	 */
	@JsonProperty("project")
	public void setProject(ProjectBean project) {
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