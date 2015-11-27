package com.ontarget.api.service;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.UserDTO;
import com.ontarget.entities.User;

/**
 * Created by sanjeevghimire on 6/24/15.
 */
public class EmailServiceTest extends BaseTest {

	private Logger logger = Logger.getLogger(EmailServiceTest.class);

	@Autowired
	private EmailService emailService;

	@Test
	public void sendTaskAssignmentEmailTest() {

		ProjectTaskInfo taskInfo = new ProjectTaskInfo();
		taskInfo.setTitle("Test title");

		User createdBy = new User();
		createdBy.setUserId(10);
		taskInfo.setCreatorId(1);

		Contact contact = new Contact();
		contact.setFirstName("Assinged fn");
		contact.setLastName("Assigned ln");
		UserDTO userDto = new UserDTO();
		userDto.setUserId(2);
		contact.setUser(userDto);

		try {
			emailService.sendTaskAssignmentEmail(taskInfo, contact);
		} catch (Exception e) {
			logger.error(e);
			fail();
		}
	}

	@Test
	public void sendTaskStatusChangeEmailTest() {

		ProjectTaskInfo taskInfo = new ProjectTaskInfo();
		taskInfo.setTitle("Test title");
		taskInfo.setStatus("ACTIVE");
		User createdBy = new User();
		createdBy.setUserId(10);
		// taskInfo.setCreatedBy(createdBy);

		try {
			emailService.sendTaskStatusChangeEmail(taskInfo, 10);
		} catch (Exception e) {
			logger.error(e);
			fail();
		}
	}

	@Test
	public void sendInviteUserToProjectEmail() {
		try {
			emailService.sendInviteUserToProjectEmail("santosh8pun@gmail.com", "12345", "Santosh", "Niran", "Shrestha", "OnTarget App");
		} catch (Exception e) {
			logger.error(e);
			fail();
		}
	}

	@Test
	public void sendDocumentStatusUpdateEmail() {
		try {
			emailService.sendDocumentStatusUpdateEmail("Test doc", "APPROVED", "Santosh", "Pun", "santosh8pun@gmail.com", "Mike", "Malony",
					"Sanjeev");
		} catch (Exception e) {
			logger.error(e);
			fail();
		}
	}
}
