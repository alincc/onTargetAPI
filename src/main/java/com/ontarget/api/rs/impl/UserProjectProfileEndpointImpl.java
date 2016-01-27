package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.UserProjectProfileEndpoint;
import com.ontarget.api.service.UserProjectProfileService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.UserProjectProfile;
import com.ontarget.request.bean.UserProjectProfileRequest;
import com.ontarget.response.bean.UserProjectProfileResponse;
import com.ontarget.util.UserProjectProfileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;


/**
 * Created by TRON on 1/26/2016.
 */

@Component
@Path("/project/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserProjectProfileEndpointImpl implements UserProjectProfileEndpoint {


    private Logger logger = Logger.getLogger(UserProjectProfileEndpointImpl.class);

    @Autowired
    private UserProjectProfileService userProjectProfileService;

    @Override
    @POST
    @Path("/save")
    public OnTargetResponse saveOrUpdateUserProjectProfile(@Valid UserProjectProfileRequest request) {
        logger.debug("saving user profile id having userid: "+ request.getBaseRequest().getLoggedInUserId() + " and  projectid: "+ request.getBaseRequest().getLoggedInUserProjectId());
        OnTargetResponse response = new OnTargetResponse();
        try {
            UserProjectProfile userProjectProfile = userProjectProfileService.saveOrUpdate(UserProjectProfileUtil.getUserProjectProfileFromUserProfileRequest(request));
            response.setReturnMessage("Successfully updated UserProjectProfile Information");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Error while updating UserProjectProfile Information",e);
            response.setReturnMessage("Error while updateing User's Project Profile.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }
}
