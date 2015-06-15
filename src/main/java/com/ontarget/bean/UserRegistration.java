package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by sumit on 12/1/14.
 */
public class UserRegistration implements Serializable {

	private String registrationToken;
	private long projectId = Long.MIN_VALUE;
	private String firstName;
	private String email;
	private String lastName;
	private String status;
	private String discipline;
	private long tsCreate = Long.MIN_VALUE;

	private String password;
	private int userId;
	private String companyName;
	private String companyAddress1;
	private String companyAddress2;
	private String companyCity;
	private String companyState;
	private String companyZip;
	private String companyCountry;
	private int companyTypeId;
	private String companyWebsite;
	private int companyId;
	private Integer invitedProjectId;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getRegistrationToken() {
		return registrationToken;
	}

	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getTsCreate() {
		return tsCreate;
	}

	public void setTsCreate(long tsCreate) {
		this.tsCreate = tsCreate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public int getCompanyTypeId() {
		return companyTypeId;
	}

	public void setCompanyTypeId(int companyTypeId) {
		this.companyTypeId = companyTypeId;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public Integer getInvitedProjectId() {
		return invitedProjectId;
	}

	public void setInvitedProjectId(Integer invitedProjectId) {
		this.invitedProjectId = invitedProjectId;
	}

	@Override
	public String toString() {
		return "UserRegistration{" + "registrationToken='" + registrationToken + '\'' + ", projectId=" + projectId
				+ ",invitedProjectId=" + invitedProjectId + ", firstName='" + firstName + '\'' + ", email='" + email
				+ '\'' + ", lastName='" + lastName + '\'' + ", status='" + status + '\'' + ", tsCreate=" + tsCreate
				+ ", password='" + password + '\'' + ", userId=" + userId + '}';
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
}
