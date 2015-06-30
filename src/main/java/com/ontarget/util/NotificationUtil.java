package com.ontarget.util;

import java.util.ArrayList;
import java.util.List;

import com.ontarget.bean.Notification;
import com.ontarget.bean.NotificationAttribute;
import com.ontarget.entities.UserNotificationAttribute;

public class NotificationUtil {

	public static void setNotificationAttributes(Notification notification, List<UserNotificationAttribute> userNotificationAttributes) {
		List<NotificationAttribute> notificationAttributes = new ArrayList<NotificationAttribute>();

		String key = "";
		String value = "";
		int i = 0;
		for (UserNotificationAttribute userNotificationAttribute : userNotificationAttributes) {
			i++;
			if (userNotificationAttribute.getAttributeKey().equalsIgnoreCase("notificationType")) {
				key = userNotificationAttribute.getAttributeValue();
			} else if (userNotificationAttribute.getAttributeKey().equalsIgnoreCase("notificationId")) {
				value = userNotificationAttribute.getAttributeValue();
			}
			if (i % 2 == 0) {
				NotificationAttribute attribute = new NotificationAttribute();
				attribute.setKey(key);
				attribute.setValue(value);
				notificationAttributes.add(attribute);
			}
		}
		notification.setNotificationAttributes(notificationAttributes);

	}

}
