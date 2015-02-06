package com.ontarget.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.api.service.UserInvitationService;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserRegistrationRequest;

@Service
public class UserInvitationServiceImpl implements UserInvitationService {
	private Logger logger = Logger.getLogger(UserInvitationServiceImpl.class);

	@Autowired
	private UserInvitationDAO userInvitationDAO;

	@Override
	public boolean registrationRequest(UserRegistrationRequest request)
			throws Exception {
		return userInvitationDAO.saveRegistrationRequest(request);
	}

	@Override
	public UserRegistationApprovalResponse retrievePendingRegRequestList()
			throws Exception {
		List<UserRegistrationRequest> pendingRequestsList = userInvitationDAO
				.fetchPendingRequests();
		UserRegistationApprovalResponse response = new UserRegistationApprovalResponse();
		response.setUserRegistrationRequestList(pendingRequestsList);
		return response;
	}

	@Override
	public boolean approvePendingRequest(int id) throws Exception {
		return userInvitationDAO.approvePendingRequest(id);
	}

	@Override
	public UserRegistrationRequest getRequestByToken(String token) throws Exception {
		return userInvitationDAO.findRequestByToken(token);
	}

}
