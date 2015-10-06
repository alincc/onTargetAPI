package com.ontarget.api.notification.message.composer;

import java.util.Map;

import com.ontarget.api.dao.NotificationMessageDAO;

public abstract class MessageComposer {
	protected Message notificationMessage;
	protected NotificationMessageDAO notificationMessageDAO;
	protected MessageTemplateConfig notificationTemplateConfig;

	public Message getMessage(Map<String, String> notificationKeyValueMap, NotificationMessageDAO notificationMessageDAO,
			MessageTemplateConfig notificationTemplateConfig) {

		this.notificationMessageDAO = notificationMessageDAO;
		this.notificationTemplateConfig = notificationTemplateConfig;

		fetchData(notificationKeyValueMap);
		composeMessage();

		return notificationMessage;
	}

	public abstract void fetchData(Map<String, String> notificationKeyValueMap);

	public abstract void composeMessage();

}
