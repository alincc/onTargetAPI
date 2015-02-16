package com.ontarget.bean;

import java.io.Serializable;

import com.ontarget.dto.BaseRequest;

/**
 * Created by Owner on 11/4/14.
 */
public class Company extends BaseRequest implements Serializable {

	private int companyId;
	private String companyName;
	private int companyTypeId;
	private AddressDTO address;
	private String email;
	private String website;

	public Company() {
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(int companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "Company{" + "companyId=" + companyId + ", companyName='"
				+ companyName + '\'' + ", companyTypeId=" + companyTypeId
				+ ", address=" + address + ", email='" + email + '\''
				+ ", website='" + website + '\'' + '}';
	}
}
