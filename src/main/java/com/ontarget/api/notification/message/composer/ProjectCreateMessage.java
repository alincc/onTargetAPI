package com.ontarget.api.notification.message.composer;

import java.util.Map;

import com.ontarget.entities.Project;
import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;

public class ProjectCreateMessage extends MessageComposer {
	private User user;
	private Project project;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		project = notificationMessageDAO.findProjectById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.projectId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getProjectCreateTemplate();
		messageTemplate = messageTemplate.replace(NotificationConstant.NotificationMessageTemplateKeyConstant.user,
				user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName()).replace(
				NotificationConstant.NotificationMessageTemplateKeyConstant.projectTitle, project.getProjectName());
		notificationMessage.setMessage(messageTemplate);
	}
}
