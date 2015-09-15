package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.Notification;

/**
 * Created by sumit on 12/26/14.
 */
public class NotificationResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	List<Notification> notificationList;
	private long totalNotification;
    private long totalUnreadNotification;

    public long getTotalUnreadNotification() {
        return totalUnreadNotification;
    }

    public void setTotalUnreadNotification(long totalUnreadNotification) {
        this.totalUnreadNotification = totalUnreadNotification;
    }

    public List<Notification> getNotificationList() {
		return notificationList;
	}

	public void setNotificationList(List<Notification> notificationList) {
		this.notificationList = notificationList;
	}

	public long getTotalNotification() {
		return totalNotification;
	}

	public void setTotalNotification(long totalNotification) {
		this.totalNotification = totalNotification;
	}

}
