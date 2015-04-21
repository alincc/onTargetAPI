package com.ontarget.dto;

public class UserData {
	private String firstName;
	private String lastName;

	public UserData(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("UserData[");
		sb.append("firstName : " + firstName);
		sb.append(",lastName: " + lastName);
		sb.append("]");
		return sb.toString();
	}

}
