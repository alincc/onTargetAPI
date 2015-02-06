package com.ontarget.bean;

import java.io.Serializable;

import com.ontarget.dto.BaseRequest;

/**
 * Created by Owner on 11/4/14.
 */
public class Contact extends BaseRequest implements Serializable {

	private int contactId;
	private String firstName;
	private String lastName;
	private String title;
	private Company company;
	private User user;
	private String userImagePath;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contact() {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Contact{" + "firstName='" + firstName + '\'' + ", lastName='"
				+ lastName + '\'' + ", title='" + title + '\'' + ", company="
				+ company + ", user=" + user + '}';
	}

	public String getUserImagePath() {
		return userImagePath;
	}

	public void setUserImagePath(String userImagePath) {
		this.userImagePath = userImagePath;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
}
