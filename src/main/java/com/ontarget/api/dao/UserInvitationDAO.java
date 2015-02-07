package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.dto.UserRegistrationRequest;

public interface UserInvitationDAO {

	public boolean saveRegistrationRequest(UserRegistrationRequest request)
			throws Exception;

	public List<UserRegistrationRequest> fetchPendingRequests()
			throws Exception;

	public boolean approvePendingRequest(int regRequestId) throws Exception;

	public UserRegistrationRequest findRequestByToken(String token) throws Exception;

	public UserRegistrationRequest findRegRequestById(int id) throws Exception;
	
	public UserRegistrationRequest findRegRequestByEmail(String email) throws Exception;

}
