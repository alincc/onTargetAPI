package com.ontarget.util;

public enum UserType {
	SUPERUSER("SU"), REGULARUSER("RU");

	private String code;

	private UserType(String s) {
		code = s;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
