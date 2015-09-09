package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInvitationApprovalResponse;
import com.ontarget.request.bean.UserInvitationRequest;

//http://docs.jboss.org/hibernate/validator/4.0.1/reference/en/html_single/#validator-defineconstraints-builtin
public interface UserInvitation {

	public OnTargetResponse inviteUserIntoNewAccount(
			@Valid UserInvitationRequest request);

	public UserInvitationApprovalResponse getPendingRequestList();

	public OnTargetResponse approveRequest(
			@Min(value = 1, message = "{id.required}") @QueryParam("id") int id);


    OnTargetResponse rejectNewAccountRequest(@Min(value = 1, message = "{id.required}") @QueryParam("id") int id);

    public OnTargetResponse verifyToken(@NotNull @QueryParam("token") String token);
}
