package com.ontarget.api.rs;

import java.sql.Date;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.AccidentReportRequest;
import com.ontarget.request.bean.BaseRequest;

public class AccidentReportEndpointTest extends BaseTest {

	@Test
	public void testSaveAccidentReport() {
		AccidentReportRequest accidentReport = new AccidentReportRequest();

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
		accidentReport.setDateOfAccident(new Date(new java.util.Date()
				.getTime()));
		accidentReport.setTimeOfAccident("12345");
		accidentReport.setInjuredVisitedDoctor("Test Value");
		accidentReport.setWorkersCompensationFiled("Test Value");
		accidentReport.setInjuredLeftJob("Test Value");
		accidentReport.setDateInjuredLeftJob(new Date(new java.util.Date().getTime()));
		accidentReport.setTimeInjuredLeftJob("Test Value");
		accidentReport.setPossiblePreventiveMeasures("Test Value");
		accidentReport.setUnsafeConditionsCorrected("Test Value");
		accidentReport.setCorrectionMeasuresPerformed("Test Value");
		accidentReport.setCorrectionMeasuresToBePerformed("Test Value");

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(accidentReport, true));
		Response response = sendRequest("/accidentreports", accidentReport);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}
}
