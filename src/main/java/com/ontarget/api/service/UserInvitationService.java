package com.ontarget.api.service;

import com.ontarget.dto.UserInvitationApprovalResponse;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entities.RegistrationRequest;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;

public interface UserInvitationService {

	public boolean registrationRequest(UserInvitationRequestDTO request) throws Exception;

	public UserInvitationApprovalResponse retrievePendingRegRequestList() throws Exception;

	public boolean approvePendingRequest(int id) throws Exception;

	public RegistrationRequestResponseDTO getRequestByToken(String token) throws Exception;

	public RegistrationRequestResponseDTO getRegistrationRequest(String email) throws Exception;

    public boolean rejectPendingRequest(int id) throws Exception;
    
    public RegistrationRequest findRecentRegRequestByEmail(String email);
    
    public RegistrationRequest findRecentRegRequestByEmailAndProjectId(String email,Integer projectId);
}
