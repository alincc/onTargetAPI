package com.ontarget.bean;

import javax.annotation.Generated;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "address1", "address2", "city", "state", "zip", "country", "addressType" })
public class UserAddressInfo {
	@NotEmpty
	@JsonProperty("address1")
	private String address1;
	@NotEmpty
	@JsonProperty("address2")
	private String address2;
	@NotEmpty
	@JsonProperty("city")
	private String city;
	@NotEmpty
	@JsonProperty("state")
	private String state;
	@NotEmpty
	@JsonProperty("zip")
	private String zip;
	@NotEmpty
	@JsonProperty("country")
	private String country;
	@JsonProperty("addressType")
	private String addressType;

	/**
	 * 
	 * @return The address1
	 */
	@JsonProperty("address1")
	public String getAddress1() {
		return address1;
	}

	/**
	 * 
	 * @param address1
	 *            The address1
	 */
	@JsonProperty("address1")
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * 
	 * @return The address2
	 */
	@JsonProperty("address2")
	public String getAddress2() {
		return address2;
	}

	/**
	 * 
	 * @param address2
	 *            The address2
	 */
	@JsonProperty("address2")
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * 
	 * @return The city
	 */
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 *            The city
	 */
	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The state
	 */
	@JsonProperty("state")
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 *            The state
	 */
	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return The zip
	 */
	@JsonProperty("zip")
	public String getZip() {
		return zip;
	}

	/**
	 * 
	 * @param zip
	 *            The zip
	 */
	@JsonProperty("zip")
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * 
	 * @return The country
	 */
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return The addressType
	 */
	@JsonProperty("addressType")
	public String getAddressType() {
		return addressType;
	}

	/**
	 * 
	 * @param addressType
	 *            The addressType
	 */
	@JsonProperty("addressType")
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

}