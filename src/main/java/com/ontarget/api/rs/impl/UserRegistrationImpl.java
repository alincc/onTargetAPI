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

import com.ontarget.api.dao.UserProjectProfileDAO;
import com.ontarget.api.jpa.dao.impl.UserProjectProfileJpaDAOImpl;
import com.ontarget.api.service.*;
import com.ontarget.entities.*;
import com.ontarget.enums.*;
import com.ontarget.enums.UserType;
import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.bean.Contact;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.dto.UserInviteResponse;
import com.ontarget.request.bean.AssignUserToProjectRequest;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserSignupRequest;
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

	@Autowired
	private UserInvitationService userInvitationService;

    @Autowired
    private UserProjectProfileService userProjectProfileService;

	@Override
	@POST
	@Path("/inviteUserIntoProject")
	public OnTargetResponse inviteUserIntoProject(InviteUserIntoProjectRequest request) {
		logger.info("Inviting user into project id: " + request.getProjectId() + ", invited email: " + request.getEmail());
		Integer projectId = request.getProjectId();
		String email = request.getEmail();
		OnTargetResponse response = new OnTargetResponse();
		if (projectId > 0) {
			logger.info("email" + email + ", project id " + projectId);

			try {
				Email emailEntity = userProfileService.findEmailByEmailAddres(email);
				logger.debug("email entity for email address: " + email);

				boolean signup = true;

				if (emailEntity == null) {
					/** new signup user **/

					RegistrationRequest registrationRequest = userInvitationService.findRecentRegRequestByEmail(email);
					logger.info("registration request by email: " + registrationRequest);

					if (registrationRequest != null) {
						if (System.currentTimeMillis() - registrationRequest.getTsCreate().getTime() <= OnTargetConstant.TOKEN_MAX_LIFE) {
							response.setReturnVal(OnTargetConstant.ERROR);
							response.setReturnMessage("User with provided email address is already invited");
							return response;
						}
					}
				} else {
					/** project member invite request **/
					signup = false;

					/**
					 * already registered user so let's check if user with
					 * provided email is already invited to the project
					 * 
					 */
					RegistrationRequest registrationRequestWithProjectId = userInvitationService.findRecentRegRequestByEmailAndProjectId(
							email, projectId);
					logger.info("registration request with project id: " + registrationRequestWithProjectId);

					if (registrationRequestWithProjectId != null) {

						if (registrationRequestWithProjectId.getUserId() == null) {
							/**
							 * user is not assigned to project yet and waiting
							 * for approval from user
							 *
							 */
							if (System.currentTimeMillis() - registrationRequestWithProjectId.getTsCreate().getTime() <= OnTargetConstant.TOKEN_MAX_LIFE) {
								response.setReturnVal(OnTargetConstant.ERROR);
								response.setReturnMessage("User has been already invited to the project and waiting for approval from user");
								return response;
							}

						} else {
							response.setReturnVal(OnTargetConstant.ERROR);
							response.setReturnMessage("User is already a member of invited project");
							return response;
						}
					}
				}

				final String tokenId = Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);

				UserInvitationRequestDTO userInvitationRequestDTO = ConvertPOJOUtils.convertToUserInvitationDTO(request, tokenId);

				String status = signup ? OnTargetConstant.RegistrationRequestStatus.ACCT_INVITE
						: OnTargetConstant.RegistrationRequestStatus.PROJECT_MEMBER_INVITE;
				logger.debug("status for registration request: " + status);

				if (userProfileService.saveRegistration(userInvitationRequestDTO, status)) {
					response.setReturnVal(OnTargetConstant.SUCCESS);
					response.setReturnMessage(OnTargetConstant.SUCCESSFULLY_REGISTERED);

					Project project = projectService.findProjectById(projectId);
					logger.info("project name: "+project.getProjectName());

					Contact contact = userProfileService.getContact(request.getBaseRequest().getLoggedInUserId());
					String senderFirstName = contact.getFirstName();
					String senderLastName = contact.getLastName();


                    String firstName=request.getFirstName();
					if (signup) {
						emailService.sendUserRegistrationEmail(email, tokenId, firstName, senderFirstName, senderLastName,
								project.getProjectName());
					} else {
                        Contact receiverContact = userProfileService.getContact(emailEntity.getUser().getUserId());
                        firstName=receiverContact.getFirstName();
						emailService.sendInviteUserToProjectEmail(email, tokenId, firstName, senderFirstName, senderLastName,
								project.getProjectName());
					}
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
	public OnTargetResponse createNewUser(UserSignupRequest request) {
		logger.info("Adding new user: " + request);
		OnTargetResponse response = new OnTargetResponse();
		try {
			return userProfileService.createNewUserFromInvitation(request);
		} catch (Exception e) {
			logger.debug("Error while creating user", e);
			response.setReturnMessage("Error while creating user.");
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

	@Override
	@POST
	@Path("/assignInvitedProjectToMember")
	public OnTargetResponse assignInvitedProjectToMember(AssignUserToProjectRequest request) {
		logger.info("Assigning invited project to member: token " + request.getToken());
		OnTargetResponse response = new OnTargetResponse();
		try {
			RegistrationRequest registrationRequest = userProfileService.findRegistrationRequestByToken(request.getToken());

			logger.debug("registration request: " + registrationRequest);

			if (registrationRequest == null) {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Not a valid request");
				return response;
			}

			if (System.currentTimeMillis() - registrationRequest.getTsCreate().getTime() > OnTargetConstant.TOKEN_MAX_LIFE) {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Your request has already expired. Please contact your manager to send another request.");
				return response;
			}

			boolean success = userProfileService.assignProjectToMember(registrationRequest);
			logger.debug("success: " + success);

            // give this user RU profile.
            UserProjectProfile projectProfile = new UserProjectProfile();
            projectProfile.setStatus(OnTargetConstant.UserProjectProfileStatus.ACTIVE);
            projectProfile.setProject(new Project(registrationRequest.getProjectId()));

            //find user by email address
            Email email = userProfileService.findEmailByEmailAddres(registrationRequest.getEmail());
            if(email == null){
                throw new Exception("Email cannot be null");
            }
            projectProfile.setUser(email.getUser());
            projectProfile.setProfile(new Profile(UserType.REGULARUSER.getProfileId())); //TODO: create service layer to get profile id
            userProjectProfileService.saveOrUpdate(projectProfile);


			if (success) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("You have been successfully added to the invited project.");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Adding user into project has been failed.");
			}
		} catch (Exception e) {
			logger.error("Error assigning project to member:  " + e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while assigning project to member");
		}
		return response;
	}

}
