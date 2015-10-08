package com.ontarget.dto;

import com.ontarget.bean.MenuProfileDTO;

public class MenuProfileResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private MenuProfileDTO menuProfile;

	public MenuProfileDTO getMenuProfile() {
		return menuProfile;
	}

	public void setMenuProfile(MenuProfileDTO menuProfile) {
		this.menuProfile = menuProfile;
	}

}
