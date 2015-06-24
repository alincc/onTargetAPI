package com.ontarget.dto;

import java.io.Serializable;

import com.ontarget.bean.UserLoginInfo;

/**
 * Created by Owner on 10/29/14.
 */
public class UserLoginResponse extends OnTargetResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private UserLoginInfo user;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserLoginInfo getUser() {
		return user;
	}

	public void setUser(UserLoginInfo user) {
		this.user = user;
	}
}
