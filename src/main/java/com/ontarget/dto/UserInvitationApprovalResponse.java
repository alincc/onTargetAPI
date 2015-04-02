package com.ontarget.dto;

import java.util.List;

import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;

public class UserInvitationApprovalResponse extends OnTargetResponse {
	private List<RegistrationRequestResponseDTO> approvalDTOList;

	public List<RegistrationRequestResponseDTO> getApprovalDTOList() {
		return approvalDTOList;
	}

	public void setApprovalDTOList(
			List<RegistrationRequestResponseDTO> approvalDTOList) {
		this.approvalDTOList = approvalDTOList;
	}

}
