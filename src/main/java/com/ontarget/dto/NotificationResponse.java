package com.ontarget.dto;

import com.ontarget.bean.Notification;

import java.util.List;

/**
 * Created by sumit on 12/26/14.
 */
public class NotificationResponse extends OnTargetResponse {
    List<Notification> notificationList;
    private long recentNotificationId;

    public List<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    public long getRecentNotificationId() {
        return recentNotificationId;
    }

    public void setRecentNotificationId(long recentNotificationId) {
        this.recentNotificationId = recentNotificationId;
    }
}
