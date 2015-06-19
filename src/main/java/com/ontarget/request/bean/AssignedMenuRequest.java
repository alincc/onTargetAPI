package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "profileMenuId", "active" })
public class AssignedMenuRequest {
	@NotNull
	@JsonProperty("profileMenuId")
	private Integer profileMenuId;
	@NotEmpty
	@JsonProperty("active")
	private String active;

	@JsonProperty("profileMenuId")
	public Integer getProfileMenuId() {
		return profileMenuId;
	}

	@JsonProperty("profileMenuId")
	public void setProfileMenuId(Integer profileMenuId) {
		this.profileMenuId = profileMenuId;
	}

	@JsonProperty("active")
	public String getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(String active) {
		this.active = active;
	}

}
