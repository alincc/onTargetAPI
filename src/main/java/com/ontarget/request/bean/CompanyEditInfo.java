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
@JsonPropertyOrder({ "companyId", "companyName", "companyTypeId", "address" })
public class CompanyEditInfo {
	@NotNull
	@JsonProperty("companyId")
	private Integer companyId;
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

	@JsonProperty("companyId")
	public Integer getCompanyId() {
		return companyId;
	}

	@JsonProperty("companyId")
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@JsonProperty("companyName")
	public String getCompanyName() {
		return companyName;
	}

	@JsonProperty("companyName")
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@JsonProperty("companyTypeId")
	public Integer getCompanyTypeId() {
		return companyTypeId;
	}

	@JsonProperty("companyTypeId")
	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	@JsonProperty("address")
	public UserAddressInfo getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(UserAddressInfo address) {
		this.address = address;
	}

}
