package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.UserProfile;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    @Override
    @POST
    @Path("/addUserProfile")
    public UserProfileResponse addUserProfile(UserProfileRequest userProfileRequest) {
        logger.info("Received request to add profile: "+ userProfileRequest);
        UserProfileResponse response=null;
        try {
            response =  userProfileService.addUserProfile(userProfileRequest);
        } catch (Exception e) {
            logger.error("Add User Profile failed."+ e);
            response.setReturnMessage("Add task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }


}
