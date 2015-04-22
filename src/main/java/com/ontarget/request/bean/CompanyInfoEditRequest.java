package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "company" })
public class CompanyInfoEditRequest {
	@NotNull
	@Valid
	@JsonProperty("company")
	private CompanyEditInfo company;

	@JsonProperty("company")
	public CompanyEditInfo getCompany() {
		return company;
	}

	@JsonProperty("company")
	public void setCompany(CompanyEditInfo company) {
		this.company = company;
	}

}
