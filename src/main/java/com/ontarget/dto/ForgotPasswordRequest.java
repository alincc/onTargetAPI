package com.ontarget.dto;

/**
 * Created by Owner on 12/26/14.
 */
public class ForgotPasswordRequest {


    String emailAddress;

    public ForgotPasswordRequest() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
