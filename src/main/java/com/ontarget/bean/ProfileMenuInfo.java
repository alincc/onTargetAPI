package com.ontarget.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProfileMenuInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String menuName;
	private String menuKey;
}
