package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.MenuProfileDTO;

public class MenuProfileListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<MenuProfileDTO> menuProfileList;

	public List<MenuProfileDTO> getMenuProfileList() {
		return menuProfileList;
	}

	public void setMenuProfileList(List<MenuProfileDTO> menuProfileList) {
		this.menuProfileList = menuProfileList;
	}
}
