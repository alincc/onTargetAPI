package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "loggedInUserId", "loggedInUserProjectId" })
public class BaseRequest {
	@NotNull
	@JsonProperty("loggedInUserId")
	private Integer loggedInUserId;
	@NotNull
	@JsonProperty("loggedInUserProjectId")
	private Integer loggedInUserProjectId;


}
