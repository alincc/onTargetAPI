package com.ontarget.api.notification.message.composer;

import java.util.Map;

import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;
import com.ontarget.util.TaskStatusEnum;

public class TaskStatusMessage extends MessageComposer {
	private User user;
	private String taskStatus;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		taskStatus = TaskStatusEnum.getStatusTextByStatus(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.status)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getTaskStatusChangeTemplate();
		messageTemplate = messageTemplate.replace(NotificationConstant.NotificationMessageTemplateKeyConstant.user,
				user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName()).replace(
				NotificationConstant.NotificationMessageTemplateKeyConstant.taskStatus, taskStatus);
		notificationMessage.setMessage(messageTemplate);
	}
}
