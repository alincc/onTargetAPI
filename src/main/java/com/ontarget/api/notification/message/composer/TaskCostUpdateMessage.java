package com.ontarget.api.notification.message.composer;

import java.util.Map;

import com.ontarget.entities.ProjectTask;
import com.ontarget.util.NotificationConstant;

public class TaskCostUpdateMessage extends MessageComposer {
	private ProjectTask projectTask;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		projectTask = notificationMessageDAO.getProjectTaskById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.taskId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getTaskCreateTemplate();
		messageTemplate = messageTemplate.replace(NotificationConstant.NotificationMessageTemplateKeyConstant.taskTitle,
				projectTask.getTitle());
		notificationMessage.setMessage(messageTemplate);
	}
}
