package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.PermissionProfileDTO;

public class PermissionProfileListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<PermissionProfileDTO> permissionProfileList;

	public List<PermissionProfileDTO> getPermissionProfileList() {
		return permissionProfileList;
	}

	public void setPermissionProfileList(List<PermissionProfileDTO> permissionProfileList) {
		this.permissionProfileList = permissionProfileList;
	}

}
