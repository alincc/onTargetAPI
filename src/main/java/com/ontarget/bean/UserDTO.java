package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 10/26/14.
 */
public class UserDTO implements Serializable {

	private int userId;
	private String username;
	private String password;
	private String salt;
	private String designation;
	private String accountStatus;
	private String userStatus;
	private long discipline;
	private Contact contact;
	private int userTypeId;

	public UserDTO() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public long getDiscipline() {
		return discipline;
	}

	public void setDiscipline(long discipline) {
		this.discipline = discipline;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", username='" + username + '\''
				+ ", password='" + password + '\'' + ", designation='"
				+ designation + '\'' + '}';
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
