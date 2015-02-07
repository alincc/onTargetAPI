package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.UserInvitation;
import com.ontarget.api.service.UserInvitationService;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.api.service.EmailService;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.dto.UserResponse;
import com.ontarget.util.Security;
import com.ontarget.util.WSResourceKeyConstant;

@Component
@Path(WSResourceKeyConstant.ONTARGET_INVITATION)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserInvitationImpl implements UserInvitation {

	private Logger logger = Logger.getLogger(AuthenticationImpl.class);

	@Autowired
	private UserInvitationService userInvitationService;
	@Autowired
	private EmailService emailService;

	@Override
	@POST
	@Path(WSResourceKeyConstant.INVITE_TO_NEW_ACCOUNT)
	public OnTargetResponse inviteUserIntoNewAccount(
			UserRegistrationRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			logger.info("This is first name " + request.getFirstName()
					+ " last name " + request.getLastName() + " email"
					+ request.getEmail() + ", phone no: "
					+ request.getPhoneNumber() + ", message: "
					+ request.getMsg());

			UserRegistrationRequest registrationRequest = userInvitationService.getRegistrationRequest(request.getEmail());

			logger.info("registration request:: " + registrationRequest);
			System.out.println("registration request:: " + registrationRequest);

			if (registrationRequest != null) {
				logger.info("id:: " + registrationRequest.getId());
				logger.info("is create:: " + registrationRequest.getTsCreate());

				System.out.println("id:: " + registrationRequest.getId());
				System.out.println("is create:: "
						+ registrationRequest.getTsCreate());
				if (System.currentTimeMillis()
						- registrationRequest.getTsCreate() <= OnTargetConstant.TOKEN_MAX_LIFE) {
					response.setReturnVal(OnTargetConstant.ERROR);
					response.setReturnMessage("You are already invited");
					return response;
				}
			}

			final String tokenId = Security
					.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
			logger.info("Token id:: " + tokenId);
			request.setTokenId(tokenId);
			if (userInvitationService.registrationRequest(request)) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage(OnTargetConstant.SUCCESSFULLY_REGISTERED);
			}
		} catch (Exception e) {
			System.out.println("Error:: " + e);
			logger.error("Error while saving registration request.", e);
			response.setReturnMessage(OnTargetConstant.REGISTRATION_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@Path(WSResourceKeyConstant.PENDING_REGISTRATION_REQUEST)
	@POST
	public UserRegistationApprovalResponse getPendingRequestList() {
		UserRegistationApprovalResponse response = new UserRegistationApprovalResponse();
		try {
			response = userInvitationService.retrievePendingRegRequestList();

			logger.info("Pending registration request list:: "
					+ response.getUserRegistrationRequestList());

			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage(OnTargetConstant.PENDING_REQUEST_RECEIVED);
		} catch (Exception e) {
			logger.error(
					"Error while retrieving pending registration request.", e);
			response.setReturnMessage(OnTargetConstant.RETRIEVE_PENDING_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path(WSResourceKeyConstant.REGISTRATION_APPROVAL_REQUEST)
	public OnTargetResponse approveRequest(@QueryParam("id") int id) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean success = userInvitationService.approvePendingRequest(id);
			logger.info("Approval request status:: " + success);
			if (success) {
				emailService.sendInvitationEmailForRegistration(id);
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_SUCCESS);
				logger.info("Approved successfully for id:: " + id);
			} else {
				logger.error("Approval request failed.");
				response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_FAILED);
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			logger.error("Error while saving registration request.", e);
			response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@GET
	@Path(WSResourceKeyConstant.VALIDATE_LINK_REQUEST)
	public OnTargetResponse verifyToken(@QueryParam("q") String token) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			UserRegistrationRequest userRegistration = null;
			try {
				userRegistration = userInvitationService
						.getRequestByToken(token);
			} catch (Exception e) {
				logger.error(
						"Error while obtaining request with provided token", e);
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("no user registration for the specified token exists");
				return response;
			}
			if (userRegistration == null) {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("no user registration for the specified token exists");
				return response;
			}

			String status = userRegistration.getStatus();
			logger.info("status:: " + status);
			// if (status != null
			// && (status
			// .equals(OnTargetConstant.REGISTRATION_REQUEST_NEW))) {
			if (System.currentTimeMillis() - userRegistration.getTsCreate() > OnTargetConstant.TOKEN_MAX_LIFE) {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("expired link. Please try with new link");
				return response;
			} else {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage(OnTargetConstant.TOKEN_VERIFIED);
				return response;
			}
			// } else {
			// response.setReturnVal(OnTargetConstant.ERROR);
			// response.setReturnMessage("Your invitation request is not approved.");
			// }
		} catch (Exception e) {
			logger.error("Provided token does not match with db.", e);
			response.setReturnMessage(OnTargetConstant.TOKEN_VERIFICATION_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}