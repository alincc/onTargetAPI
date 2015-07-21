package com.ontarget.dto;

import java.io.Serializable;

public class ForgotPasswordRequestResponse extends OnTargetResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String emailAddress;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
