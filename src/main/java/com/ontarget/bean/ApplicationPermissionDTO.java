package com.ontarget.bean;

import java.io.Serializable;

public class ApplicationPermissionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer applicationPermissionId;
	private String permissionName;
	private String permissionKey;

	public Integer getApplicationPermissionId() {
		return applicationPermissionId;
	}

	public void setApplicationPermissionId(Integer applicationPermissionId) {
		this.applicationPermissionId = applicationPermissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionKey() {
		return permissionKey;
	}

	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
	}

}
