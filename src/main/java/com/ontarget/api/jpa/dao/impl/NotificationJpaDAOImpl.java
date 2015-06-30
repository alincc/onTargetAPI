package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.NotificationDAO;
import com.ontarget.api.repository.UserNotificationRepository;
import com.ontarget.bean.Notification;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UserNotificationDTO;
import com.ontarget.entities.UserNotification;
import com.ontarget.entities.UserNotificationAttribute;
import com.ontarget.util.NotificationUtil;

@Repository("notificationJpaDAOImpl")
public class NotificationJpaDAOImpl implements NotificationDAO {
	@Resource
	private UserNotificationRepository userNotificationRepository;

	@Override
	public UserNotificationDTO getUserNotifications(int pageNumber, int perPageLimit, int userId) throws Exception {
		Pageable pageable = new PageRequest(pageNumber - 1, perPageLimit);
		Page<UserNotification> userNotifications = userNotificationRepository.findNotifcationByUserId(userId, pageable);

		UserNotificationDTO userNotificationDTO = new UserNotificationDTO();
		List<Notification> notifications = new LinkedList<>();

		if (userNotifications != null && userNotifications.getTotalPages() > 0) {
			for (UserNotification userNotification : userNotifications) {
				Notification notification = new Notification();
				notification.setId(userNotification.getId());
				notification.setTsInsert(userNotification.getTsInsert().getTime());
				notification.setText(userNotification.getText());
				notification.setUserId(userNotification.getUser().getUserId());
				notification.setStatus(userNotification.getStatus());
				notification.setLastSeenAt(userNotification.getLastSeenAt());
				notification.setNotificationType(userNotification.getNotificationType());

				List<UserNotificationAttribute> notificationAttributes = userNotification.getUserNotificationAttributeList();
				NotificationUtil.setNotificationAttributes(notification, notificationAttributes);
				notifications.add(notification);
			}
		}
		userNotificationDTO.setTotalNotification(userNotifications.getTotalElements());
		userNotificationDTO.setUserNotificationList(notifications);
		return userNotificationDTO;
	}

	@Override
	public boolean updateStatusToSeen(Long userNotificationId) throws Exception {
		UserNotification userNotification = userNotificationRepository.findById(userNotificationId);
		userNotification.setStatus(OnTargetConstant.UserNotificationStatus.SEEN);
		userNotification.setLastSeenAt(new Date());
		userNotificationRepository.save(userNotification);
		return true;
	}

}
