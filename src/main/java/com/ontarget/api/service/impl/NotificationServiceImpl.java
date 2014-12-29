package com.ontarget.api.service.impl;

import com.ontarget.api.dao.NotificationDAO;
import com.ontarget.bean.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sumit on 12/26/14.
 */
@Service
public class NotificationServiceImpl implements com.ontarget.api.service.NotificationService {
    @Autowired
    private NotificationDAO notificationDAO;

    @Override
    public List<Notification> getNotifications(long recentId, int userId) throws Exception {
        return notificationDAO.getNotificationSince(recentId, userId);
    }
}
