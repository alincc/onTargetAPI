package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import com.ontarget.dto.UserRegistrationRequest;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.fail;

/**
 * Created by Owner on 10/30/14.
 */
public class AuthenticationServiceTest extends BaseTest {

    private Logger logger = Logger.getLogger(AuthenticationServiceTest.class);

    @Autowired
    private AuthenticationService authenticationService;


    @Test
    public void testUserRegistration() {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setName("firstname lastname");
        request.setEmail("email@email.com");
        request.setCompanyName("Ontarget Inc.");
        request.setPhoneNumber("123-234-2345");
        request.setMsg("Ontarget is awesome that's why.");

        try {
            boolean saved = authenticationService.registrationRequest(request);
            Assert.assertTrue(saved);
        } catch (Exception e) {
            logger.error("Error while saving user registration request.", e);
            fail();
        }

    }

    @Test
    public void testLogout() {
        String username = "testemail@mail.com";
        try {
            boolean loggedOut = authenticationService.logout(username);
            Assert.assertTrue(loggedOut);
        } catch (Exception e) {
            logger.error("Error while logging out.", e);
            fail();
        }
    }


}
