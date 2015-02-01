package com.ontarget.api.rs;

import javax.ws.rs.QueryParam;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.dto.UserResponse;

public interface UserInvitation {

	public OnTargetResponse inviteUserIntoNewAccount(
			UserRegistrationRequest request);

	public UserRegistationApprovalResponse getPendingRequestList();

	public OnTargetResponse approveRequest(@QueryParam("id") int id);
	
	public OnTargetResponse verifyToken(@QueryParam("token") String token);
}
