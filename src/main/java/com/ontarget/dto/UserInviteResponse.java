package com.ontarget.dto;

import com.ontarget.bean.UserRegistration;

/**
 * Created by sumit on 12/1/14.
 */
public class UserInviteResponse extends OnTargetResponse  {
    private UserRegistration userRegistration;

    public UserRegistration getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(UserRegistration userRegistration) {
        this.userRegistration = userRegistration;
    }
}
