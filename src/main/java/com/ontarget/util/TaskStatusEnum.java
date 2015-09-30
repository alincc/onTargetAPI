package com.ontarget.util;

public enum TaskStatusEnum {
	Active(1), Pending(2), Completed(3), Deleted(4);

	public final int value;

	TaskStatusEnum(final int value) {
		this.value = value;
	}

	public static String getStatusTextByStatus(int status) {
		for (TaskStatusEnum e : TaskStatusEnum.values()) {
			if (status == e.value)
				return e.name();
		}
		return null;
	}
}
