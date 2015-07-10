package com.ontarget.bean;

import java.io.Serializable;

public class UserLoginInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
