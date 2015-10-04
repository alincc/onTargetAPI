package com.ontarget.api.notification.message;

import java.util.Map;

import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.User;
import com.ontarget.util.FileUtils;
import com.ontarget.util.NotificationConstant;

public class DocumentUploadCommentNotificationMessage extends NotificationMessageComposer {
	private User user;
	private ProjectFile projectFile;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		projectFile = notificationMessageDAO.findProjectFileById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.projectFileId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new NotificationMessage();
		String messageTemplate = notificationTemplateConfig.getDocumentCommentTemplate();
		messageTemplate = messageTemplate.replace(NotificationConstant.NotificationMessageTemplateKeyConstant.user,
				user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName()).replace(
				NotificationConstant.NotificationMessageTemplateKeyConstant.documentName,
				FileUtils.getFileNameFromPath(projectFile.getFileName()));
		notificationMessage.setMessage(messageTemplate);
	}

}
