package com.ontarget.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.api.service.UserInvitationService;
import com.ontarget.dto.UserInvitationApprovalResponse;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;

@Service
public class UserInvitationServiceImpl implements UserInvitationService {
	private Logger logger = Logger.getLogger(UserInvitationServiceImpl.class);

	@Autowired
	@Qualifier("userInvitationJpaDAOImpl")
	private UserInvitationDAO userInvitationDAO;

	@Override
	public boolean registrationRequest(UserInvitationRequestDTO request) throws Exception {
		return userInvitationDAO.saveRegistrationRequest(request);
	}

	@Override
	public UserInvitationApprovalResponse retrievePendingRegRequestList() throws Exception {
		List<RegistrationRequestResponseDTO> pendingRequestsList = userInvitationDAO.fetchPendingRequests();
		UserInvitationApprovalResponse response = new UserInvitationApprovalResponse();
		response.setApprovalDTOList(pendingRequestsList);
		return response;
	}

	@Override
	public boolean approvePendingRequest(int id) throws Exception {
		return userInvitationDAO.approvePendingRequest(id);
	}

	@Override
	public RegistrationRequestResponseDTO getRequestByToken(String token) throws Exception {
		return userInvitationDAO.findRequestByToken(token);
	}

	@Override
	public RegistrationRequestResponseDTO getRegistrationRequest(String email) throws Exception {
		return userInvitationDAO.findRegRequestByEmail(email);
	}

	@Override
	public boolean rejectPendingRequest(int id) throws Exception {
		return userInvitationDAO.rejectNewAccountRequest(id);
	}

}
