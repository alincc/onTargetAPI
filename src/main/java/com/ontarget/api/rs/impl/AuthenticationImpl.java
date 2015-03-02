package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.Authentication;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.dto.UserResponse;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.util.Security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Owner on 10/26/14.
 */
@Component
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationImpl implements Authentication {

	private Logger logger = Logger.getLogger(AuthenticationImpl.class);

	@Autowired
	private AuthenticationService authenticationService;

	@POST
	@Path("/signin")
	public UserResponse signIn(SignInRequest signInRequest) {
		logger.info("Sign in request: " + signInRequest);
		UserResponse response = new UserResponse();
		try {
			response = authenticationService.signIn(signInRequest);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Authentication error", e);
			response.setReturnMessage("Authentication Error");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/registrationRequest")
	public OnTargetResponse registrationRequest(UserRegistrationRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			// generate token id
			final String tokenId = Security
					.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
			request.setTokenId(tokenId);
			if (authenticationService.registrationRequest(request)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage(OnTargetConstant.SUCCESSFULLY_REGISTERED);
			}
		} catch (Exception e) {
			logger.error("Error while saving registration request.", e);
			response.setReturnMessage(OnTargetConstant.REGISTRATION_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@Path("/getPendingUserRegistrationRequests")
	@POST
	public UserRegistationApprovalResponse getPendingUserRegistrationRequests() {
		UserRegistationApprovalResponse response = new UserRegistationApprovalResponse();
		try {
			response = authenticationService
					.getUserRegistrationPendingRequests();
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage(OnTargetConstant.PENDING_REQUEST_RECEIVED);
		} catch (Exception e) {
			logger.error("Error while saving registration request.", e);
			response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/approvePendingRequest")
	public OnTargetResponse approvePendingRegistrationRequest(
			UserRegistrationRequest requests) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (authenticationService
					.approvePendingRegistrationRequest(requests)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_SUCCESS);
			}
		} catch (Exception e) {
			logger.error("Error while saving registration request.", e);
			response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/logout")
	public OnTargetResponse logout(UserDTO user) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (authenticationService.logout(user.getUsername())) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage(OnTargetConstant.LOGOUT_SUCCESSFULL);
				response.setAuthenticated(false);
			}
		} catch (Exception e) {
			logger.error("Error while logging out." + e);
			response.setReturnMessage(OnTargetConstant.ERROR_LOGGEDOUT);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setAuthenticated(false);
		}

		return response;
	}
}
