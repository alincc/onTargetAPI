package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.ProfilePermissionDTO;

public class PermissionProfileListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<ProfilePermissionDTO> permissionProfileList;

	public List<ProfilePermissionDTO> getPermissionProfileList() {
		return permissionProfileList;
	}

	public void setPermissionProfileList(List<ProfilePermissionDTO> permissionProfileList) {
		this.permissionProfileList = permissionProfileList;
	}

}
