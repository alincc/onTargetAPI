package com.ontarget.api.dao;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 11/5/14.
 */
public class ContactDAOTest extends BaseTest {

    private Logger logger = Logger.getLogger(ContactDAOTest.class);

    @Autowired
    private ContactDAO contactDAO;


    @Test
    public void testAddContactInfo(){

        Contact contact = new Contact();
        contact.setTitle("Project Manager");
        contact.setFirstName("firstname");
        contact.setLastName("lastname");

        Company company = new Company();
        company.setCompanyId(1);
        contact.setCompany(company);
        User user = new User();
        user.setUserId(1);
        contact.setUser(user);

        try {
            boolean added = contactDAO.addContactInfo(contact);

            Assert.assertTrue(added);

        } catch (Exception e) {
            logger.error("Error while adding contact",e);
            fail();

        }


    }


}
