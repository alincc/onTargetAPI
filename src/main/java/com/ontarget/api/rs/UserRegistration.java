package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.hibernate.validator.constraints.NotEmpty;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInviteResponse;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserSignupRequest;

/**
 * Created by sumit on 12/1/14.
 */
public interface UserRegistration {

	OnTargetResponse inviteUserIntoProject(
			@Valid InviteUserIntoProjectRequest request);

	UserInviteResponse validateLink(@NotEmpty @QueryParam("q") String link);

	OnTargetResponse createNewUser(@Valid UserSignupRequest request);

	OnTargetResponse activateAccount(
			@NotNull @PathParam("userId") Integer userId);
}
