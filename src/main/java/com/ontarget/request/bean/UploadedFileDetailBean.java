package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId" })
public class UploadedFileDetailBean {
	@JsonProperty("baseRequest")
	private BaseRequestBean baseRequest;
	@JsonProperty("projectId")
	private Integer projectId;

	public BaseRequestBean getBaseRequest() {
		return baseRequest;
	}

	public void setBaseRequest(BaseRequestBean baseRequest) {
		this.baseRequest = baseRequest;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
