package com.ontarget.api.dao;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.dto.UserNotificationDTO;

public class NotificationDAOTest extends BaseTest {
	@Autowired
	@Qualifier("notificationJpaDAOImpl")
	private NotificationDAO notificationDAO;

	@Test
	public void getUserNotifications() {
//		int pageNumber = 1;
//		int perPageLimit = 5;
//		int userId = 1;
//		try {
//			UserNotificationDTO notificationDTO = notificationDAO.getUserNotifications(pageNumber, perPageLimit, userId);
//			Assert.assertTrue(notificationDTO != null);
//		} catch (Exception e) {
//			logger.error("Error while retrieving user notifications", e);
//			fail();
//		}
	}

}
