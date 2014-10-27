package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.Authentication;
import com.ontarget.bean.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Owner on 10/26/14.
 */
@Path("/user")
@Produces("application/json")
@Consumes("application/json")
@Component
public class AuthenticationImpl  implements Authentication{

    @Override
    @Path("/signin")
    public User signIn(@FormParam("username") String username, @FormParam("password") String password) {
        User user = new User();
        user.setToken( "123456789abcdef");
        return user;
    }

}
