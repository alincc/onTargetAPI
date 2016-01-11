package com.ontarget.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ontarget.api.service.EmailService;
import com.ontarget.util.EmailConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.api.service.UserInvitationService;
import com.ontarget.dto.UserInvitationApprovalResponse;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entities.RegistrationRequest;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;

@Service
public class UserInvitationServiceImpl implements UserInvitationService {
	private Logger logger = Logger.getLogger(UserInvitationServiceImpl.class);

	@Autowired
	@Qualifier("userInvitationJpaDAOImpl")
	private UserInvitationDAO userInvitationDAO;

    @Autowired
    private EmailService emailService;

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

		boolean success =  userInvitationDAO.approvePendingRequest(id);
        if(success){
            //prepare to send email.
            Map<String, Object> emailAttributes = new HashMap<>();
            RegistrationRequestResponseDTO info = userInvitationDAO.findRegRequestById(id);
            emailAttributes.put("registrationRequestInfo",info);
            emailAttributes.put("emailType", EmailConstant.SendEmailType.REQUEST_FOR_DEMO_APPROVED);
            emailService.sendEmail(emailAttributes);
        }
        return success;
	}

	@Override
	public RegistrationRequestResponseDTO getRequestByToken(String token) throws Exception {
		return userInvitationDAO.findRequestByToken(token);
	}

	@Override
	public RegistrationRequest findRecentRegRequestByEmail(String email) {
		return userInvitationDAO.findRecentRegRequestByEmail(email);
	}
	
	@Override
	public RegistrationRequest findRecentRegRequestByEmailAndProjectId(String email,Integer projectId) {
		return userInvitationDAO.findRecentRegRequestByEmailAndProjectId(email, projectId);
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
