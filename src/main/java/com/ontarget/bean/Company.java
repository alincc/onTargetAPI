package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 11/4/14.
 */
public class Company implements Serializable {

	private Integer companyId;
	private String companyName;
	private Integer companyTypeId;
	private AddressDTO address;
	private String email;
	private String website;
	private String companyLogoPath;

	public Company() {
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
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

	public String getCompanyLogoPath() {
		return companyLogoPath;
	}

	public void setCompanyLogoPath(String companyLogoPath) {
		this.companyLogoPath = companyLogoPath;
	}

	@Override
	public String toString() {
		return "Company{" + "companyId=" + companyId + ", companyName='" + companyName + '\'' + ", companyTypeId=" + companyTypeId
				+ ", address=" + address + ", email='" + email + '\'' + ", website='" + website + '\'' + '}';
	}
}
