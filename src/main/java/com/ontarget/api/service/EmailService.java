package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.Contact;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskInfo;
import com.ontarget.request.bean.Assignee;

/**
 * Created by Owner on 11/2/14.
 */
public interface EmailService {

	public boolean sendUserRequestEmail(int userRequestId);

	public boolean sendUserRequestEmailToAdmin(int userRequestId);

	public boolean sendUserRegistrationEmail(String userEmail, String tokenId,
			String receiverFirstName, String senderFirstName,
			String senderLastName) throws Exception;

	public boolean sendUserRegistrationEmail() throws Exception;

	public boolean sendDocumentAssignmentEmails(DocumentDTO document,
			List<Assignee> assignees);

	public boolean sendInviteToAccountEmail(String email, String firstName,
			String lastName, String tokenId);

	public void sendTaskAssignmentEmail(ProjectTaskInfo task, Contact contact)
			throws Exception;

	public void sendForgotPasswordEmail(String emailAddress, String name,
			String forgotPasswordToken);

	public boolean sendInvitationEmailForRegistration(int userRequestId);

}
