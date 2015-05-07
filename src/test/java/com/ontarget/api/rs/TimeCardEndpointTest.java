package com.ontarget.api.rs;

import java.util.Date;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;

public class TimeCardEndpointTest extends BaseTest {

	@Test
	public void addTimeCard() {

		AddTimeCardRequest request = new AddTimeCardRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		request.setBaseRequest(baseRequest);

		request.setTimeIn(new Date());
		request.setTimeOut(new Date());
		request.setName("Santosh Pun");
		request.setProjectTaskId(16);

		System.out.println("Client request addTimeCard.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/timeCard/add", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

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

		System.out.println("Client request addFieldWorker.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/timeCard/addFieldWorker", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void editFieldWorker() {

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

		System.out.println("Client request editFieldWorker.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/timeCard/editFieldWorker", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getFieldWorkers() {

		System.out.println("Client request getFieldWorkers.... \n");
		Response response = getRequest("/timeCard/getFieldWorkers");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
