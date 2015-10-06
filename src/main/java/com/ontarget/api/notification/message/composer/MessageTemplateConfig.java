package com.ontarget.api.notification.message.composer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageTemplateConfig {
	@Value("${task.assign.notification}")
	private String taskAssignTemplate;

	@Value("${task.status.change.notification}")
	private String taskStatusChangeTemplate;

	@Value("${task.percentage.change.notification}")
	private String taskPercentageChangeTemplate;

	@Value("${task.comment.notification}")
	private String taskCommentTemplate;

	@Value("${task.attachment.notification}")
	private String taskAttachmentTemplate;

	@Value("${task.create.notification}")
	private String taskCreateTemplate;

	@Value("${task.update.notification}")
	private String taskUpdateTemplate;

	@Value("${project.create.notification}")
	private String projectCreateTemplate;

	@Value("${project.update.notification}")
	private String projectUpdateTemplate;

	@Value("${activity.create.notification}")
	private String activityCreateTemplate;

	@Value("${activity.update.notification}")
	private String activityUpdateTemplate;

	@Value("${onsite.document.upload.notification}")
	private String documentUploadTemplate;

	@Value("${onsite.document.comment.notification}")
	private String documentCommentTemplate;

	@Value("${task.cost.create.notification}")
	private String taskCostCreateTemplate;

	@Value("${task.cost.update.notification}")
	private String taskCostUpdateTemplate;

	public String getTaskStatusChangeTemplate() {
		return taskStatusChangeTemplate;
	}

	public String getTaskAssignTemplate() {
		return taskAssignTemplate;
	}

	public String getTaskCommentTemplate() {
		return taskCommentTemplate;
	}

	public String getTaskAttachmentTemplate() {
		return taskAttachmentTemplate;
	}

	public String getTaskCreateTemplate() {
		return taskCreateTemplate;
	}

	public String getTaskUpdateTemplate() {
		return taskUpdateTemplate;
	}

	public String getProjectCreateTemplate() {
		return projectCreateTemplate;
	}

	public String getProjectUpdateTemplate() {
		return projectUpdateTemplate;
	}

	public String getActivityCreateTemplate() {
		return activityCreateTemplate;
	}

	public String getActivityUpdateTemplate() {
		return activityUpdateTemplate;
	}

	public String getDocumentUploadTemplate() {
		return documentUploadTemplate;
	}

	public String getDocumentCommentTemplate() {
		return documentCommentTemplate;
	}

	public String getTaskPercentageChangeTemplate() {
		return taskPercentageChangeTemplate;
	}

	public String getTaskCostCreateTemplate() {
		return taskCostCreateTemplate;
	}

	public String getTaskCostUpdateTemplate() {
		return taskCostUpdateTemplate;
	}

}
