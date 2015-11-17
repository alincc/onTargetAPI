package com.ontarget.enums;

public enum DocumentStatusEnum {
	Submitted("SUBMITTED"), Approved("APPROVED"), Rejected("REJECTED");

	public final String value;

	DocumentStatusEnum(final String value) {
		this.value = value;
	}

	public static String getStatusTextByStatus(String status) {
		for (DocumentStatusEnum e : DocumentStatusEnum.values()) {
			if (status.equalsIgnoreCase(e.value))
				return e.name();
		}
		return null;
	}
}
