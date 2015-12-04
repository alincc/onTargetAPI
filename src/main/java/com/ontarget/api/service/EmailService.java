package com.ontarget.api.service;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.Contact;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.request.bean.Assignee;

/**
 * Created by Owner on 11/2/14.
 */
public interface EmailService {

	void sendTaskStatusChangeEmail(ProjectTaskInfo task, int userId);

	public void sendTaskCommentEmail(ProjectTaskInfo task, Contact commentedBy, int assigneeUserId);

	public void sendTaskAttachmentEmail(ProjectTaskInfo task, Contact attachmentDoneBy, int assigneeUserId);

	public boolean sendUserRequestEmailToAdmin();

	public boolean sendUserRegistrationEmail(String userEmail, String tokenId, String receiverFirstName, String senderFirstName,
			String senderLastName, String projectName) throws Exception;

	public boolean sendDocumentAssignmentEmails(DocumentDTO document, List<Assignee> assignees);

	public void sendTaskAssignmentEmail(ProjectTaskInfo task, Contact contact) throws Exception;

	public void sendForgotPasswordEmail(String emailAddress, String name, String forgotPasswordToken);

	public boolean sendInvitationEmailForRegistration(int userRequestId);

	public boolean sendInviteUserToProjectEmail(String userEmail, String tokenId, String receiverFirstName, String senderFirstName,
			String senderLastName, String projectName);

	public void sendDocumentStatusUpdateEmail(String documentTitle, String updatedStatus, String assigneeFirstName,
			String assigneeLastName, String assigneeEmail, String modifierFirstName, String modifierLastName, String creatorFirstName);

	public void sendDocumentSubmittalEmail(String documentTitle, String assigneeEmail, String assigneeFirstName, String assigneeLastName,
			String creatorFirstName, String creatorLastName, String dueDate);

    void sendEmail(Map<String, Object> emailAttributes) throws  Exception;
}
