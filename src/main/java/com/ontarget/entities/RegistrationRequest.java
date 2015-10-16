package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "registration_request")
public class RegistrationRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Long id;
	@Basic(optional = false)
	@Column(name = "registration_token", nullable = false, length = 64)
	private String registrationToken;
	@Column(name = "project_id")
	private Integer projectId;
	@Column(name = "first_name", length = 100)
	private String firstName;
	@Column(name = "last_name", length = 100)
	private String lastName;
	@Column(name = "email", length = 45)
	private String email;
	@Column(name = "company_name", length = 45)
	private String companyName;
	@Column(name = "phone_number", length = 45)
	private String phoneNumber;
	@Column(name = "msg", columnDefinition = "TEXT")
	private String msg;
	@Column(name = "status", length = 25)
	private String status;
	@Basic(optional = false)
	@Column(name = "ts_create", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tsCreate;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "company_address1")
	private String companyAddress1;
	@Column(name = "company_address2")
	private String companyAddress2;
	@Column(name = "company_city")
	private String companyCity;
	@Column(name = "company_state")
	private String companyState;
	@Column(name = "company_zip")
	private String companyZip;
	@Column(name = "company_country")
	private String companyCountry;
	@Column(name = "company_id")
	private int companyId;
	@Column(name = "company_type_id")
	private Integer companyTypeId;

	public RegistrationRequest() {
	}

	public RegistrationRequest(Long id) {
		this.id = id;
	}

	public RegistrationRequest(Long id, String registrationToken, Date tsCreate) {
		this.id = id;
		this.registrationToken = registrationToken;
		this.tsCreate = tsCreate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistrationToken() {
		return registrationToken;
	}

	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTsCreate() {
		return tsCreate;
	}

	public void setTsCreate(Date tsCreate) {
		this.tsCreate = tsCreate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCompanyAddress1() {
		return companyAddress1;
	}

	public void setCompanyAddress1(String companyAddress1) {
		this.companyAddress1 = companyAddress1;
	}

	public String getCompanyAddress2() {
		return companyAddress2;
	}

	public void setCompanyAddress2(String companyAddress2) {
		this.companyAddress2 = companyAddress2;
	}

	public String getCompanyCity() {
		return companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyState() {
		return companyState;
	}

	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}

	public String getCompanyZip() {
		return companyZip;
	}

	public void setCompanyZip(String companyZip) {
		this.companyZip = companyZip;
	}

	public String getCompanyCountry() {
		return companyCountry;
	}

	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}

	public Integer getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(Integer companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof RegistrationRequest)) {
			return false;
		}
		RegistrationRequest other = (RegistrationRequest) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.RegistrationRequest[id=" + id + "]";
	}

	public int getcompanyId() {
		return companyId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
}
