package com.ontarget.util;

public class NotificationConstant {

	public static interface NotificationTypeConstant {
		public static final String taskStatusUpdate = "TASK_STATUS_UPDATE";
		public static final String taskAssignCreate = "TASK_ASSIGN_CREATE";
		public static final String taskCommentCreate = "TASK_COMMENT_CREATE";
		public static final String taskAttachmentCreate = "TASK_ATTACHMENT_CREATE";
		public static final String taskCreate = "TASK_CREATE";
		public static final String taskUpdate = "TASK_UPDATE";
		public static final String projectCreate = "PROJECT_CREATE";
		public static final String projectUpdate = "PROJECT_UPDATE";
		public static final String activityCreate = "ACTIVITY_CREATE";
		public static final String activityUpdate = "ACTIVITY_UPDATE";
		public static final String projectFileCraete = "PROJECT_FILE_CREATE";
		public static final String projectFileCommentCreate = "PROJECT_FILE_COMMENT_CREATE";
		public static final String taskPercentageChangeUpdate = "TASK_PERCENTAGE_UPDATE";
		public static final String taskCostCreate = "TASK_COST_CREATE";
		public static final String taskCostUpdate = "TASK_COST_UPDATE";
		public static final String documentCreate = "DOCUMENT_CREATE";
		public static final String documentStatusUpdate = "DOCUMENT_STATUS_UPDATE";
	}

	public static interface NotificationKeyConstant {
		public static final String userId = "userId";
		public static final String taskId = "taskId";
		public static final String status = "status";
		public static final String projectId = "projectId";
		public static final String activityId = "activityId";
		public static final String projectFileId = "projectFileId";
		public static final String projectFileCommentId = "projectFileCommentId";
		public static final String documentId = "documentId";
	}
}
