package com.ontarget.api.dao;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.entities.FieldWorker;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;
import com.ontarget.request.bean.UpdateTimeCardRequest;

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
		request.setFieldWorkerId(1);
		request.setProjectTaskId(1);
		try {
			boolean added = timeCardDAO.add(request);
			Assert.assertTrue(added);
		} catch (Exception e) {
			logger.error("Error while adding time card", e);
			fail();
		}
	}

	@Test
	public void update() {
		UpdateTimeCardRequest request = new UpdateTimeCardRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		request.setBaseRequest(baseRequest);

		request.setId(1);
		request.setTimeIn(new Date());
		request.setTimeOut(new Date());
		request.setFieldWorkerId(1);
		request.setProjectTaskId(1);
		try {
			boolean updated = timeCardDAO.update(request);
			Assert.assertTrue(updated);
		} catch (Exception e) {
			logger.error("Error while updating time card", e);
			fail();
		}
	}

	@Test
	public void addFieldWorker() {
		AddFieldWorkerRequest request = new AddFieldWorkerRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		request.setBaseRequest(baseRequest);

		request.setDiscipline(1l);
		request.setEmail("santosh8pun@gmail.com");
		request.setFirstName("Santosh");
		request.setLastName("Pun");
		request.setPhoneNumber("9808639594");
		try {
			boolean added = timeCardDAO.addFieldWorker(request);
			Assert.assertTrue(added);
		} catch (Exception e) {
			logger.error("Error while adding field worker", e);
			fail();
		}
	}

	@Test
	public void updateFieldWorker() {
		UpdateFieldWorkerRequest request = new UpdateFieldWorkerRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		request.setBaseRequest(baseRequest);

		request.setId(1);
		request.setDiscipline(1l);
		request.setEmail("santosh8pun@gmail.com");
		request.setFirstName("Santosh");
		request.setLastName("Pun");
		request.setPhoneNumber("9808639594");
		try {
			boolean updated = timeCardDAO.updateFieldWorker(request);
			Assert.assertTrue(updated);
		} catch (Exception e) {
			logger.error("Error while updating field worker", e);
			fail();
		}
	}

	@Test
	public void getAllFieldWorkers() {
		try {
			List<FieldWorker> fieldWorkers = timeCardDAO.getAllFieldWorkers();
			Assert.assertTrue(fieldWorkers != null);
		} catch (Exception e) {
			logger.error("Error while retrieving field workers", e);
			fail();
		}
	}

}
