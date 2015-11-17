package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.Document;
import com.ontarget.entities.User;
import com.ontarget.enums.DocumentStatusEnum;
import com.ontarget.util.NotificationConstant;

public class OnFileStatusChangeMessage extends MessageComposer {
	private User user;
	private Document document;
	private String documentStatus;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		document = notificationMessageDAO.findDocumentById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.documentId)));
		documentStatus = DocumentStatusEnum.getStatusTextByStatus(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.status));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getOnFileStatusChangeTemplate();
		messageTemplate = MessageFormat.format(messageTemplate, user.getContactList().get(0).getFirstName() + " "
				+ user.getContactList().get(0).getLastName(), document.getDocumentTemplate().getName(), documentStatus);
		notificationMessage.setMessage(messageTemplate);
	}
}
