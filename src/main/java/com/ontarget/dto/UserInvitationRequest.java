package com.ontarget.dto;

import javax.ws.rs.QueryParam;

/**
 * Created by sumit on 12/25/14.
 */
public class UserInvitationRequest{
    private long projectId;
    private String firstName;
    private String lastName;
    private String email;

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
}
