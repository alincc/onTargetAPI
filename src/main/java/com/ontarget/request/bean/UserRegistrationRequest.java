package com.ontarget.request.bean;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "username", "password", "email", "discipline",
		"registrationToken" })
public class UserRegistrationRequest {

	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("email")
	private String email;
	@JsonProperty("discipline")
	private Integer discipline;
	@JsonProperty("registrationToken")
	private String registrationToken;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The username
	 */
	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 *            The username
	 */
	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return The password
	 */
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 *            The password
	 */
	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
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
	 * @return The discipline
	 */
	@JsonProperty("discipline")
	public Integer getDiscipline() {
		return discipline;
	}

	/**
	 * 
	 * @param discipline
	 *            The discipline
	 */
	@JsonProperty("discipline")
	public void setDiscipline(Integer discipline) {
		this.discipline = discipline;
	}

	/**
	 * 
	 * @return The registrationToken
	 */
	@JsonProperty("registrationToken")
	public String getRegistrationToken() {
		return registrationToken;
	}

	/**
	 * 
	 * @param registrationToken
	 *            The registrationToken
	 */
	@JsonProperty("registrationToken")
	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
