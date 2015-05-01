package com.ontarget.api.dao;

import static org.junit.Assert.fail;




import java.util.Date;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.BaseRequest;

public class TimeCardDAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(TimeCardDAOTest.class);

	@Autowired
	@Qualifier("timeCardJpaDAOImpl")
	private TimeCardDAO timeCardDAO;

	@Test
	public void add() {
		AddTimeCardRequest request = new AddTimeCardRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		request.setBaseRequest(baseRequest);

		request.setTimeIn(new Date());
		request.setTimeOut(new Date());
		request.setName("Santosh Pun");
		request.setProjectTaskId(1);
		try {
			boolean added = timeCardDAO.add(request);
			Assert.assertTrue(added);
		} catch (Exception e) {
			logger.error("Error while adding time card", e);
			fail();
		}
	}

}
