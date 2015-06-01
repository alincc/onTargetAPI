package com.ontarget.api.dao;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;

/**
 * Created by Owner on 11/6/14.
 */
public class TaskDaoTest extends BaseTest {

	private Logger logger = Logger.getLogger(TaskDaoTest.class);

	@Autowired
	@Qualifier("taskJpaDAOImpl")
	private TaskDAO taskDAO;

	@Test
	public void deleteTask() {
		int taskId = 211;
		int userId = 1;
		try {
			boolean deleted = taskDAO.deleteTask(taskId, userId);
			Assert.assertTrue(deleted);
		} catch (Exception e) {
			logger.error("Error while deleting", e);
			fail();
		}
	}

}
