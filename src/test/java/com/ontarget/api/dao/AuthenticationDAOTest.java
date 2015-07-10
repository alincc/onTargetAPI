package com.ontarget.api.dao;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.UserLoginInfo;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;
import com.ontarget.util.Security;

/**
 * Created by Owner on 10/30/14.
 */
public class AuthenticationDAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(AuthenticationDAOTest.class);

	@Autowired
	@Qualifier("authenticationJpaDAOImpl")
	private AuthenticationDAO authenticationDAO;

	@Test
	public void saveRegistrationRequest() {
		UserRegistrationRequest request = new UserRegistrationRequest();
		request.setName("firstname lastname");
		request.setEmail("email@email.com");
		request.setCompanyName("Ontarget Inc.");
		request.setPhoneNumber("123-234-2345");
		request.setMsg("Ontarget is awesome that's why.");
		request.setProjectId(1);
		String tokenId = Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
		request.setTokenId(tokenId);
		try {
			boolean saved = authenticationDAO.saveRegistrationRequest(request);
			Assert.assertTrue(saved);
		} catch (Exception e) {
			logger.error("Error while saving registration request", e);
			fail();
		}
	}

	@Test
	public void logout() {
		String username = "sanjeev@ontargetcloud.com";
		try {
			boolean loggedOut = authenticationDAO.logout(username);
			Assert.assertTrue(loggedOut);
		} catch (Exception e) {
			logger.error("Error while logging out.", e);
			fail();
		}
	}

	@Test
	public void getUserSignInInfo() {
		SignInRequest signInRequest = new SignInRequest();
		signInRequest.setUsername("sanjeev@ontargetcloud.com");
		signInRequest.setPassword("123456");

		try {
			UserLoginInfo user = authenticationDAO.getUserSignInInfo(signInRequest);
			logger.info(user);
			System.out.println(user.getUserId());
			Assert.assertTrue(user != null);
		} catch (Exception e) {
			logger.error("Error while logging in.", e);
			fail();
		}
	}

}
