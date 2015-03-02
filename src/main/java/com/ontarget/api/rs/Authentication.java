package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.bean.UserDTO;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.request.bean.SignInRequest;

import java.util.List;

/**
 * Created by Owner on 10/26/14.
 */
public interface Authentication {

	public UserResponse signIn(SignInRequest signInRequest);

	public OnTargetResponse registrationRequest(UserRegistrationRequest request);

	public OnTargetResponse logout(UserDTO user);

	public UserRegistationApprovalResponse getPendingUserRegistrationRequests();

	public OnTargetResponse approvePendingRegistrationRequest(
			UserRegistrationRequest requests);

}