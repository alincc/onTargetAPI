package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "firstName", "lastName", "email", "phoneNumber", "msg" })
public class UserInvitationRequestBean {
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@JsonProperty("msg")
	private String msg;

	/**
	 *
	 * @return The firstName
	 */
	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * @param firstName
	 *            The firstName
	 */
	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 *
	 * @return The lastName
	 */
	@JsonProperty("lastName")
	public String getLastName() {
		return lastName;
	}

	/**
	 *
	 * @param lastName
	 *            The lastName
	 */
	@JsonProperty("lastName")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 *
	 * @return The email
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	/**
	 *
	 * @param email
	 *            The email
	 */
	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 *
	 * @return The phoneNumber
	 */
	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 *
	 * @param phoneNumber
	 *            The phoneNumber
	 */
	@JsonProperty("phoneNumber")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 *
	 * @return The msg
	 */
	@JsonProperty("msg")
	public String getMsg() {
		return msg;
	}

	/**
	 *
	 * @param msg
	 *            The msg
	 */
	@JsonProperty("msg")
	public void setMsg(String msg) {
		this.msg = msg;
	}
}