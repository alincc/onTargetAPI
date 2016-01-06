package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "project", "userId","accountStatus"})
public class ProjectRequest {
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

}