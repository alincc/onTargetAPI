package com.ontarget.dto;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ontarget.request.bean.ContactPhone;
import com.ontarget.request.bean.UserCompanyInfo;
import com.ontarget.request.bean.UserContactInfo;
import com.ontarget.request.bean.UserInfo;

/**
 * Created by Owner on 11/4/14.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "contact", "company", "user" })
public class UserProfileRequest {
	@NotNull
	@Valid
	@JsonProperty("contact")
	private UserContactInfo contact;
	@NotNull
	@Valid
	@JsonProperty("contactPhone")
	private ContactPhone contactPhone;
	@NotNull
	@Valid
	@JsonProperty("company")
	private UserCompanyInfo company;
	@NotNull
	@Valid
	@JsonProperty("user")
	private UserInfo user;

	public UserProfileRequest() {
	}

	@JsonProperty("contact")
	public UserContactInfo getContact() {
		return contact;
	}

	@JsonProperty("contact")
	public void setContact(UserContactInfo contact) {
		this.contact = contact;
	}

	@JsonProperty("contactPhone")
	public ContactPhone getContactPhone() {
		return contactPhone;
	}

	@JsonProperty("contactPhone")
	public void setContactPhone(ContactPhone contactPhone) {
		this.contactPhone = contactPhone;
	}

	@JsonProperty("company")
	public UserCompanyInfo getCompany() {
		return company;
	}

	@JsonProperty("company")
	public void setCompany(UserCompanyInfo company) {
		this.company = company;
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
		return "UserProfileRequest{" + "contact=" + contact + ", company=" + company + ", user=" + user + '}';
	}
}
