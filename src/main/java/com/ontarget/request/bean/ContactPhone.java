package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "areaCode", "phoneNumber" })
public class ContactPhone {
	@NotNull
	@JsonProperty("areaCode")
	private Integer areaCode;
	@NotEmpty
	@JsonProperty("phoneNumber")
	private String phoneNumber;

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