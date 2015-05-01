package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "username", "email", "discipline", "registrationToken" })
public class UserRegistrationInfo {
	@NotEmpty
	@Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "{username.validator.msg}")
	@JsonProperty("username")
	private String username;
	@NotEmpty
	@JsonProperty("email")
	private String email;
	@NotNull
	@JsonProperty("discipline")
	private Integer discipline;
	@NotEmpty
	@JsonProperty("registrationToken")
	private String registrationToken;
	@JsonIgnore
	private String password;

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("discipline")
	public Integer getDiscipline() {
		return discipline;
	}

	@JsonProperty("discipline")
	public void setDiscipline(Integer discipline) {
		this.discipline = discipline;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("registrationToken")
	public String getRegistrationToken() {
		return registrationToken;
	}

	@JsonProperty("registrationToken")
	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

}
