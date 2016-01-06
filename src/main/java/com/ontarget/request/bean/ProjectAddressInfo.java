package com.ontarget.request.bean;

import javax.annotation.Generated;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "address1", "address2", "city", "state", "country", "zip" })
public class ProjectAddressInfo {

	@NotEmpty
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@NotEmpty
	@JsonProperty("city")
	private String city;
	@NotEmpty
	@JsonProperty("state")
	private String state;
	@NotEmpty
	@JsonProperty("country")
	private String country;
	@NotEmpty
	@JsonProperty("zip")
	private String zip;
	@JsonProperty("addressId")
	private Integer addressId;



}
