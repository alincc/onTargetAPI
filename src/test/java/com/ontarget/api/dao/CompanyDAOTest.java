package com.ontarget.api.dao;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.Company;
import com.ontarget.bean.UserAddressInfo;
import com.ontarget.request.bean.CompanyEditInfo;

/**
 * Created by Owner on 11/6/14.
 */
public class CompanyDAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(CompanyDAOTest.class);

	@Autowired
	@Qualifier("companyJpaDAOImpl")
	private CompanyDAO companyDAO;

	@Test
	public void update() {
		CompanyEditInfo company = new CompanyEditInfo();
		company.setCompanyId(1);
		company.setCompanyName("SIMON AND BARRON WEA RESIDENTIAL");
		company.setCompanyTypeId(1);

		UserAddressInfo address = new UserAddressInfo();
		address.setAddress1("363 23rd st");
		address.setAddress2("Suite 2098");
		address.setCity("New York");
		address.setCountry("USA");
		address.setState("NY");
		address.setZip("10001");

		company.setAddress(address);

		try {
			boolean updated = companyDAO.update(company,11);
			Assert.assertTrue(updated);
		} catch (Exception e) {
			logger.error("Error while updating company details", e);
			fail();
		}
	}

	@Test
	public void getCompany() {
		int companyId = 1;
		try {
			Company company = companyDAO.getCompany(companyId);
			Assert.assertTrue(company != null);
		} catch (Exception e) {
			logger.error("Error while retrieving company info", e);
			fail();
		}
	}

}
