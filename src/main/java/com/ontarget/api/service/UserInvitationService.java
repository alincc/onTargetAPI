package com.ontarget.api.service;

import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserRegistrationRequest;

public interface UserInvitationService {

	public boolean registrationRequest(UserRegistrationRequest request)
			throws Exception;

	public UserRegistationApprovalResponse retrievePendingRegRequestList()
			throws Exception;

	public boolean approvePendingRequest(int id) throws Exception;
	
	public UserRegistrationRequest getRequestByToken(String token) throws Exception;

}
