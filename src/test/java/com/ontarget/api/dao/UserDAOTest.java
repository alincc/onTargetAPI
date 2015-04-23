package com.ontarget.api.dao;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserProfileInfo;

/**
 * Created by Owner on 11/6/14.
 */
public class UserDAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(UserDAOTest.class);

	@Autowired
	@Qualifier("userJpaDAOImpl")
	private UserDAO userDAO;

	@Test
	public void updateUserProfile() {
		UpdateUserProfileRequest request = new UpdateUserProfileRequest();
		UserProfileInfo userProfileInfo = new UserProfileInfo();
		userProfileInfo.setAreaCode(977);
		userProfileInfo.setPhoneNumber("9801012345");
		userProfileInfo.setFirstName("Sanjeev");
		userProfileInfo.setLastName("Ghimire");
		userProfileInfo.setEmail("sanjeev@ontargetcloud.com");
		userProfileInfo.setUserId(1);

		request.setUserProfileInfo(userProfileInfo);
		try {
			boolean updated = userDAO.updateUserProfile(request);
			Assert.assertTrue(updated);
		} catch (Exception e) {
			logger.error("Error while updating profile", e);
			fail();
		}
	}

}
