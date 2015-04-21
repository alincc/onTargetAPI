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
public class ProjectDAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(ProjectDAOTest.class);

	@Autowired
	@Qualifier("projectJpaDAOImpl")
	private ProjectDAO projectDAO;

	@Test
	public void deleteProject() {
		int projectId = 211;
		int userId = 1;
		try {
			boolean deleted = projectDAO.deleteProject(projectId, userId);
			Assert.assertTrue(deleted);
		} catch (Exception e) {
			logger.error("Error while deleting", e);
			fail();
		}
	}

}
