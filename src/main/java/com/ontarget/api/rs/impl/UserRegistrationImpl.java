package com.ontarget.api.rs.impl;

import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.ProjectService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.Project;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInviteResponse;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserRegistrationRequest;
import com.ontarget.util.Security;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by sumit on 12/1/14.
 */
@Component
@Path("/register")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserRegistrationImpl implements
		com.ontarget.api.rs.UserRegistration {

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
	public OnTargetResponse inviteUserIntoProject(
			InviteUserIntoProjectRequest inviteUserIntoProjectRequest) {

		int projectId = inviteUserIntoProjectRequest.getProjectId();
		String firstName = inviteUserIntoProjectRequest.getFirstName();
		String lastName = inviteUserIntoProjectRequest.getLastName();
		String email = inviteUserIntoProjectRequest.getEmail();
		OnTargetResponse response = new OnTargetResponse();
		if (projectId > 0) {
			logger.info("This is first name " + firstName + " last name "
					+ lastName + " and email" + email);

			// generate token id
			final String tokenId = Security
					.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
			// save into registration table
			logger.info("token id:: " + tokenId);
			try {
				if (userProfileService.saveRegistration(projectId, firstName,
						lastName, email, tokenId,
						OnTargetConstant.AccountStatus.ACCOUNT_INVITATION)) {
					Project res = projectService.getProject(projectId);
					long owner = res.getProjectOwnerId();
					Contact c = userProfileService.getContact(owner);

					// build n send email
					emailService.sendUserRegistrationEmail(email, tokenId,
							firstName, c.getFirstName(), c.getLastName());
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

	@Override
	@POST
	@Path("/inviteToNewAccount")
	public OnTargetResponse inviteUserIntoNewAccount(
			InviteUserIntoProjectRequest inviteUserIntoProjectRequest) {
		OnTargetResponse response = new OnTargetResponse();

		logger.info("This is first name "
				+ inviteUserIntoProjectRequest.getFirstName() + " last name "
				+ inviteUserIntoProjectRequest.getLastName() + " and email"
				+ inviteUserIntoProjectRequest.getEmail());

		String firstName = inviteUserIntoProjectRequest.getFirstName();
		String lastName = inviteUserIntoProjectRequest.getLastName();
		String email = inviteUserIntoProjectRequest.getEmail();

		// generate token id
		final String tokenId = Security
				.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
		// save into registration table
		try {
			if (userProfileService.saveRegistration(
					inviteUserIntoProjectRequest.getProjectId(),
					inviteUserIntoProjectRequest.getFirstName(),
					inviteUserIntoProjectRequest.getLastName(),
					inviteUserIntoProjectRequest.getEmail(),
					inviteUserIntoProjectRequest.getRegistrationToken(),
					OnTargetConstant.AccountStatus.ACCT_NEW)) {

				// build n send email
				emailService.sendInviteToAccountEmail(email, firstName,
						lastName, tokenId);
				response.setReturnMessage("Email sent. Please check mail");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				response.setReturnMessage("Registration save failed");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
			response.setReturnMessage(e.getMessage());
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@GET
	@Path("/validateLink")
	public UserInviteResponse validateLink(@QueryParam("q") String link) {
		UserInviteResponse response = new UserInviteResponse();
		if (link == null || link.isEmpty()) {
			response.setReturnMessage("No link specified");
			return response;
		}

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
		if (status != null
				&& (status.equals("deactivated") || status
						.equals("user-created"))) {
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
	public OnTargetResponse createNewUser(
			UserRegistrationRequest userRegistrationRequest) {
		logger.info("Adding new user: " + userRegistrationRequest);
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean created = userProfileService
					.createNewUserFromInvitation(userRegistrationRequest);
			if (created) {
				response.setReturnMessage("Successfully created user based on invitation.");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				throw new Exception("Error while creating user.");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.debug("Error while creating user based on invitation", e);
			response.setReturnMessage("Error while creating user based on invitation.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@GET
	@Path("/activateAccount/{userId}")
	public OnTargetResponse activateAccount(@PathParam("userId") int userId) {
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
