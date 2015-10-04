package com.ontarget.api.notification.message;

import java.util.Map;

import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;

public class TaskPercentageChangeNotificationMessage extends NotificationMessageComposer {
	private User user;
	private ProjectTask projectTask;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		projectTask = notificationMessageDAO.getProjectTaskById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.taskId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new NotificationMessage();
		String messageTemplate = notificationTemplateConfig.getTaskPercentageChangeTemplate();
		messageTemplate = messageTemplate.replace(NotificationConstant.NotificationMessageTemplateKeyConstant.user,
				user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName()).replace(
				NotificationConstant.NotificationMessageTemplateKeyConstant.taskTitle, projectTask.getTitle());
		notificationMessage.setMessage(messageTemplate);
	}
}
