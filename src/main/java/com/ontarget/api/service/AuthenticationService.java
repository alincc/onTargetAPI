package com.ontarget.api.service;

import com.ontarget.dto.UserLoginResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.request.bean.RegistrationApprovalRequest;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationService {

	public UserLoginResponse signIn(SignInRequest signInRequest) throws Exception;

	public boolean registrationRequest(UserRegistrationRequest request) throws Exception;

	public boolean logout(String username) throws Exception;

	public UserRegistationApprovalResponse getUserRegistrationPendingRequests() throws Exception;

	public boolean approvePendingRegistrationRequest(RegistrationApprovalRequest request) throws Exception;

}
