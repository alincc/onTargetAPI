package com.ontarget.api.dao;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.BaseTest;
import com.ontarget.dto.UserRegistrationRequest;

public class UserInvitationDAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(AuthenticationDAOTest.class);

	@Autowired
	private UserInvitationDAO userInvitationDAO;

	@Test
	public void testSaveRegistrationRequest() {
		UserRegistrationRequest request = new UserRegistrationRequest();
		request.setFirstName("Santosh");
		request.setLastName("Pun");
		request.setEmail("email@email.com");
		request.setPhoneNumber("123-234-2345");
		request.setMsg("Ontarget is awesome that's why.");
		try {
			boolean saved = userInvitationDAO.saveRegistrationRequest(request);
			Assert.assertTrue(saved);
		} catch (Exception e) {
			logger.error("Error while saving registration request", e);
			fail();
		}
	}
	
	@Test
	public void testFetchPendingRequests(){
		try{
			List<UserRegistrationRequest> pendingRequests = userInvitationDAO.fetchPendingRequests();
			
		}catch(Exception e){
			logger.error("Error while fetching pending request list",e);
			fail();
		}
	}
			

}
