package com.ontarget.request.bean;

import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "profileId", "name", "description", "userId", "active", "assignedPermissionList" })
public class EditPermissionProfileRequest {
	@NotNull
	@JsonProperty("profileId")
	private Integer profileId;
	@NotEmpty
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@NotEmpty
	@JsonProperty("active")
	private String active;
	@NotNull
	@JsonProperty("userId")
	private Integer userId;
	@Valid
	@JsonProperty("assignedPermissionList")
	private List<Integer> assignedPermissionList;

	@JsonProperty("profileId")
	public Integer getProfileId() {
		return profileId;
	}

	@JsonProperty("profileId")
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("active")
	public String getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(String active) {
		this.active = active;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty("assignedPermissionList")
	public List<Integer> getAssignedPermissionList() {
		return assignedPermissionList;
	}

	@JsonProperty("assignedPermissionList")
	public void setAssignedPermissionList(List<Integer> assignedPermissionList) {
		this.assignedPermissionList = assignedPermissionList;
	}

}
