package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "username", "email", "discipline", "registrationToken", "firstName", "lastName", "title", "password" })
public class UserSignupRequest {
	@NotEmpty
	@Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "{username.validator.msg}")
	@JsonProperty("username")
	private String username;
	@NotEmpty
	@JsonProperty("email")
	private String email;
	@NotEmpty
	@JsonProperty("firstName")
	private String firstName;
	@NotEmpty
	@JsonProperty("lastName")
	private String lastName;
	@NotEmpty
	@JsonProperty("title")
	private String title;
	@JsonProperty("userImagePath")
	private String userImagePath;
	@NotNull
	@JsonProperty("discipline")
	private Integer discipline;
	@NotEmpty
	@JsonProperty("registrationToken")
	private String registrationToken;
	@NotEmpty
	@JsonProperty("password")
	private String password;
	@NotNull
	@JsonProperty("areaCode")
	private Integer areaCode;
	@NotEmpty
	@JsonProperty("phoneNumber")
	private String phoneNumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserImagePath() {
		return userImagePath;
	}

	public void setUserImagePath(String userImagePath) {
		this.userImagePath = userImagePath;
	}

	public Integer getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Integer discipline) {
		this.discipline = discipline;
	}

	public String getRegistrationToken() {
		return registrationToken;
	}

	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
