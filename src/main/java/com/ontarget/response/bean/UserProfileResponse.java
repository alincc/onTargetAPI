package com.ontarget.response.bean;

import com.ontarget.bean.MenuProfileDTO;
import com.ontarget.bean.PermissionProfileDTO;
import com.ontarget.dto.OnTargetResponse;


public class UserProfileResponse extends OnTargetResponse{
	private static final long serialVersionUID = 1L;
	private PermissionProfileDTO permissionProfile;
	private MenuProfileDTO menuProfile;
	public PermissionProfileDTO getPermissionProfile() {
		return permissionProfile;
	}
	public void setPermissionProfile(PermissionProfileDTO permissionProfile) {
		this.permissionProfile = permissionProfile;
	}
	public MenuProfileDTO getMenuProfile() {
		return menuProfile;
	}
	public void setMenuProfile(MenuProfileDTO menuProfile) {
		this.menuProfile = menuProfile;
	}
	
	
}
