package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PermissionProfileDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer permissionProfileId;
	private String profileName;
	private String profileDescription;
	private String active;
	private Date addedDate;
	private String addedBy;
	private List<ProfileAssignedPermissionDTO> profileAssignedPermissionList;

	public Integer getPermissionProfileId() {
		return permissionProfileId;
	}

	public void setPermissionProfileId(Integer permissionProfileId) {
		this.permissionProfileId = permissionProfileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public List<ProfileAssignedPermissionDTO> getProfileAssignedPermissionList() {
		return profileAssignedPermissionList;
	}

	public void setProfileAssignedPermissionList(List<ProfileAssignedPermissionDTO> profileAssignedPermissionList) {
		this.profileAssignedPermissionList = profileAssignedPermissionList;
	}

}
