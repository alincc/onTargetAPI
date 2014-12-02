package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by sumit on 12/1/14.
 */
public class UserRegistration implements Serializable {

    private String registrationToken;
    private long projectId=Long.MIN_VALUE;
    private String firstName;
    private String email;
    private String lastName;
    private String status;
    private long tsCreate=Long.MIN_VALUE;

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
}
