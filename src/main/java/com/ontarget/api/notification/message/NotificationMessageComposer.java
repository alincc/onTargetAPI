package com.ontarget.api.notification.message;

import java.util.Map;

import com.ontarget.api.dao.NotificationMessageDAO;

public abstract class NotificationMessageComposer {
	protected NotificationMessage notificationMessage;
	protected NotificationMessageDAO notificationMessageDAO;
	protected NotificationTemplateConfig notificationTemplateConfig;

	public NotificationMessage getMessage(Map<String, String> notificationKeyValueMap, NotificationMessageDAO notificationMessageDAO,
			NotificationTemplateConfig notificationTemplateConfig) {

		this.notificationMessageDAO = notificationMessageDAO;
		this.notificationTemplateConfig = notificationTemplateConfig;

		fetchData(notificationKeyValueMap);
		composeMessage();

		return notificationMessage;
	}

	public abstract void fetchData(Map<String, String> notificationKeyValueMap);

	public abstract void composeMessage();

}
