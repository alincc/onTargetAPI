package com.ontarget.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "profileId" })
public class ProfileInfoRequest {
	@NotNull
	@JsonProperty("profileId")
	private Integer profileId;

	@JsonProperty("profileId")
	public Integer getProfileId() {
		return profileId;
	}

	@JsonProperty("profileId")
	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

}
