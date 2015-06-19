package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.ApplicationMenuDTO;

public class MenuListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<ApplicationMenuDTO> menuList;

	public List<ApplicationMenuDTO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<ApplicationMenuDTO> menuList) {
		this.menuList = menuList;
	}

}
