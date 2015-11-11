package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.Contact;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.bean.ProjectInfo;
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
			String senderLastName, ProjectInfo projectInfo) throws Exception;

	public boolean sendDocumentAssignmentEmails(DocumentDTO document, List<Assignee> assignees);



	public void sendTaskAssignmentEmail(ProjectTaskInfo task, Contact contact) throws Exception;

	public void sendForgotPasswordEmail(String emailAddress, String name, String forgotPasswordToken);

	public boolean sendInvitationEmailForRegistration(int userRequestId);

}
