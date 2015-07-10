package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.RegistrationApprovalRequest;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;

/**
 * Created by Owner on 10/27/14.
 */

public class AuthenticationTest extends BaseTest {

	@Test
	public void signIn() {

		SignInRequest signInRequest = new SignInRequest();
		signInRequest.setUsername("sanjeev");
		signInRequest.setPassword("123456");

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(signInRequest, true));
		Response response = sendRequest("/user/signin", signInRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

//	@Test
//	public void registrationRequest() {
//
//		UserRegistrationRequest request = new UserRegistrationRequest();
//		request.setEmail("santosh8pun@gmail.com");
//		request.setCompanyName("company name");
//		request.setMsg("request to join");
//		request.setName("santosh pun");
//		request.setPhoneNumber("43434223");
//		request.setProjectId(1);
//
//		System.out.println("Client request .... \n");
//		System.out.println(toJsonString(request, true));
//		Response response = sendRequest("/user/registrationRequest", request);
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//		String output = response.readEntity(String.class);
//		System.out.println("Server response .... \n");
//		System.out.println(output);
//	}
//
//	@Test
//	public void getPendingUserRegistrationRequests() {
//
//		System.out.println("Client request .... \n");
//		Response response = sendRequest("/user/getPendingUserRegistrationRequests", "");
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//		String output = response.readEntity(String.class);
//		System.out.println("Server response .... \n");
//		System.out.println(output);
//	}
//
//	@Test
//	public void approvePendingRegistrationRequest() {
//
//		RegistrationApprovalRequest request = new RegistrationApprovalRequest();
//		request.setEmail("santosh8pun@gmail.com");
//		request.setRequestId(1);
//
//		System.out.println("Client request .... \n");
//		System.out.println(toJsonString(request, true));
//		Response response = sendRequest("/user/approvePendingRequest", request);
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//		String output = response.readEntity(String.class);
//		System.out.println("Server response .... \n");
//		System.out.println(output);
//	}
//
//	@Test
//	public void logout() {
//
//		System.out.println("Client request .... \n");
//		Response response = sendRequest("/user/logout?username=santosh8pun@gmail.com", "");
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//		String output = response.readEntity(String.class);
//		System.out.println("Server response .... \n");
//		System.out.println(output);
//	}

}
