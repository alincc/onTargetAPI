package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id" })
public class ApplicationMenuId {
	@JsonProperty("applicationMenuId")
	private Integer applicationMenuId;

	@JsonProperty("applicationMenuId")
	public Integer getApplicationMenuId() {
		return applicationMenuId;
	}

	@JsonProperty("applicationMenuId")
	public void setApplicationMenuId(Integer applicationMenuId) {
		this.applicationMenuId = applicationMenuId;
	}

}
