package com.ontarget.dto;

import javax.ws.rs.QueryParam;

/**
 * Created by sumit on 12/25/14.
 */
public class ChangeUserPasswordRequest{
    private long userId;
    private String newPassword;
    private String currentPassword;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }
}
