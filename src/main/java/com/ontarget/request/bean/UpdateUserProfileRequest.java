package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "contact", "user" })
public class UpdateUserProfileRequest {
	@NotNull
	@Valid
	@JsonProperty("contact")
	private UserContactInfo contact;
	@NotNull
	@Valid
	@JsonProperty("user")
	private UserInfo user;

	@JsonProperty("contact")
	public UserContactInfo getContact() {
		return contact;
	}

	@JsonProperty("contact")
	public void setContact(UserContactInfo contact) {
		this.contact = contact;
	}

	@JsonProperty("user")
	public UserInfo getUser() {
		return user;
	}

	@JsonProperty("user")
	public void setUser(UserInfo user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UpdateUserProfileRequest{" + "contact=" + contact + ", user="
				+ user + '}';
	}

}
