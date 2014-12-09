package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInviteResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by sumit on 12/1/14.
 */
public interface UserRegistration {
    @GET
    @Path("/inviteUserIntoProject")
    OnTargetResponse inviteUserIntoProject(@QueryParam("projectId") long projectId, @QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName, @QueryParam("email") String email);

    @GET
    @Path("/validateLink")
    UserInviteResponse validateLink(@QueryParam("q") String link);
}
