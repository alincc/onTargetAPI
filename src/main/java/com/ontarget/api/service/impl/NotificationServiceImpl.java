package com.ontarget.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.NotificationDAO;
import com.ontarget.bean.Notification;

/**
 * Created by sumit on 12/26/14.
 */
@Service
public class NotificationServiceImpl implements com.ontarget.api.service.NotificationService {
	@Autowired
	@Qualifier("notificationJpaDAOImpl")
	private NotificationDAO notificationDAO;

	@Override
	public List<Notification> getNotifications(long recentId, int userId) throws Exception {
		return notificationDAO.getNotificationSince(recentId, userId);
	}
}
