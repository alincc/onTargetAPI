package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.Project;
import com.ontarget.entities.User;
import com.ontarget.util.FileUtils;
import com.ontarget.util.NotificationConstant;

public class ActivityUpdateMessage extends MessageComposer {
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
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getActivityUpdateTemplate();
        messageTemplate= MessageFormat.format(messageTemplate, user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName(), project.getProjectName());
		notificationMessage.setMessage(messageTemplate);
	}
}
