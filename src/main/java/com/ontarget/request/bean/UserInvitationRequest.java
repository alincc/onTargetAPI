package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "firstName", "lastName", "email", "phoneNumber", "msg", "companyName", "companyAddress1",
		"companyAddress2", "companyCity", "companyState", "companyZip", "companyCountry" })
public class UserInvitationRequest {
	@NotEmpty
	@JsonProperty("firstName")
	private String firstName;
	@NotEmpty
	@JsonProperty("lastName")
	private String lastName;
	@NotEmpty
	@Email(message = "must be valid email")
	@JsonProperty("email")
	private String email;
	@NotEmpty
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@NotEmpty
	@JsonProperty("msg")
	private String msg;
	@NotEmpty
	@JsonProperty("companyName")
	private String companyName;
	@NotEmpty
	@JsonProperty("companyAddress1")
	private String companyAddress1;
	@JsonProperty("companyAddress2")
	private String companyAddress2;
	@NotEmpty
	@JsonProperty("companyCity")
	private String companyCity;
	@NotEmpty
	@JsonProperty("companyState")
	private String companyState;
	@NotEmpty
	@JsonProperty("companyZip")
	private String companyZip;
	@NotEmpty
	@JsonProperty("companyCountry")
	private String companyCountry;
	@NotNull
	@JsonProperty("companyId")
	private int companyId;
	@JsonProperty("companyTypeId")
	private Integer companyTypeId;

	@JsonProperty("companyId")
	public int getCompanyId() {
		return companyId;
	}

	@JsonProperty("companyId")
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

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

	@JsonProperty("companyName")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("companyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@JsonProperty("companyAddress1")
	public String getCompanyAddress1() {
		return companyAddress1;
	}

	@JsonProperty("companyAddress1")
	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	@JsonProperty("companyAddress2")
	public String getCompanyAddress2() {
		return companyAddress2;
	}

	@JsonProperty("companyAddress2")
	public void setCompanyAddress2(String companyAddress2) {
		this.companyAddress2 = companyAddress2;
	}

	@JsonProperty("companyCity")
	public String getCompanyCity() {
		return companyCity;
	}

	@JsonProperty("companyCity")
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	@JsonProperty("companyState")
	public String getCompanyState() {
		return companyState;
	}

	@JsonProperty("companyState")
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	@JsonProperty("companyZip")
	public String getCompanyZip() {
		return companyZip;
	}

	@JsonProperty("companyZip")
	public void setCompanyZip(String companyZip) {
		this.companyZip = companyZip;
	}

	@JsonProperty("companyCountry")
	public String getCompanyCountry() {
		return companyCountry;
	}

	@JsonProperty("companyCountry")
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	@JsonProperty("companyTypeId")
	public Integer getCompanyTypeId() {
		return companyTypeId;
	}

	@JsonProperty("companyTypeId")
	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

}