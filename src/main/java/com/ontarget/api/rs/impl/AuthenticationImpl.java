package com.ontarget.api.rs.impl;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.api.rs.Authentication;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Owner on 10/26/14.
 */
@Component
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
    @Path("/getPendingUserRegistrationRequests")
    @GET
    public UserRegistationApprovalResponse getPendingUserRegistrationRequests(){
        UserRegistationApprovalResponse  response=null;
        try {
            response = authenticationService.getUserRegistrationPendingRequests();
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage(OnTargetConstant.PENDING_REQUEST_RECEIVED);
        }catch(Exception e){
            logger.error("Error while saving registration request.",e);
            response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_FAILED);
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }


    @Override
    @POST
    @Path("/approvePendingRequests")
    public OnTargetResponse approvePendingRegistrationRequest(List<UserRegistrationRequest> requests){
        OnTargetResponse response=null;
        try{
           if(authenticationService.approvePendingRegistrationRequest(requests)){
               response.setReturnVal(OnTargetConstant.SUCCESS);
               response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_SUCCESS);
           }
        }catch(Exception e){
            logger.error("Error while saving registration request.",e);
            response.setReturnMessage(OnTargetConstant.REGISTRATION_APPROVAL_REQUEST_FAILED);
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }



    @Override
    @POST
    @Path("/logout")
    public OnTargetResponse logout(User user) {
        OnTargetResponse response=null;
        try {
            if(authenticationService.logout(user.getUsername())){
                response.setReturnVal(OnTargetConstant.SUCCESS);
                response.setReturnMessage(OnTargetConstant.LOGOUT_SUCCESSFULL);
            }
        } catch (Exception e) {
            logger.error("Error while logging out."+e);
            response.setReturnMessage(OnTargetConstant.ERROR_LOGGEDOUT);
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }
}
