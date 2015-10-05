package com.ontarget.api.notification.message;

import java.util.Map;

import com.ontarget.entities.Project;
import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;
import com.ontarget.util.NotificationUtil;

public class ActivityUpdateNotificationMessage extends NotificationMessageComposer {
	private User user;
	private Project project;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		project = notificationMessageDAO.findProjectById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.activityId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new NotificationMessage();
		String messageTemplate = notificationTemplateConfig.getActivityUpdateTemplate();
		messageTemplate = messageTemplate.replace(NotificationConstant.NotificationMessageTemplateKeyConstant.user,
				user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName()).replace(
				NotificationConstant.NotificationMessageTemplateKeyConstant.activityTitle, project.getProjectName());
		notificationMessage.setMessage(messageTemplate);
	}
}
