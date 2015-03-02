package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "firstName", "lastName", "email", "phoneNumber", "msg" })
public class UserInvitationRequest {
	@NotEmpty
	@Size(min = 5, max = 40, message = "Your first name should be between 5 - 40 characters.")
	@JsonProperty("firstName")
	private String firstName;
	@NotEmpty
	@Size(min = 5, max = 40, message = "Your last name should be between 5 - 40 characters.")
	@JsonProperty("lastName")
	private String lastName;
	@NotEmpty
	@Email(message = "must be valid email santosh")
	@JsonProperty("email")
	private String email;
	@NotEmpty
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@NotEmpty
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