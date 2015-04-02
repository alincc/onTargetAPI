package com.ontarget.dto;

import java.util.List;

/**
 * Created by Owner on 11/3/14.
 */
public class UserRegistationApprovalResponse extends OnTargetResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<RegistrationRequestDTO> userRegistrationRequestList;

	public List<RegistrationRequestDTO> getUserRegistrationRequestList() {
		return userRegistrationRequestList;
	}

	public void setUserRegistrationRequestList(
			List<RegistrationRequestDTO> userRegistrationRequestList) {
		this.userRegistrationRequestList = userRegistrationRequestList;
	}

}
