package com.ontarget.dto;

import com.ontarget.bean.PermissionProfileDTO;

public class PermissionProfileResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private PermissionProfileDTO permissionProfile;

	public PermissionProfileDTO getPermissionProfile() {
		return permissionProfile;
	}

	public void setPermissionProfile(PermissionProfileDTO permissionProfile) {
		this.permissionProfile = permissionProfile;
	}

}
