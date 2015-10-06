package com.ontarget.api.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.NotificationDAO;
import com.ontarget.api.dao.NotificationMessageDAO;
import com.ontarget.api.notification.message.composer.Message;
import com.ontarget.api.notification.message.composer.MessageComposer;
import com.ontarget.api.notification.message.composer.MessageFactory;
import com.ontarget.api.notification.message.composer.MessageTemplateConfig;
import com.ontarget.dto.UserNotificationDTO;
import com.ontarget.entities.Notification;
import com.ontarget.entities.NotificationAttribute;
import com.ontarget.entities.UserNotification;
import com.ontarget.util.NotificationUtil;

/**
 * Created by sumit on 12/26/14.
 */
@Service
public class NotificationServiceImpl implements com.ontarget.api.service.NotificationService {
	private static Logger logger = Logger.getLogger(NotificationServiceImpl.class);
	@Autowired
	@Qualifier("notificationJpaDAOImpl")
	private NotificationDAO notificationDAO;
	@Autowired
	private NotificationMessageDAO notificationMessageDAO;
	@Autowired
	private MessageTemplateConfig notificationTemplateConfig;

	@Override
	public UserNotificationDTO getNotifications(int pageNumber, int perPageLimit, int userId) throws Exception {
		Page<UserNotification> userNotifications = notificationDAO.getUserNotifications(pageNumber, perPageLimit, userId);

		Long previousNotificationId = null;
		String formattedMessage = "";

		UserNotificationDTO userNotificationDTO = new UserNotificationDTO();
		List<com.ontarget.bean.Notification> notifications = new LinkedList<>();

		if (userNotifications != null && userNotifications.getTotalPages() > 0) {
			for (UserNotification userNotification : userNotifications) {
				Notification notification = userNotification.getNotification();

				boolean fetch = toFetch(previousNotificationId, notification.getNotificationId());

				if (fetch) {
					List<NotificationAttribute> notificationAttributes = notification.getNotificationAttributeList();

					MessageComposer messageComposer = MessageFactory.getMessageComposer(NotificationUtil.getActivityType(
							notification.getNotificationType(), notification.getAction()));
					if (messageComposer != null) {
						Message notificationMessage = messageComposer.getMessage(
								NotificationUtil.getNotificationKeyValueMap(notificationAttributes), notificationMessageDAO,
								notificationTemplateConfig);
						formattedMessage = notificationMessage.getMessage();
					} else {
						continue;
					}
				}

				com.ontarget.bean.Notification notificationObj = new com.ontarget.bean.Notification();
				notificationObj.setUserNotificationId(userNotification.getUserNotificationId());
				notificationObj.setTsInsert(notification.getTsInsert().getTime());
				notificationObj.setText(formattedMessage);
				notificationObj.setUserId(userNotification.getUser().getUserId());
				notificationObj.setStatus(userNotification.getStatus());
				notificationObj.setLastSeenAt(userNotification.getLastSeenAt());
				notificationObj.setNotificationType(notification.getNotificationType());
				notificationObj.setAction(notification.getAction());

				List<NotificationAttribute> notificationAttributes = notification.getNotificationAttributeList();
				NotificationUtil.setNotificationAttributes(notificationObj, notificationAttributes);
				notifications.add(notificationObj);

				previousNotificationId = notification.getNotificationId();
			}
		}
		userNotificationDTO.setTotalNotification(userNotifications.getTotalElements());
		userNotificationDTO.setUserNotificationList(notifications);
		return userNotificationDTO;
	}

	private boolean toFetch(Long previousNotificationId, Long currentNotificationId) {
		boolean fetch = true;

		if (previousNotificationId == null) {
			previousNotificationId = currentNotificationId;
		} else {
			if (previousNotificationId.equals(currentNotificationId)) {
				fetch = false;
			}
		}
		return fetch;
	}

	@Override
	public boolean updateStatusToSeen(Long userNotificationId) throws Exception {
		return notificationDAO.updateStatusToSeen(userNotificationId);
	}

	@Override
	public UserNotificationDTO getNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId)
			throws Exception {

		Page<UserNotification> userNotifications = notificationDAO.getUserNotifications(pageNumber, perPageLimit, userId,
				loggedInUserProjectId);

		Long previousNotificationId = null;
		String formattedMessage = "";

		UserNotificationDTO userNotificationDTO = new UserNotificationDTO();
		List<com.ontarget.bean.Notification> notifications = new LinkedList<>();

		if (userNotifications != null && userNotifications.getTotalPages() > 0) {
			for (UserNotification userNotification : userNotifications) {
				Notification notification = userNotification.getNotification();

				boolean fetch = toFetch(previousNotificationId, notification.getNotificationId());

				if (fetch) {
					List<NotificationAttribute> notificationAttributes = notification.getNotificationAttributeList();

					MessageComposer messageComposer = MessageFactory.getMessageComposer(NotificationUtil.getActivityType(
							notification.getNotificationType(), notification.getAction()));
					if (messageComposer != null) {
						Message notificationMessage = messageComposer.getMessage(
								NotificationUtil.getNotificationKeyValueMap(notificationAttributes), notificationMessageDAO,
								notificationTemplateConfig);
						formattedMessage = notificationMessage.getMessage();
					} else {
						continue;
					}
				}

				com.ontarget.bean.Notification notificationObj = new com.ontarget.bean.Notification();
				notificationObj.setUserNotificationId(userNotification.getUserNotificationId());
				notificationObj.setTsInsert(notification.getTsInsert().getTime());
				notificationObj.setText(formattedMessage);
				notificationObj.setUserId(userNotification.getUser().getUserId());
				notificationObj.setStatus(userNotification.getStatus());
				notificationObj.setLastSeenAt(userNotification.getLastSeenAt());
				notificationObj.setNotificationType(notification.getNotificationType());
				notificationObj.setAction(notification.getAction());

				List<NotificationAttribute> notificationAttributes = notification.getNotificationAttributeList();
				NotificationUtil.setNotificationAttributes(notificationObj, notificationAttributes);
				notifications.add(notificationObj);

				previousNotificationId = notification.getNotificationId();
			}
		}
		userNotificationDTO.setTotalNotification(userNotifications.getTotalElements());
		userNotificationDTO.setUserNotificationList(notifications);
		return userNotificationDTO;

	}

}
