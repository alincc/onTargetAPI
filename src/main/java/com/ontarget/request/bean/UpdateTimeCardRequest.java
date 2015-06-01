package com.ontarget.request.bean;

import java.util.Date;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "id", "projectTaskId", "fieldWorkerId", "timeIn", "timeOut" })
public class UpdateTimeCardRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("id")
	private Integer id;
	@NotNull
	@JsonProperty("projectTaskId")
	private Integer projectTaskId;
	@NotNull
	@JsonProperty("fieldWorkerId")
	private Integer fieldWorkerId;
	@NotNull
	@JsonProperty("timeIn")
	private Date timeIn;
	@NotNull
	@JsonProperty("timeOut")
	private Date timeOut;

	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public Integer getFieldWorkerId() {
		return fieldWorkerId;
	}

	public void setFieldWorkerId(Integer fieldWorkerId) {
		this.fieldWorkerId = fieldWorkerId;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

}
