package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.UserInvitation;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.UserInvitationService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInvitationApprovalResponse;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;
import com.ontarget.request.bean.UserInvitationRequest;
import com.ontarget.util.ConvertPOJOUtils;
import com.ontarget.util.Security;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Component
@Path("/onTargetInvitation")
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
	@Path("/inviteToNewAccount")
	public OnTargetResponse inviteUserIntoNewAccount(UserInvitationRequest request) {

		OnTargetResponse response = new OnTargetResponse();
		try {
			RegistrationRequestResponseDTO registrationRequest = userInvitationService.getRegistrationRequest(request.getEmail());

			if (registrationRequest != null) {

				if (System.currentTimeMillis() - registrationRequest.getTsCreate() <= OnTargetConstant.TOKEN_MAX_LIFE) {
					response.setReturnVal(OnTargetConstant.ERROR);
					response.setReturnMessage("You are already invited");
					return response;
				}
			}

			final String tokenId = Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);

			UserInvitationRequestDTO userInvitationRequestDTO = ConvertPOJOUtils.convertToUserInvitationDTO(request, tokenId);

			if (userInvitationService.registrationRequest(userInvitationRequestDTO)) {

				// send thankyou email to user

				// send approval email to Admin
				emailService.sendUserRequestEmailToAdmin();

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
	@Path("/pendingRegistrationRequest")
	@POST
	public UserInvitationApprovalResponse getPendingRequestList() {
		UserInvitationApprovalResponse response = new UserInvitationApprovalResponse();
		try {
			response = userInvitationService.retrievePendingRegRequestList();

			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage(OnTargetConstant.PENDING_REQUEST_RECEIVED);
		} catch (Exception e) {
			logger.error("Error while retrieving pending registration request.", e);
			response.setReturnMessage(OnTargetConstant.RETRIEVE_PENDING_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/approvalRequest")
	public OnTargetResponse approveRequest(@QueryParam("id") int id) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean success = userInvitationService.approvePendingRequest(id);
			if (success) {

                //prepare to send email.
                Map<String, Object> emailAttributes = new HashMap<>();
                emailAttributes.put("registrationRequestId",id);
				emailService.sendEmail(emailAttributes);

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
	@POST
	@Path("/rejectRequest")
	public OnTargetResponse rejectNewAccountRequest(@QueryParam("id") int id) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean success = userInvitationService.rejectPendingRequest(id);
			if (success) {
				emailService.sendInvitationEmailForRegistration(id);
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage(OnTargetConstant.REGISTRATION_REJECT_REQUEST_SUCCESS);
				logger.info("Rejected successfully for id:: " + id);
			} else {
				logger.error("Reject request failed.");
				response.setReturnMessage(OnTargetConstant.REGISTRATION_REJECT_REQUEST_FAILED);
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			logger.error("Error while rejecting request.", e);
			response.setReturnMessage(OnTargetConstant.REGISTRATION_REJECT_REQUEST_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@GET
	@Path("/validateLink")
	public OnTargetResponse verifyToken(@QueryParam("q") String token) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			RegistrationRequestResponseDTO userRegistration = null;
			try {
				userRegistration = userInvitationService.getRequestByToken(token);
			} catch (Exception e) {
				logger.error("Error while obtaining request with provided token", e);
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
			if (status != null && (status.equals(OnTargetConstant.REGISTRATION_REQUEST_NEW))) {
				if (System.currentTimeMillis() - userRegistration.getTsCreate() > OnTargetConstant.TOKEN_MAX_LIFE) {
					response.setReturnVal(OnTargetConstant.ERROR);
					response.setReturnMessage("expired link. Please try with new link");
					return response;
				} else {
					response.setReturnVal(OnTargetConstant.SUCCESS);
					response.setReturnMessage(OnTargetConstant.TOKEN_VERIFIED);
					return response;
				}
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Your invitation request is not approved.");
			}

		} catch (Exception e) {
			logger.error("Provided token does not match with db.", e);
			response.setReturnMessage(OnTargetConstant.TOKEN_VERIFICATION_FAILED);
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}
}