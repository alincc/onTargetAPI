package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "projectFileTagId" })
public class GetProjectFileTagCommentRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("projectFileTagId")
	private Long projectFileTagId;
}
