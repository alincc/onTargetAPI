package com.ontarget.api.notification.message.composer;

import java.text.MessageFormat;
import java.util.Map;

import com.ontarget.entities.User;
import com.ontarget.util.NotificationConstant;

public class DocumentResponseUpdateMessage extends MessageComposer {
	private User user;

	@Override
	public void fetchData(Map<String, String> notificationKeyValueMap) {
		user = notificationMessageDAO.getUserById(Integer.parseInt(notificationKeyValueMap
				.get(NotificationConstant.NotificationKeyConstant.userId)));
	}

	@Override
	public void composeMessage() {
		notificationMessage = new Message();
		String messageTemplate = notificationTemplateConfig.getOnFileRFICloseTemplate();
		messageTemplate = MessageFormat.format(messageTemplate, user.getContactList().get(0).getFirstName() + " "
				+ user.getContactList().get(0).getLastName());
		notificationMessage.setMessage(messageTemplate);
	}
}
