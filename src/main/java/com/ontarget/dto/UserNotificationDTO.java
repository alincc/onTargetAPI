package com.ontarget.dto;

import java.io.Serializable;
import java.util.List;

import com.ontarget.bean.Notification;

public class UserNotificationDTO implements Serializable {
	private long totalUnReadNotification;

    public long getTotalUnReadNotification() {
        return totalUnReadNotification;
    }

    public void setTotalUnReadNotification(long totalUnReadNotification) {
        this.totalUnReadNotification = totalUnReadNotification;
    }

    private long totalNotification;
	private List<Notification> userNotificationList;

	public long getTotalNotification() {
		return totalNotification;
	}

	public void setTotalNotification(long totalNotification) {
		this.totalNotification = totalNotification;
	}

	public List<Notification> getUserNotificationList() {
		return userNotificationList;
	}

	public void setUserNotificationList(List<Notification> userNotificationList) {
		this.userNotificationList = userNotificationList;
	}
}
