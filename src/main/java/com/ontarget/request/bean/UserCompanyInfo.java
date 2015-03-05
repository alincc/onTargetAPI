package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ontarget.bean.UserAddressInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "companyName", "companyTypeId", "address", "website" })
public class UserCompanyInfo {
	@NotEmpty
	@JsonProperty("companyName")
	private String companyName;
	@NotNull
	@JsonProperty("companyTypeId")
	private Integer companyTypeId;
	@NotNull
	@Valid
	@JsonProperty("address")
	private UserAddressInfo address;
	@JsonProperty("website")
	private String website;

	/**
	 * 
	 * @return The companyName
	 */
	@JsonProperty("companyName")
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 
	 * @param companyName
	 *            The companyName
	 */
	@JsonProperty("companyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 
	 * @return The companyTypeId
	 */
	@JsonProperty("companyTypeId")
	public Integer getCompanyTypeId() {
		return companyTypeId;
	}

	/**
	 * 
	 * @param companyTypeId
	 *            The companyTypeId
	 */
	@JsonProperty("companyTypeId")
	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	/**
	 * 
	 * @return The address
	 */
	@JsonProperty("address")
	public UserAddressInfo getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 *            The address
	 */
	@JsonProperty("address")
	public void setAddress(UserAddressInfo address) {
		this.address = address;
	}

	/**
	 * 
	 * @return The website
	 */
	@JsonProperty("website")
	public String getWebsite() {
		return website;
	}

	/**
	 * 
	 * @param website
	 *            The website
	 */
	@JsonProperty("website")
	public void setWebsite(String website) {
		this.website = website;
	}

}
