package com.ontarget.api.notification.message;

import org.apache.log4j.Logger;

import com.ontarget.util.NotificationConstant;

public class NotificationMessageFactory {
	private static Logger logger = Logger.getLogger(NotificationMessageFactory.class);

	public static NotificationMessageComposer getNotificationComposer(String notificationType) {
		if (notificationType == null) {
			return null;
		}

		logger.debug("notification type: " + notificationType);

		NotificationMessageComposer notificationMessageComposer = null;
		if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskStatusUpdate)) {
			notificationMessageComposer = new TaskStatusNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskAssignCreate)) {
			notificationMessageComposer = new TaskAssignNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskCommentCreate)) {
			notificationMessageComposer = new TaskCommentNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskAttachmentCreate)) {
			notificationMessageComposer = new TaskAttachmentNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskCreate)) {
			notificationMessageComposer = new TaskCreateNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskUpdate)) {
			notificationMessageComposer = new TaskUpdateNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectCreate)) {
			notificationMessageComposer = new ProjectCreateNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectUpdate)) {
			notificationMessageComposer = new ProjectUpdateNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.activityCreate)) {
			notificationMessageComposer = new ActivityCreateNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.activityUpdate)) {
			notificationMessageComposer = new ActivityUpdateNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectFileCraete)) {
			notificationMessageComposer = new DocumentUploadNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.projectFileCommentCreate)) {
			notificationMessageComposer = new DocumentUploadCommentNotificationMessage();
		} else if (notificationType.equalsIgnoreCase(NotificationConstant.NotificationTypeConstant.taskPercentageChangeUpdate)) {
			notificationMessageComposer = new TaskPercentageChangeNotificationMessage();
		}
		logger.debug("composer: " + notificationMessageComposer);
		return notificationMessageComposer;
	}
}
