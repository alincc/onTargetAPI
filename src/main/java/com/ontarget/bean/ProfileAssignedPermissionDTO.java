package com.ontarget.bean;

import java.io.Serializable;

public class ProfileAssignedPermissionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer applicationPermissionId;
	private String permissionName;
	private String permissionKey;
	private Integer profilePermissionId;
	private String active;

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

	public Integer getProfilePermissionId() {
		return profilePermissionId;
	}

	public void setProfilePermissionId(Integer profilePermissionId) {
		this.profilePermissionId = profilePermissionId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
