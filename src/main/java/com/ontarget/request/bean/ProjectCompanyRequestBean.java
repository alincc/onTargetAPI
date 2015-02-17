package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId", "companyId" })
public class ProjectCompanyRequestBean {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("projectId")
	private Integer projectId;
	@JsonProperty("companyId")
	private Integer companyId;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("projectId")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("projectId")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@JsonProperty("companyId")
	public Integer getCompanyId() {
		return companyId;
	}

	@JsonProperty("companyId")
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
}
