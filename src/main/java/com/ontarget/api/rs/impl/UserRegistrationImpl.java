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
public class UserRegistrationImpl implements com.ontarget.api.rs.UserRegistration {

    private Logger logger = Logger.getLogger(UserRegistrationImpl.class);

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ProjectService projectService;

    @Override
    @GET
    @Path("/inviteUserIntoProject")
    public OnTargetResponse inviteUserIntoProject(@QueryParam("projectId") long projectId, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("email") String email) {
        OnTargetResponse response = new OnTargetResponse();
        if (projectId > 0) {
            logger.info("This is first name " + firstName + " last name " + lastName + " and email" + email);

            // generate token id
            final String tokenId = Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
            // save into registration table
            try {
                if (userProfileService.saveRegistration(projectId, firstName, lastName, email, tokenId)) {
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
                response.setReturnMessage(e.getMessage());
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
    public UserInviteResponse validateLink(@QueryParam("q") String link) {
        UserInviteResponse response = new UserInviteResponse();
        response.setReturnVal(OnTargetConstant.ERROR);
        if (link == null || link.isEmpty()) {
            response.setReturnMessage("No link specified");
            return response;
        }

        UserRegistration userRegistration = null;
        try {
            userRegistration = userProfileService.getRegistration(link);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (userRegistration == null) {
            response.setReturnMessage("no user registration for the specified token exists");
            return response;
        }

        String status = userRegistration.getStatus();
        if (status != null && (status.equals("deactivated") || status.equals("user-created"))) {
            response.setReturnMessage("Deactivated Link. Please try with new link");
            return response;
        }

        if (System.currentTimeMillis() - userRegistration.getTsCreate() > OnTargetConstant.TOKEN_MAX_LIFE) {
            response.setReturnMessage("expired link. Please try with new link");
            return response;
        }

        response.setUserRegistration(userRegistration);
        return response;
    }

}
