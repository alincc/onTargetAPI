package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInvitationRequest;
import com.ontarget.dto.UserInviteResponse;
import com.ontarget.request.bean.InviteUserIntoProjectRequestBean;
import com.ontarget.request.bean.UserRegistrationRequestBean;

import javax.ws.rs.*;

/**
 * Created by sumit on 12/1/14.
 */
public interface UserRegistration {

	OnTargetResponse inviteUserIntoProject(InviteUserIntoProjectRequestBean request);

	@POST
	@Path("/inviteToNewAccount")
	OnTargetResponse inviteUserIntoNewAccount(
			InviteUserIntoProjectRequestBean registration);

	@GET
	@Path("/validateLink")
	UserInviteResponse validateLink(@QueryParam("q") String link);

	@POST
	@Path("/createUser")
	OnTargetResponse createNewUser(UserRegistrationRequestBean userRegistrationRequest);

	@POST
	@Path("/activateAccount/{userId}")
	OnTargetResponse activateAccount(@PathParam("userId") int userId);
}
