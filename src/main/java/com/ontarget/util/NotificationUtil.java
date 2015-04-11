package com.ontarget.util;

import java.util.List;

import com.ontarget.bean.Notification;
import com.ontarget.entities.UserNotificationAttribute;

public class NotificationUtil {

	public static void setNotificationAttributes(Notification notification,
			List<UserNotificationAttribute> userNotificationAttributes) {
		for (UserNotificationAttribute userNotificationAttribute : userNotificationAttributes) {
			if (userNotificationAttribute.getAttributeKey().equalsIgnoreCase("notificationType")) {
				notification.setNotificationType(userNotificationAttribute.getAttributeValue());
			} else if (userNotificationAttribute.getAttributeKey().equalsIgnoreCase("notificationId")) {
				notification.setNotificationId(Integer.parseInt(userNotificationAttribute.getAttributeValue()));
			}
		}

	}

}
