package com.ontarget.request.bean;

import java.util.Date;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectTaskId", "name", "timeIn", "timeOut" })
public class AddTimeCardRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("projectTaskId")
	private Integer projectTaskId;
	@NotEmpty
	@JsonProperty("name")
	private String name;
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

	public Integer getProjectTaskId() {
		return projectTaskId;
	}

	public void setProjectTaskId(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
