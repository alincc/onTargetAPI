package com.ontarget.api.notification.message.composer;

import org.apache.log4j.Logger;

import com.ontarget.util.NotificationConstant;

public class MessageFactory {
	private static Logger logger = Logger.getLogger(MessageFactory.class);

	/**
	 * @param notificationType
	 * @return
	 */
	public static MessageComposer getMessageComposer(String notificationType) {
		if (notificationType == null) {
			return null;
		}

		logger.debug("notification type: " + notificationType);

		MessageComposer notificationMessageComposer = null;
		if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskStatusUpdate)) {
			notificationMessageComposer = new TaskStatusMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskAssignCreate)) {
			notificationMessageComposer = new TaskAssignMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskCommentCreate)) {
			notificationMessageComposer = new TaskCommentMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskAttachmentCreate)) {
			notificationMessageComposer = new TaskAttachmentMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskCreate)) {
			notificationMessageComposer = new TaskCreateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskUpdate)) {
			notificationMessageComposer = new TaskUpdateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectCreate)) {
			notificationMessageComposer = new ProjectCreateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectUpdate)) {
			notificationMessageComposer = new ProjectUpdateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.activityCreate)) {
			notificationMessageComposer = new ActivityCreateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.activityUpdate)) {
			notificationMessageComposer = new ActivityUpdateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectFileCraete)) {
			notificationMessageComposer = new DocumentUploadMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectFileCommentCreate)) {
			notificationMessageComposer = new DocumentUploadCommentMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskPercentageChangeUpdate)) {
			notificationMessageComposer = new TaskPercentageChangeMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskCostCreate)) {
			notificationMessageComposer = new TaskCostCreateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskCostUpdate)) {
			notificationMessageComposer = new TaskCostUpdateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.documentCreate)) {
			notificationMessageComposer = new OnFileSubmittalMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.documentStatusUpdate)) {
			notificationMessageComposer = new OnFileStatusChangeMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.documentResponseCreate)) {
			notificationMessageComposer = new DocumentResponseCreateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.documentResponseUpdate)) {
			notificationMessageComposer = new DocumentResponseUpdateMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.documentSubmittalAssignCreate)) {
			notificationMessageComposer = new DocumentSubmittalAssignMessage();
		}
		logger.debug("composer: " + notificationMessageComposer);
		return notificationMessageComposer;
	}
}
