package com.ontarget.dto;

import com.ontarget.bean.User;

public class BaseRequest {

	private User user;
	private int parentProjectId;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getParentProjectId() {
		return parentProjectId;
	}

	public void setParentProjectId(int parentProjectId) {
		this.parentProjectId = parentProjectId;
	}

}