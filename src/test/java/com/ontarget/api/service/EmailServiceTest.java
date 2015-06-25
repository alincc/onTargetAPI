package com.ontarget.api.service;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.UserDTO;
import com.ontarget.entities.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.fail;

/**
 * Created by sanjeevghimire on 6/24/15.
 */
public class EmailServiceTest extends BaseTest {


    private Logger logger = Logger.getLogger(EmailServiceTest.class);

    @Autowired
    private EmailService emailService;

    @Test
    public void sendTaskEmailTest(){

        ProjectTaskInfo taskInfo=new ProjectTaskInfo();
        taskInfo.setTitle("Test title");


        User createdBy = new User();
        createdBy.setUserId(10);
        taskInfo.setCreatedBy(createdBy);

        Contact contact = new Contact();
        contact.setFirstName("Assinged fn");
        contact.setLastName("Assigned ln");
        UserDTO userDto = new UserDTO();
        userDto.setUserId(10);
        contact.setUser(userDto);


        try {
            emailService.sendTaskAssignmentEmail(taskInfo, contact);
        } catch (Exception e) {
            logger.error(e);
            fail();
        }
    }

}
