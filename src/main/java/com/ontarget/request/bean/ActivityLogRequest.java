package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "pageNumber", "perPageLimit", "projectId" })
public class ActivityLogRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("projectId")
	private Integer projectId;
	@NotNull
	@JsonProperty("pageNumber")
	private Integer pageNumber;
	@NotNull
	@JsonProperty("perPageLimit")
	private Integer perPageLimit;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("pageNumber")
	public Integer getPageNumber() {
		return pageNumber;
	}

	@JsonProperty("pageNumber")
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@JsonProperty("perPageLimit")
	public Integer getPerPageLimit() {
		return perPageLimit;
	}

	@JsonProperty("perPageLimit")
	public void setPerPageLimit(Integer perPageLimit) {
		this.perPageLimit = perPageLimit;
	}

	@JsonProperty("projectId")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("projectId")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
}
