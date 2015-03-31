package com.ontarget.api.jpa.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.NotificationDAO;
import com.ontarget.api.repository.UserNotificationRepository;
import com.ontarget.bean.Notification;
import com.ontarget.entities.UserNotification;

@Repository("notificationJpaDAOImpl")
public class NotificationJpaDAOImpl implements NotificationDAO {
	@Resource
	private UserNotificationRepository userNotificationRepository;

	@Override
	public List<Notification> getNotificationSince(long recentId, int userId) throws Exception {

		List<Notification> notifications = new LinkedList<>();
		List<UserNotification> userNotifications = userNotificationRepository.findByUserIdAndIdGreater(userId, recentId);
		if (userNotifications != null && !userNotifications.isEmpty()) {
			for (UserNotification userNotification : userNotifications) {
				Notification notification = new Notification();
				notification.setCategory(userNotification.getCategory().longValue());
				notification.setId(userNotification.getId());
				notification.setTsInsert(userNotification.getTsInsert().getTime());
				notification.setText(userNotification.getText());
				notification.setUserId(userNotification.getUserId());
				notifications.add(notification);
			}
		}
		return notifications;
	}

}
