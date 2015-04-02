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

import com.ontarget.api.rs.UserProfile;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.ProjectService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.ChangeUserPasswordRequest;
import com.ontarget.dto.ForgotPasswordRequest;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SafetyInfoResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.util.Security;

/**
 * Created by Owner on 11/4/14.
 */
@Component
@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserProfileImpl implements UserProfile {

	public static final int TOKEN_LENGTH = 25;
	private Logger logger = Logger.getLogger(UserProfileImpl.class);

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ProjectService projectService;

	@Override
	@POST
	@Path("/addUserProfile")
	public UserProfileResponse addUserProfile(
			UserProfileRequest userProfileRequest) {
		logger.info("Received request to add profile: " + userProfileRequest);
		UserProfileResponse response = new UserProfileResponse();
		try {
			response = userProfileService.addUserProfile(userProfileRequest);
		} catch (Exception e) {
			logger.error("Add User Profile failed.", e);
			response.setReturnMessage("Add task failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/updateUserProfile")
	public OnTargetResponse updateUserProfile(
			UpdateUserProfileRequest userProfileRequest) {
		logger.info("Received request to add profile: " + userProfileRequest);
		OnTargetResponse response = new UserProfileResponse();
		try {
			response = userProfileService
					.updateUserProfileAndContactInfo(userProfileRequest);
		} catch (Exception e) {
			logger.error("Add User Profile failed.", e);
			response.setReturnMessage("Update task failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/changeUserPassword")
	public OnTargetResponse changeUserPassword(ChangeUserPasswordRequest request)
			throws Exception {
		Integer userId = request.getUserId();
		String newPassword = request.getNewPassword();
		String currentPassword = request.getCurrentPassword();

		OnTargetResponse response = new OnTargetResponse();
		try {
			if (userProfileService.changeUserPassword(userId, newPassword,
					currentPassword)) {
				response.setReturnMessage("succesfully updated");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				logger.error("failed updating password");
				response.setReturnMessage("Change user password failed");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Add User Profile failed.", e);
			response.setReturnMessage("Error while changing user password");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/changeForgotPassword")
	public OnTargetResponse changeForgotPassword(ForgotPasswordRequest request)
			throws Exception {
		logger.debug("Changing the forgot password request based on token: "
				+ request.getForgotPasswordToken());

		String newPassword = request.getNewPassword();
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (userProfileService.changeForgotPassword(
					request.getForgotPasswordToken(), newPassword)) {
				response.setReturnMessage("Forgot Password Succesfully changed");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				logger.error("failed updating password");
				response.setReturnMessage("Change forgot password failure");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Add User Profile failed.", e);
			response.setReturnMessage("Change forgot password failure");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/inviteUserIntoProject")
	public OnTargetResponse inviteUserIntoProject(
			InviteUserIntoProjectRequest request) {
		int projectId = 0;// request.getBaseRequest().getProjectId();
		String firstName = request.getFirstName();
		String lastName = request.getLastName();
		String email = request.getEmail();
		OnTargetResponse response = new OnTargetResponse();
		if (projectId > 0) {
			logger.info("This is first name " + firstName + " last name "
					+ lastName + " and email" + email);

			// generate token id
			final String tokenId = Security.generateRandomValue(TOKEN_LENGTH);
			// save into registration table
			try {
				if (userProfileService.saveRegistration(projectId, firstName,
						lastName, email, tokenId,
						OnTargetConstant.AccountStatus.ACCT_NEW)) {
					ProjectInfo res = projectService.getProject(projectId);
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
				logger.debug(e.getMessage(), e);
				response.setReturnMessage("Error while saving registration request");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} else {
			response.setReturnMessage("Mandatory field missing");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@GET
	@Path("/getSafetyInfoForUser")
	public SafetyInfoResponse getSafetyInfoForUser(
			@NotNull @QueryParam("userId") Integer userId) {
		SafetyInfoResponse response = new SafetyInfoResponse();
		try {
			String safetyUserInfo = userProfileService
					.getRandomSafetyUserInfo(userId);
			if (safetyUserInfo == null) {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("No safety info found");
			} else {
				response.setSafetyInfo(safetyUserInfo);
				response.setReturnVal(OnTargetConstant.SUCCESS);
			}
		} catch (Exception e) {
			logger.error("Error while getting safety info", e);
			response.setReturnMessage("Error while getting safety info");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/saveUserProfileImage")
	public OnTargetResponse saveUserProfileImage(
			UserImageRequest userImageRequest) {
		OnTargetResponse response = new OnTargetResponse();
		if (userImageRequest == null) {
			response.setReturnMessage("param are null");
			response.setReturnVal(OnTargetConstant.ERROR);
		} else {
			try {
				if (userProfileService.saveUserImage(userImageRequest)) {
					response.setReturnVal(OnTargetConstant.SUCCESS);
				}
			} catch (Exception e) {
				logger.debug(e.getMessage(), e);
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		}

		return response;
	}

	@Override
	@POST
	@Path("/forgotPasswordRequest")
	public OnTargetResponse forgotPasswordRequest(ForgotPasswordRequest request) {
		OnTargetResponse response = new OnTargetResponse();

		try {
			boolean done = userProfileService.forgotPasswordRequest(request
					.getEmailAddress());
			if (done) {
				response.setReturnMessage("Email has been sent to "
						+ request.getEmailAddress()
						+ " with password reset instructions.");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				response.setReturnMessage("Invalid user.");
				response.setReturnVal(OnTargetConstant.ERROR);
			}

		} catch (Exception e) {
			logger.error("Error while processing forgot password request", e);
			response.setReturnMessage("Error while processing forgot password request.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@GET
	@Path("/validateForgotPassword/{forgotPasswordToken}")
	public OnTargetResponse validateForgotPasswordToken(
			@NotEmpty @PathParam("forgotPasswordToken") String forgotPasswordToken) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean validated = userProfileService
					.validateForgotPasswordToken(forgotPasswordToken);
			if (validated) {
				response.setReturnMessage("Valid Token");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				response.setReturnMessage("Invalid request. Forgot password request expired.");
				response.setReturnVal(OnTargetConstant.ERROR);
			}

		} catch (Exception e) {
			logger.error("Error while validating forgot password token", e);
			response.setReturnMessage("Error while validating forgot password token.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
