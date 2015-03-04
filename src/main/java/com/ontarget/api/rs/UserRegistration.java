package com.ontarget.api.rs;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInviteResponse;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserRegistrationInfo;

/**
 * Created by sumit on 12/1/14.
 */
public interface UserRegistration {

	OnTargetResponse inviteUserIntoProject(InviteUserIntoProjectRequest request);

	@POST
	@Path("/inviteToNewAccount")
	OnTargetResponse inviteUserIntoNewAccount(
			InviteUserIntoProjectRequest registration);

	@GET
	@Path("/validateLink")
	UserInviteResponse validateLink(@QueryParam("q") String link);

	@POST
	@Path("/createUser")
	OnTargetResponse createNewUser(UserRegistrationInfo userRegistrationRequest);

	@POST
	@Path("/activateAccount/{userId}")
	OnTargetResponse activateAccount(@PathParam("userId") int userId);
}
