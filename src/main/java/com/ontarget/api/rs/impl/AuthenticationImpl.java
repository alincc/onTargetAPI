package com.ontarget.api.rs.impl;

import com.ontarget.api.response.OnTargetResponse;
import com.ontarget.api.response.UserResponse;
import com.ontarget.api.rs.Authentication;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.bean.User;
import com.ontarget.bean.UserRegistrationRequest;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Owner on 10/26/14.
 */
@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationImpl  implements Authentication{

    private Logger logger = Logger.getLogger(AuthenticationImpl.class);

    @Autowired
    private AuthenticationService authenticationService;

    @POST
    @Path("/signin")
    public UserResponse signIn(User user) {

        logger.info("request: "+ user);

        UserResponse response = new UserResponse();
        response.setToken("12345abcdef");
        response.setUser(user);
        response.setReturnMessage(OnTargetConstant.RETURN_MESSAGE_AUTHENTICATION);
        response.setReturnVal(OnTargetConstant.SUCCESS);
        return response;
    }

    @Override
    public UserResponse register(User user) {
        return null;
    }

    @Override
    @POST
    @Path("/registrationRequest")
    public OnTargetResponse registrationRequest(UserRegistrationRequest request) {
        OnTargetResponse response=new OnTargetResponse();
        try {
            if(authenticationService.registrationRequest(request)){
                response.setReturnVal(OnTargetConstant.SUCCESS);
                response.setReturnMessage(OnTargetConstant.SUCCESSFULLY_REGISTERED);
            }
        } catch (Exception e) {
            logger.error("Error while saving registration request.",e);
            response.setReturnMessage(OnTargetConstant.REGISTRATION_REQUEST_FAILED);
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @POST
    @Path("/logout")
    public OnTargetResponse logout(User user) {
        try {
            if(authenticationService.logout(user.getUsername())){

            }

        } catch (Exception e) {
            logger.error("Error while logging out."+e);
        }

        return null;
    }

}
