package com.ontarget.api.dao;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistrationRequest;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.fail;


/**
 * Created by Owner on 10/30/14.
 */
public class AuthenticationDAOTest extends BaseTest {

    private Logger logger = Logger.getLogger(AuthenticationDAOTest.class);

    @Autowired
    private AuthenticationDAO authenticationDAO;


    @Test
    public void testSaveRegistrationRequest(){
        UserRegistrationRequest request= new UserRegistrationRequest();
        request.setName("firstname lastname");
        request.setEmail("email@email.com");
        request.setCompanyName("Ontarget Inc.");
        request.setPhoneNumber("123-234-2345");
        request.setMsg("Ontarget is awesome that's why.");
        try {
            boolean saved = authenticationDAO.saveRegistrationRequest(request);
            Assert.assertTrue(saved);
        } catch (Exception e) {
            logger.error("Error while saving registration request",e);
            fail();
        }
    }

    @Test
    public void testGetRegistrationRequest(){
        try {
            UserRegistrationRequest info = authenticationDAO.getUserRegistrationRequestInfo(3);
            Assert.assertTrue(info!=null);
        } catch (Exception e) {
            logger.error("Error while getting user registration request info.",e);
            fail();
        }
    }

    @Test
    public void testGetUserRegistrationPendingRequest(){
        try {
            List<UserRegistrationRequest> requestList = authenticationDAO.getUserRegistrationPendingRequests();
            Assert.assertTrue(requestList.size() >= 0);
        } catch (Exception e) {
            logger.error("Error while getting user registration request info.",e);
            fail();
        }

    }


    @Test
    public void testLogout(){
        String username="testemail@mail.com";
        try {
            boolean loggedOut=authenticationDAO.logout(username);
            Assert.assertTrue(loggedOut);
        } catch (Exception e) {
            logger.error("Error while logging out.",e);
            fail();
        }
    }


    @Test
    public void testSignIn(){
        User user = new User();
        user.setUsername("sanjeevghimire");
        user.setPassword("123456");

        try {
            user = authenticationDAO.getUserSignInInfo(user);
            logger.info(user);
            Assert.assertTrue(user != null);
        } catch (Exception e) {
            logger.error("Error while logging in.", e);
            fail();
        }
    }




}
