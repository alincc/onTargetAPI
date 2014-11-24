package com.ontarget.api.service;

import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.dto.UserResponse;

import java.util.List;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationService {

    public UserResponse signIn(User user) throws Exception;

    public boolean registrationRequest(UserRegistrationRequest request) throws Exception;

    public boolean logout(String username) throws Exception;

    public UserRegistationApprovalResponse getUserRegistrationPendingRequests() throws Exception;

    public boolean approvePendingRegistrationRequest(List<UserRegistrationRequest> requests) throws Exception;
}
