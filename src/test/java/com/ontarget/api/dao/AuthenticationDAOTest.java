package com.ontarget.api.dao;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.UserRegistrationRequest;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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


}
