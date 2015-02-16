package com.ontarget.entity.pojo;

import java.io.Serializable;

public class RegistrationRequestResponseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7546742704996581332L;
	private String registrationToken;
	private int projectId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String msg;
	private String status;
	private int id;
	private long tsCreate;

	public String getRegistrationToken() {
		return registrationToken;
	}

	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getTsCreate() {
		return tsCreate;
	}

	public void setTsCreate(long tsCreate) {
		this.tsCreate = tsCreate;
	}

}
