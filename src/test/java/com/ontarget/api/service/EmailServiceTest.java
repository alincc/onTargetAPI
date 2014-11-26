package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 11/16/14.
 */
public class EmailServiceTest extends BaseTest {

    private Logger logger = Logger.getLogger(EmailServiceTest.class);

    @Autowired
    private EmailService emailService;


    @Test
    public void testSendUserRequestEmail(){

        try {
            emailService.sendUserRegistrationEmail();
        } catch (Exception e) {
            logger.error("Error while sending email",e);
            fail();
        }

    }
}
