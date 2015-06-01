package com.ontarget.util;

public class StringUtility {
	public static boolean isEmpty(String data) {
		return (data == null || data.trim().length() == 0) ? true : false;
	}
}
