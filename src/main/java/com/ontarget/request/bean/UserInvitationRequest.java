package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "firstName", "lastName", "email", "phoneNumber", "msg", "companyName", "companyAddress1", "companyAddress2",
		"companyCity", "companyState", "companyZip", "companyCountry", "companyLogoPath" })
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

	@JsonProperty("msg")
	private String msg;
	@NotEmpty
	@JsonProperty("companyName")
	private String companyName;

	@JsonProperty("companyAddress1")
	private String companyAddress1;
	@JsonProperty("companyAddress2")
	private String companyAddress2;

	@JsonProperty("companyCity")
	private String companyCity;

	@JsonProperty("companyState")
	private String companyState;

	@JsonProperty("companyZip")
	private String companyZip;

	@JsonProperty("companyCountry")
	private String companyCountry;

	@JsonProperty("companyId")
	private int companyId;
	@JsonProperty("companyTypeId")
	private Integer companyTypeId;
	@JsonProperty("companyLogoPath")
	private String companyLogoPath;

}