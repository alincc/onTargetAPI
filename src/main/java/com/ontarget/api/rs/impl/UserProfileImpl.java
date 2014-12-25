package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.UserProfile;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.ProjectService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.Project;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.*;
import com.ontarget.util.Security;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public UserProfileResponse addUserProfile(UserProfileRequest userProfileRequest) {
        logger.info("Received request to add profile: " + userProfileRequest);
        UserProfileResponse response = null;
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
    public OnTargetResponse updateUserProfile(UserProfileRequest userProfileRequest) {
        logger.info("Received request to add profile: " + userProfileRequest);
        System.out.println("Received request to add profile: " + userProfileRequest);
        OnTargetResponse response = null;
        try {
            response = userProfileService.updateUserProfileAndContactInfo(userProfileRequest);
        } catch (Exception e) {
            logger.error("Add User Profile failed." + e);
            response.setReturnMessage("Update task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @POST
    @Path("/changeUserPassword")
    public OnTargetResponse changeUserPassword(ChangeUserPasswordRequest request) throws Exception {
        long userId = request.getUserId();
        String newPassword = request.getNewPassword();
        String currentPassword = request.getCurrentPassword();

//        System.out.println("this is user id " + userId + " password " + newPassword);
        OnTargetResponse response = new OnTargetResponse();
        try {
            if (userProfileService.changeUserPassword(userId, newPassword, currentPassword)) {
                response.setReturnMessage("succesfully updated");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            } else {
                logger.error("failed updating password");
                response.setReturnMessage("Add task failed");
                response.setReturnVal(OnTargetConstant.ERROR);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error("Add User Profile failed." + e);
            response.setReturnMessage("Add task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @POST
    @Path("/inviteUserIntoProject")
    public OnTargetResponse inviteUserIntoProject(UserInvitationRequest request) {
        long projectId = request.getProjectId();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        OnTargetResponse response = new OnTargetResponse();
        if (projectId > 0) {
            logger.info("This is first name " + firstName + " last name " + lastName + " and email" + email);

            // generate token id
            final String tokenId = Security.generateRandomValue(TOKEN_LENGTH);
            // save into registration table
            try {
                if (userProfileService.saveRegistration(projectId, firstName, lastName, email, tokenId, OnTargetConstant.AccountStatus.ACCT_NEW)) {
                    Project res = projectService.getProject(projectId);
                    long owner = res.getProjectOwnerId();
                    Contact c = userProfileService.getContact(owner);

                    // build n send email
                    emailService.sendUserRegistrationEmail(email, tokenId, firstName, c.getFirstName(), c.getLastName());
                    response.setReturnMessage("Email sent. Please check mail");
                    response.setReturnVal(OnTargetConstant.SUCCESS);
                } else {
                    response.setReturnMessage("Registration save failed");
                    response.setReturnVal(OnTargetConstant.ERROR);
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
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
    public SafetyInfoResponse getSafetyInfoForUser(@QueryParam("userId") long userId) {
        System.out.println("this is user id " + userId);
        SafetyInfoResponse response = new SafetyInfoResponse();
        try {
            String safetyUserInfo = userProfileService.getRandomSafetyUserInfo(userId);
            if (safetyUserInfo == null) {
                response.setReturnVal(OnTargetConstant.ERROR);
                response.setReturnMessage("Null info");
            } else {
                response.setSafetyInfo(safetyUserInfo);
                response.setReturnVal(OnTargetConstant.SUCCESS);
            }
        } catch (Exception e) {
            response.setReturnMessage(e.getMessage());
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @POST
    @Path("/saveUserProfileImage")
    public OnTargetResponse saveUserProfileImage(UserImageRequest userImageRequest) {
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
                e.printStackTrace();
                logger.error(e.getMessage());
                response.setReturnVal(OnTargetConstant.ERROR);
            }
        }

        return response;
    }
}
