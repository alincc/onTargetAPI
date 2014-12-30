package com.ontarget.api.dao;

import com.ontarget.bean.Notification;

import java.util.List;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationDAO {
    List<Notification> getNotificationSince(long recentId, int userId) throws Exception;
}
