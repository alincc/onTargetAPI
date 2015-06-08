package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;

public interface UserInvitationDAO {

	public boolean saveRegistrationRequest(
			UserInvitationRequestDTO userInvitationRequestDTO) throws Exception;

	public List<RegistrationRequestResponseDTO> fetchPendingRequests()
			throws Exception;

	public boolean approvePendingRequest(int regRequestId) throws Exception;

	public RegistrationRequestResponseDTO findRequestByToken(String token)
			throws Exception;

	public RegistrationRequestResponseDTO findRegRequestById(int id)
			throws Exception;

	public RegistrationRequestResponseDTO findRegRequestByEmail(String email)
			throws Exception;

    RegistrationRequestResponseDTO findRegRequestByUserId(long userId);
}
