package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId", "name", "fileType",
		"createdBy", "modifiedBy" })
public class UploadDocumentRequestBean {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("projectId")
	private Integer projectId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("fileType")
	private String fileType;
	@JsonProperty("createdBy")
	private Integer createdBy;
	@JsonProperty("modifiedBy")
	private Integer modifiedBy;

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

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("fileType")
	public String getFileType() {
		return fileType;
	}

	@JsonProperty("fileType")
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@JsonProperty("createdBy")
	public Integer getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("createdBy")
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty("modifiedBy")
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	@JsonProperty("modifiedBy")
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
