package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectRequest;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 11/13/14.
 */
public class ProjectServiceTest extends BaseTest {

	private Logger logger = Logger.getLogger(AuthenticationServiceTest.class);

	@Autowired
	private ProjectService projectService;

	@Test
	public void testGetProjectsByCompany() {
		try {
			ProjectListResponse response = projectService.getProjectsByCompany(
					1, 1);
			Assert.assertTrue(response.getProjects().size() > 0);

			ProjectDTO project = response.getProjects().get(0);

			// System.out.println((project.getTaskList().get(0).getComments().get(0)));

			Assert.assertTrue(project != null
					&& project.getProjects().size() > 0);

		} catch (Exception e) {
			logger.error("Error while getting project by company", e);
			fail();
		}

	}

	@Test
	public void testAddUpdateProject() {
		ProjectDTO project = new ProjectDTO();
		project.setProjectId(1);
		project.setProjectName("Updated Name");
		project.setProjectDescription("Updated Description");
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		project.setProjectTypeId(1);
		project.setStatus(OnTargetConstant.PROJECT_STATUS.ACTIVE);
		project.setProjectTypeId(1);

		AddressDTO addr = new AddressDTO();
		addr.setAddressId(0);
		addr.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
		addr.setAddress1("4750 59th street");
		addr.setAddress2("suite 9C");
		addr.setCity("woodside");
		addr.setCountry("USA");
		addr.setState("NY");
		addr.setZip("10101");
		project.setProjectAddress(addr);

		UserDTO user = new UserDTO();
		user.setUserId(1);

		ProjectRequest request = new ProjectRequest();
		request.setProject(project);
		request.setUser(user);

		// try {
		// OnTargetResponse response = projectService.updateProject(request);
		// Assert.assertTrue(response.getReturnVal().equals(OnTargetConstant.SUCCESS));
		// } catch (Exception e) {
		// logger.error("Error while updating project by company",e);
		// fail();
		// }

	}

}
