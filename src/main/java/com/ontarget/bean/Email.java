package com.ontarget.bean;

import java.io.Serializable;

public class Email implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer emailId;
	private Contact contact;
	private String emailAddress;
	private String emailType;
	private String status;
	
	public Integer getEmailId() {
		return emailId;
	}
	
	public void setEmailId(Integer emailId) {
		this.emailId = emailId;
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailType() {
		return emailType;
	}
	
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
