package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "userId", "firstName", "lastName", "email", "areaCode", "phoneNumber" })
public class UserProfileInfo {
	@NotNull
	@JsonProperty("userId")
	private Integer userId;
	@NotEmpty
	@JsonProperty("firstName")
	private String firstName;
	@NotEmpty
	@JsonProperty("lastName")
	private String lastName;
	@NotEmpty
	@JsonProperty("email")
	private String email;
	@NotNull
	@JsonProperty("areaCode")
	private Integer areaCode;
	@NotEmpty
	@JsonProperty("phoneNumber")
	private String phoneNumber;

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("userId")
	public Integer getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("areaCode")
	public Integer getAreaCode() {
		return areaCode;
	}

	@JsonProperty("areaCode")
	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}