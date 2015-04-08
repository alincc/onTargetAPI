package com.ontarget.dto;

import javax.annotation.Generated;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Owner on 12/26/14.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "emailAddress", "newPassword", "forgotPasswordToken" })
public class ForgotPasswordRequest {

	@JsonProperty("emailAddress")
	private String emailAddress;
	@JsonProperty("newPassword")
	private String newPassword;
	@JsonProperty("forgotPasswordToken")
	private String forgotPasswordToken;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getForgotPasswordToken() {
		return forgotPasswordToken;
	}

	public void setForgotPasswordToken(String forgotPasswordToken) {
		this.forgotPasswordToken = forgotPasswordToken;
	}

	public ForgotPasswordRequest() {
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
