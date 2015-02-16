package com.ontarget.api.rs;

import javax.ws.rs.QueryParam;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserInvitationApprovalResponse;
import com.ontarget.request.bean.UserInvitationRequestBean;

public interface UserInvitation {

	public OnTargetResponse inviteUserIntoNewAccount(
			UserInvitationRequestBean request);

	public UserInvitationApprovalResponse getPendingRequestList();

	public OnTargetResponse approveRequest(@QueryParam("id") int id);

	public OnTargetResponse verifyToken(@QueryParam("token") String token);
}
