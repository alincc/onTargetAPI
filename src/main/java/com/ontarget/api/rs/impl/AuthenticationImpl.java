package com.ontarget.api.rs.impl;

import com.ontarget.api.response.UserResponse;
import com.ontarget.api.rs.Authentication;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetConstant;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Owner on 10/26/14.
 */
@Path("/user")
public class AuthenticationImpl  implements Authentication{

    @POST
    @Path("/signin")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserResponse signIn(User user) {
        UserResponse response = new UserResponse();
        response.setToken("12345abcdef");
        response.setUser(user);
        response.setReturnMessage(OnTargetConstant.RETURN_MESSAGE_AUTHENTICATION);
        response.setReturnVal(OnTargetConstant.SUCCESS);
        return response;
    }

}
