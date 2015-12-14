package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;
import com.ontarget.enums.TaskStatusEnum;

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
		messageTemplate = MessageFormat.format(messageTemplate, user.getContactList().get(0).getFirstName() + " "
				+ user.getContactList().get(0).getLastName(), taskStatus);
		notificationMessage.setMessage(messageTemplate);
	}
}
