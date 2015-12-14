package com.ontarget.enums;

public enum UserType {
	SUPERUSER("SU",1),PROJECTMANAGER("PM",2), REGULARUSER("RU",3);

	private String code;
    private int profileId;

	private UserType(String s, int profileId) {
		this.code = s;
        this.profileId=profileId;
	}

	public String getCode() {
		return code;
	}

    public int getProfileId() {
        return profileId;
    }

}
