package com.ontarget.enums;

public enum TagType {
	TAG, MARKUP;

	TagType() {
	}

	public static String getType(String type) {
		for (TagType e : TagType.values()) {
			if (type.equalsIgnoreCase(e.name()))
				return e.name();
		}
		return null;
	}
}
