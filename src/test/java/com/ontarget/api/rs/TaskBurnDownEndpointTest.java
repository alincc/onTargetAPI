package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.ProjectDetailRequest;

public class TaskBurnDownEndpointTest extends BaseTest {
	private Logger logger = Logger.getLogger(TaskBurnDownEndpointTest.class);

	@Test
	public void getTaskBurnDownOfProject() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		ProjectDetailRequest request = new ProjectDetailRequest();
		request.setBaseRequest(baseRequest);

		request.setProjectId(45);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/task/burndown/project", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
