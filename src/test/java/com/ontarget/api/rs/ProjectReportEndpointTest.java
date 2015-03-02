package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.ProjectReportInfo;

public class ProjectReportEndpointTest extends BaseTest {

	@Test
	public void getProjectEarnedValueAnalysis() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectReportInfo request = new ProjectReportInfo();
		request.setBaseRequest(baseRequest);
		request.setProjectId(42);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendPutRequest("/report/earnedValueReport", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTimeSaved() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectReportInfo request = new ProjectReportInfo();
		request.setBaseRequest(baseRequest);
		request.setProjectId(42);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendPutRequest("/report/bireport", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
