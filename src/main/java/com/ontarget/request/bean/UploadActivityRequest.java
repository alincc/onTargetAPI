package com.ontarget.request.bean;

import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectId", "filename", "activityTaskRecords" })
public class UploadActivityRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("projectId")
	private Integer projectId;
	@NotEmpty
	@JsonProperty("filename")
	private String filename;
	@Valid
	@NotNull
	@Size(min = 1)
	@JsonProperty("activityTaskRecords")
	private List<ActivityTaskRecord> activityTaskRecords;

	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<ActivityTaskRecord> getActivityTaskRecords() {
		return activityTaskRecords;
	}

	public void setActivityTaskRecords(List<ActivityTaskRecord> activityTaskRecords) {
		this.activityTaskRecords = activityTaskRecords;
	}

}
