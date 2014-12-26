package com.ontarget.api.service;

import com.ontarget.bean.Notification;

import java.util.List;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationService {
    List<Notification> getNotifications(long recentId) throws Exception;
}
