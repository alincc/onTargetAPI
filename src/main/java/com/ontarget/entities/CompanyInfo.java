package com.ontarget.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "company_info")
public class CompanyInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "company_id", nullable = false)
	private Integer companyId;
	@Column(name = "company_name", length = 45)
	private String companyName;
	@Column(name = "address1", length = 45)
	private String address1;
	@Column(name = "address2", length = 45)
	private String address2;
	@Column(name = "city", length = 45)
	private String city;
	@Column(name = "state", length = 45)
	private String state;
	@Column(name = "zipcode", length = 45)
	private String zipcode;
	@Column(name = "country", length = 45)
	private String country;
	@Column(name = "status", length = 45)
	private String status;
	@Column(name = "website", length = 30)
	private String website;
	@OneToMany(mappedBy = "companyInfo", fetch = FetchType.LAZY)
	private List<Contact> contactList;
	@JoinColumn(name = "company_type_id", referencedColumnName = "company_type_id", nullable = false)
	@ManyToOne(optional = false)
	private CompanyType companyType;
	@OneToMany(mappedBy = "companyInfo", fetch = FetchType.LAZY)
	private List<Project> projectList;

	public CompanyInfo() {
	}

	public CompanyInfo(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (companyId != null ? companyId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CompanyInfo)) {
			return false;
		}
		CompanyInfo other = (CompanyInfo) object;
		if ((this.companyId == null && other.companyId != null)
				|| (this.companyId != null && !this.companyId
						.equals(other.companyId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.CompanyInfo[companyId=" + companyId + "]";
	}

}
