package com.ontarget.api.service;

import com.ontarget.dto.UserInvitationApprovalResponse;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;
import com.ontarget.request.bean.UserRegistrationRequestBean;


public interface UserInvitationService {

	public boolean registrationRequest(UserInvitationRequestDTO request)
			throws Exception;

	public UserInvitationApprovalResponse retrievePendingRegRequestList()
			throws Exception;

	public boolean approvePendingRequest(int id) throws Exception;
	
	public RegistrationRequestResponseDTO getRequestByToken(String token) throws Exception;
	
	public RegistrationRequestResponseDTO getRegistrationRequest(String email) throws Exception;

}
