package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.UserProfile;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.ProjectService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
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
            logger.error("Add User Profile failed." + e);
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
    @GET
    @Path("/changeUserPassword")
    public OnTargetResponse changeUserPassword(@QueryParam("userId") long userId, @QueryParam("password") String password) throws Exception {
        System.out.println("this is user id " + userId + " password " + password);
        OnTargetResponse response = new OnTargetResponse();
        try {
            if (userProfileService.changeUserPassword(userId, password)) {
                response.setReturnMessage("succesfully updated");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            } else {
                logger.error("failed updating password");
                response.setReturnMessage("Add task failed");
                response.setReturnVal(OnTargetConstant.ERROR);
            }
        } catch (Exception e) {
            logger.error("Add User Profile failed." + e);
            response.setReturnMessage("Add task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }


}
