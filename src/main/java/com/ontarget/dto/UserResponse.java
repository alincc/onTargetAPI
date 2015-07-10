package com.ontarget.dto;

import java.io.Serializable;

import com.ontarget.bean.UserDTO;

/**
 * Created by Owner on 10/29/14.
 */
public class UserResponse extends OnTargetResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private UserDTO user;
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
