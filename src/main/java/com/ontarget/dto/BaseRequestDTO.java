package com.ontarget.dto;

import com.ontarget.bean.UserDTO;

public class BaseRequestDTO {

	private UserDTO user;
	private int parentProjectId;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public int getParentProjectId() {
		return parentProjectId;
	}

	public void setParentProjectId(int parentProjectId) {
		this.parentProjectId = parentProjectId;
	}

}