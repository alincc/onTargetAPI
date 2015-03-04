package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;

import org.hibernate.validator.constraints.NotEmpty;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.request.bean.RegistrationApprovalRequest;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;

/**
 * Created by Owner on 10/26/14.
 */
public interface Authentication {

	public UserResponse signIn(@Valid SignInRequest signInRequest);

	public OnTargetResponse registrationRequest(
			@Valid UserRegistrationRequest request);

	public OnTargetResponse logout(
			@NotEmpty @QueryParam("username") String username);

	public UserRegistationApprovalResponse getPendingUserRegistrationRequests();

	public OnTargetResponse approvePendingRegistrationRequest(
			@Valid RegistrationApprovalRequest request);

}