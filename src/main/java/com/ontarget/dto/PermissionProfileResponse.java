package com.ontarget.dto;

import com.ontarget.bean.ProfilePermissionDTO;

public class PermissionProfileResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private ProfilePermissionDTO permissionProfile;

	public ProfilePermissionDTO getPermissionProfile() {
		return permissionProfile;
	}

	public void setPermissionProfile(ProfilePermissionDTO permissionProfile) {
		this.permissionProfile = permissionProfile;
	}

}
