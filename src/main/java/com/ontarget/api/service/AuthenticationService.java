package com.ontarget.api.service;

import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.request.bean.SignInRequestBean;

import java.util.List;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationService {

	public UserResponse signIn(SignInRequestBean signInRequest) throws Exception;

	public boolean registrationRequest(UserRegistrationRequest request)
			throws Exception;

	public boolean logout(String username) throws Exception;

	public UserRegistationApprovalResponse getUserRegistrationPendingRequests()
			throws Exception;

	public boolean approvePendingRegistrationRequest(
			UserRegistrationRequest requests) throws Exception;

	
}
