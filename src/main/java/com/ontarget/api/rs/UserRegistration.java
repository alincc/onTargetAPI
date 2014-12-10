package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInviteResponse;

import javax.ws.rs.*;

/**
 * Created by sumit on 12/1/14.
 */
public interface UserRegistration {
    @GET
    @Path("/inviteUserIntoProject")
    OnTargetResponse inviteUserIntoProject(@QueryParam("projectId") long projectId, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("email") String email);

    @POST
    @Path("/inviteToNewAccount")
    OnTargetResponse inviteUserIntoNewAccount(com.ontarget.bean.UserRegistration registration);

    @GET
    @Path("/validateLink")
    UserInviteResponse validateLink(@QueryParam("q") String link);

    @POST
    @Path("/createUser")
    OnTargetResponse createNewUser(com.ontarget.bean.UserRegistration request);

    @POST
    @Path("/activateAccount/{userId}")
    OnTargetResponse activateAccount(@PathParam("userId") int userId);
}
