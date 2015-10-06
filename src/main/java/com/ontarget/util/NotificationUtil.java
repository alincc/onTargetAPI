package com.ontarget.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ontarget.bean.Notification;
import com.ontarget.bean.NotificationAttribute;

public class NotificationUtil {

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

	public static String getActivityType(String type, String action) {
		StringBuilder sb = new StringBuilder(type).append("_").append(action);
		return sb.toString();
	}

	public static Map<String, String> getNotificationKeyValueMap(List<com.ontarget.entities.NotificationAttribute> notificationAttributes) {
		Map<String, String> keyValueMap = new HashMap<String, String>();
		for (com.ontarget.entities.NotificationAttribute notificationAttribute : notificationAttributes) {
			keyValueMap.put(notificationAttribute.getAttributeKey(), notificationAttribute.getAttributeValue());
		}
		return keyValueMap;
	}

	public static Map<String, String> getActivityKeyValueMap(List<com.ontarget.entities.ActivityLogAttribute> activityLogAttributes) {
		Map<String, String> keyValueMap = new HashMap<String, String>();
		for (com.ontarget.entities.ActivityLogAttribute activityLogAttribute : activityLogAttributes) {
			keyValueMap.put(activityLogAttribute.getAttributeKey(), activityLogAttribute.getAttributeValue());
		}
		return keyValueMap;
	}
}
