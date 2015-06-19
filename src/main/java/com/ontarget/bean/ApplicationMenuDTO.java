package com.ontarget.bean;

import java.io.Serializable;

public class ApplicationMenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer applicationMenuId;
	private String menuName;
	private String menuKey;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ApplicationMenuDTO{");
		sb.append("applicationMenuId= " + applicationMenuId);
		sb.append(", menuName= " + menuName);
		sb.append(", menuKey= " + menuKey);
		sb.append("}");
		return sb.toString();
	}
}
