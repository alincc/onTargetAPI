package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.User;
import com.ontarget.util.FileUtils;
import com.ontarget.util.NotificationConstant;

public class DocumentUploadMessage extends MessageComposer {
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
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getDocumentUploadTemplate();
		messageTemplate= MessageFormat.format(messageTemplate, user.getContactList().get(0).getFirstName() + " " + user.getContactList().get(0).getLastName(), FileUtils.getFileNameFromPath(projectFile.getFileName()));
		notificationMessage.setMessage(messageTemplate);
	}

}
