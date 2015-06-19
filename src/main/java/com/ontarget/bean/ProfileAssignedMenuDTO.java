package com.ontarget.bean;

import java.io.Serializable;

public class ProfileAssignedMenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer applicationMenuId;
	private String menuName;
	private String menuKey;
	private Integer profileMenuId;
	private String active;

	public Integer getApplicationMenuId() {
		return applicationMenuId;
	}

	public void setApplicationMenuId(Integer applicationMenuId) {
		this.applicationMenuId = applicationMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuKey() {
		return menuKey;
	}

	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}

	public Integer getProfileMenuId() {
		return profileMenuId;
	}

	public void setProfileMenuId(Integer profileMenuId) {
		this.profileMenuId = profileMenuId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}
}
