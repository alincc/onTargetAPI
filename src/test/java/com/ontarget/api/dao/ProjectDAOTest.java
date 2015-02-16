package com.ontarget.api.dao;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static junit.framework.Assert.fail;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectDAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(TaskDaoTest.class);

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private AddressDAO addressDAO;

	@Test
	public void testAddProject() {

		ProjectDTO project = new ProjectDTO();
		project.setCompanyId(1);
		project.setProjectName("test project");
		project.setProjectDescription("test project");
		project.setProjectParentId(0);
		project.setProjectTypeId(1);
		project.setStatus("PENDING");

		AddressDTO address = new AddressDTO();
		address.setAddress1("4750 59th street");
		address.setAddress2("Apt #9C");
		address.setCity("Woodside");
		address.setState("NY");
		address.setZip("11377");
		address.setCountry("USA");
		address.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
		project.setProjectAddress(address);

		try {

			int addressId = addressDAO.addAddress(address);
			Assert.assertTrue(addressId > 0);

			address.setAddressId(addressId);

			int projectId = projectDAO.addProject(project);
			Assert.assertTrue(projectId > 0);
		} catch (Exception e) {
			logger.error("Fail to add task", e);
			fail();
		}

	}

}
