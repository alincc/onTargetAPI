package com.ontarget.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ontarget.bean.Notification;
import com.ontarget.bean.NotificationAttribute;

public class NotificationUtil {

	// public static void setNotificationAttributes(Notification notification,
	// List<NotificationAttribute> userNotificationAttributes) {
	// List<NotificationAttribute> notificationAttributes = new
	// ArrayList<NotificationAttribute>();
	//
	// String key = "";
	// String value = "";
	// int i = 0;
	// for (NotificationAttribute userNotificationAttribute :
	// userNotificationAttributes) {
	// i++;
	// // if
	// //
	// (userNotificationAttribute.getAttributeKey().equalsIgnoreCase("notificationType"))
	// // {
	// // key = userNotificationAttribute.getAttributeValue();
	// // } else if
	// //
	// (userNotificationAttribute.getAttributeKey().equalsIgnoreCase("notificationId"))
	// // {
	// // value = userNotificationAttribute.getAttributeValue();
	// // }
	// // if (i % 2 == 0) {
	// // NotificationAttribute attribute = new NotificationAttribute();
	// // attribute.setKey(key);
	// // attribute.setValue(value);
	// // notificationAttributes.add(attribute);
	// // }
	// }
	// notification.setNotificationAttributes(notificationAttributes);
	//
	// }

	public static void setNotificationAttributes(Notification notification,
			List<com.ontarget.entities.NotificationAttribute> userNotificationAttributes) {
		List<NotificationAttribute> notificationAttributes = new ArrayList<NotificationAttribute>();

		for (com.ontarget.entities.NotificationAttribute userNotificationAttribute : userNotificationAttributes) {
			NotificationAttribute notificationAttribute = new NotificationAttribute();
			notificationAttribute.setKey(userNotificationAttribute.getAttributeKey());
			notificationAttribute.setValue(userNotificationAttribute.getAttributeValue());
			notificationAttributes.add(notificationAttribute);
		}
		notification.setNotificationAttributes(notificationAttributes);
	}

	public static String getNotificationKey(com.ontarget.entities.Notification notification) {
		StringBuilder sb = new StringBuilder(notification.getNotificationType()).append("_").append(notification.getAction());
		return sb.toString();
	}

	public static Map<String, String> getNotificationKeyValueMap(List<com.ontarget.entities.NotificationAttribute> notificationAttributes) {
		Map<String, String> keyValueMap = new HashMap<String, String>();
		for (com.ontarget.entities.NotificationAttribute notificationAttribute : notificationAttributes) {
			keyValueMap.put(notificationAttribute.getAttributeKey(), notificationAttribute.getAttributeValue());
		}
		return keyValueMap;
	}
}
