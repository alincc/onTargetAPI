package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.Document;
import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;

public class DocumentSubmittalAssignMessage extends MessageComposer {

	private User user;
	private Document document;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
		document = notificationMessageDAO.findDocumentById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.documentId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getOnFileSubmittalAssignTemplate();
		messageTemplate = MessageFormat.format(messageTemplate, user.getContactList().get(0).getFirstName() + " "
				+ user.getContactList().get(0).getLastName(), document.getDocumentTemplate().getName());
		notificationMessage.setMessage(messageTemplate);
	}
}
