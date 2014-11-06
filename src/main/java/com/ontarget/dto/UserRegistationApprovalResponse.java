package com.ontarget.dto;

import java.util.List;

/**
 * Created by Owner on 11/3/14.
 */
public class UserRegistationApprovalResponse extends OnTargetResponse{

    private List<UserRegistrationRequest> userRegistrationRequestList;

    public List<UserRegistrationRequest> getUserRegistrationRequestList() {
        return userRegistrationRequestList;
    }

    public void setUserRegistrationRequestList(List<UserRegistrationRequest> userRegistrationRequestList) {
        this.userRegistrationRequestList = userRegistrationRequestList;
    }
}
