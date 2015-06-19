package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.ApplicationPermissionDTO;

public class PermissionListReponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<ApplicationPermissionDTO> permissionList;

	public List<ApplicationPermissionDTO> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<ApplicationPermissionDTO> permissionList) {
		this.permissionList = permissionList;
	}

}
