package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ontarget.request.bean.UserProfileInfo;

/**
 * Created by Owner on 11/4/14.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "profile" })
public class UpdateUserProfileRequest {
	@NotNull
	@Valid
	@JsonProperty("profile")
	private UserProfileInfo userProfileInfo;

	public UpdateUserProfileRequest() {
	}

	public UserProfileInfo getUserProfileInfo() {
		return userProfileInfo;
	}

	public void setUserProfileInfo(UserProfileInfo userProfileInfo) {
		this.userProfileInfo = userProfileInfo;
	}

}
