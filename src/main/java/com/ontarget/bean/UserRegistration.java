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
	private int status;
	private String discipline;
	private long tsCreate = Long.MIN_VALUE;

	private String password;
	private int userId;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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

	@Override
	public String toString() {
		return "UserRegistration{" + "registrationToken='" + registrationToken
				+ '\'' + ", projectId=" + projectId + ", firstName='"
				+ firstName + '\'' + ", email='" + email + '\''
				+ ", lastName='" + lastName + '\'' + ", status='" + status
				+ '\'' + ", tsCreate=" + tsCreate + ", password='" + password
				+ '\'' + ", userId=" + userId + '}';
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
}
