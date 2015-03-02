package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInvitationRequest;
import com.ontarget.dto.UserInviteResponse;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserRegistrationRequest;

import javax.ws.rs.*;

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
	OnTargetResponse createNewUser(UserRegistrationRequest userRegistrationRequest);

	@POST
	@Path("/activateAccount/{userId}")
	OnTargetResponse activateAccount(@PathParam("userId") int userId);
}
