package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistrationRequest;

import java.util.List;

/**
 * Created by Owner on 10/26/14.
 */
public interface Authentication {

    public UserResponse signIn(User user);

    public UserResponse register(User user);

    public OnTargetResponse registrationRequest(UserRegistrationRequest request);

    public OnTargetResponse logout(User user);

    public UserRegistationApprovalResponse getPendingUserRegistrationRequests();

    public OnTargetResponse approvePendingRegistrationRequest(UserRegistrationRequest requests);

}