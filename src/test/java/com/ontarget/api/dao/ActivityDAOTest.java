package com.ontarget.api.dao;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.ActivityLog;

public class ActivityDAOTest extends BaseTest {
	@Autowired
	@Qualifier("activityJpaDAOImpl")
	private ActivityDAO activityDAO;

	@Test
	public void getUserNotifications() {
		long recentId = 1;
		try {
			//List<ActivityLog> logs = activityDAO.getActivityLog(recentId);
			//Assert.assertTrue(logs != null);
		} catch (Exception e) {
			logger.error("Error while retrieving activity logs", e);
			fail();
		}
	}

}
