package com.ontarget.api.rs;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ontarget.request.bean.AccidentReportRequestBean;
import com.ontarget.request.bean.BaseRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class AccidentReportEndpointTest extends BaseTest {

	public AccidentReportEndpointTest() throws TestContainerException {
		super("com.ontarget.api.rs");
	}

	@Test
	public void testSaveAccidentReport() {
		AccidentReportRequestBean accidentReport = new AccidentReportRequestBean();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(1);
		baseRequestBean.setLoggedInUserProjectId(1);

		accidentReport.setBaseRequest(baseRequestBean);
		accidentReport.setProjectId(1);
		accidentReport.setSubmittedTo("Test Value");
		accidentReport.setSupervisorName("Test Value");
		accidentReport.setWitness("Test Value");
		accidentReport.setLocation("Test Value");
		accidentReport.setBriefOfAccident("Test Value");
		accidentReport.setSeverity("Test Value");
		accidentReport.setDescription("Test Value");
		accidentReport.setBodyPartAffected("Test Value");
		accidentReport.setDateOfAccident(new Date());
		accidentReport.setTimeOfAccident("Test Value");
		accidentReport.setInjuredVisitedDoctor("Test Value");
		accidentReport.setWorkersCompensationFiled("Test Value");
		accidentReport.setInjuredLeftJob("Test Value");
		accidentReport.setDateInjuredLeftJob(new Date());
		accidentReport.setTimeInjuredLeftJob("Test Value");
		accidentReport.setPossiblePreventiveMeasures("Test Value");
		accidentReport.setUnsafeConditionsCorrected("Test Value");
		accidentReport.setCorrectionMeasuresPerformed("Test Value");
		accidentReport.setCorrectionMeasuresToBePerformed("Test Value");
		System.out.println("Client request .... \n");
		System.out.println(toJsonString(accidentReport, true));
		ClientResponse response = sendRequest("/accidentreports",
				accidentReport);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
