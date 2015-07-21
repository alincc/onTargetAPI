package com.ontarget.api.service;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.dto.ForgotPasswordRequestResponse;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.fail;

/**
 * Created by sanjeevghimire on 6/25/15.
 */
public class UserProfileServiceImplTest extends BaseTest {

	private Logger logger = Logger.getLogger(EmailServiceTest.class);

	@Autowired
	private UserProfileService userProfileService;

	@Test
	public void forgotPasswordRequestTest() {

		String emailAddress = "gsanjeev7@gmail.com";

		try {
			ForgotPasswordRequestResponse response = userProfileService.forgotPasswordRequest(emailAddress);
			Assert.assertTrue(response != null);
		} catch (Exception e) {
			logger.error("Error while sending forgot password request");
			fail();
		}
	}

}
