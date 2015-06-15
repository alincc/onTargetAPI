package com.ontarget.api.rs.impl;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.ProjectService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.dto.UserInviteResponse;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserRegistrationInfo;
import com.ontarget.util.ConvertPOJOUtils;
import com.ontarget.util.Security;

/**
 * Created by sumit on 12/1/14.
 */
@Component
@Path("/register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRegistrationImpl implements com.ontarget.api.rs.UserRegistration {

	private Logger logger = Logger.getLogger(UserRegistrationImpl.class);

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ProjectService projectService;

	@Override
	@POST
	@Path("/inviteUserIntoProject")
	public OnTargetResponse inviteUserIntoProject(InviteUserIntoProjectRequest inviteUserIntoProjectRequest) {

		Integer projectId = inviteUserIntoProjectRequest.getProjectId();
		String firstName = inviteUserIntoProjectRequest.getFirstName();
		String lastName = inviteUserIntoProjectRequest.getLastName();
		String email = inviteUserIntoProjectRequest.getEmail();
		OnTargetResponse response = new OnTargetResponse();
		if (projectId > 0) {
			logger.info("This is first name " + firstName + " last name " + lastName + " and email" + email);

			final String tokenId = Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);

			try {
				UserInvitationRequestDTO userInvitationRequestDTO = ConvertPOJOUtils.convertToUserInvitationDTO(
						inviteUserIntoProjectRequest, tokenId);

				if (userProfileService.saveRegistration(userInvitationRequestDTO)) {
					response.setReturnVal(OnTargetConstant.SUCCESS);
					response.setReturnMessage(OnTargetConstant.SUCCESSFULLY_REGISTERED);

					String senderFirstName = "";
					String senderLastName = "";
					ProjectInfo res = projectService.getProject(projectId);
					long owner = res.getProjectOwnerId();
					Contact c = userProfileService.getContact(owner);
					senderFirstName = c.getFirstName();
					senderLastName = c.getLastName();

					emailService.sendUserRegistrationEmail(email, tokenId, firstName, senderFirstName, senderLastName);
					response.setReturnMessage("Email sent. Please check mail");
					response.setReturnVal(OnTargetConstant.SUCCESS);
				} else {
					response.setReturnMessage("Registration save failed");
					response.setReturnVal(OnTargetConstant.ERROR);
				}
			} catch (Exception e) {
				logger.error("Error while inviting user to project.", e);
				response.setReturnMessage("Error while saving registration request and sending email.");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} else {
			response.setReturnMessage("Mandatory field missing");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	// @Override
	// @POST
	// @Path("/inviteToNewAccount")
	// public OnTargetResponse
	// inviteUserIntoNewAccount(InviteUserIntoProjectRequest
	// inviteUserIntoProjectRequest) {
	// OnTargetResponse response = new OnTargetResponse();
	//
	// logger.info("This is first name " +
	// inviteUserIntoProjectRequest.getFirstName() + " last name "
	// + inviteUserIntoProjectRequest.getLastName() + " and email" +
	// inviteUserIntoProjectRequest.getEmail());
	//
	// String firstName = inviteUserIntoProjectRequest.getFirstName();
	// String lastName = inviteUserIntoProjectRequest.getLastName();
	// String email = inviteUserIntoProjectRequest.getEmail();
	//
	// final String tokenId =
	// Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
	// try {
	// if
	// (userProfileService.saveRegistration(inviteUserIntoProjectRequest.getProjectId(),
	// inviteUserIntoProjectRequest.getFirstName(),
	// inviteUserIntoProjectRequest.getLastName(),
	// inviteUserIntoProjectRequest.getEmail(),
	// inviteUserIntoProjectRequest.getRegistrationToken(),
	// OnTargetConstant.AccountStatus.ACCT_NEW)) {
	//
	// emailService.sendInviteToAccountEmail(email, firstName, lastName,
	// tokenId);
	// response.setReturnMessage("Email sent. Please check mail");
	// response.setReturnVal(OnTargetConstant.SUCCESS);
	// } else {
	// response.setReturnMessage("Registration save failed");
	// response.setReturnVal(OnTargetConstant.ERROR);
	// }
	// } catch (Exception e) {
	// logger.debug(e.getMessage(), e);
	// response.setReturnMessage(e.getMessage());
	// response.setReturnVal(OnTargetConstant.ERROR);
	// }
	//
	// return response;
	// }

	@Override
	@GET
	@Path("/validateLink")
	public UserInviteResponse validateLink(@NotEmpty @QueryParam("q") String link) {
		UserInviteResponse response = new UserInviteResponse();

		UserRegistration userRegistration = null;
		try {
			userRegistration = userProfileService.getRegistration(link);
		} catch (Exception e) {
			logger.error("Error while getting registration request", e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while retrieving user registration request");
			return response;
		}
		if (userRegistration == null) {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("no user registration for the specified token exists");
			return response;
		}

		String status = userRegistration.getStatus();
		if (status != null && (status.equals("deactivated") || status.equals("user-created"))) {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Deactivated Link. Please try with new link");
			return response;
		}

		if (System.currentTimeMillis() - userRegistration.getTsCreate() > OnTargetConstant.TOKEN_MAX_LIFE) {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("expired link. Please try with new link");
			return response;
		}
		response.setReturnVal(OnTargetConstant.SUCCESS);
		response.setReturnMessage("Successfully retrieved registration request.");
		response.setUserRegistration(userRegistration);
		return response;
	}

	@Override
	@POST
	@Path("/createUser")
	public OnTargetResponse createNewUser(UserRegistrationInfo request) {
		logger.info("Adding new user: " + request);
		OnTargetResponse response = new OnTargetResponse();
		try {
			return userProfileService.createNewUserFromInvitation(request);
		} catch (Exception e) {
			logger.debug("Error while creating user based on invitation", e);
			response.setReturnMessage("Error while creating user based on invitation.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@GET
	@Path("/activateAccount/{userId}")
	public OnTargetResponse activateAccount(@NotNull @PathParam("userId") Integer userId) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (userProfileService.activateAccount(userId)) {
				response.setReturnMessage("Successfully activated user");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				throw new Exception("Error while activating.");
			}
		} catch (Exception e) {
			logger.error("Error while activating account.");
			response.setReturnMessage("Error while activating account");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

}
