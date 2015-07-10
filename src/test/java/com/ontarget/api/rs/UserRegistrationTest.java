package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserSignupRequest;

public class UserRegistrationTest extends BaseTest {

	// @Test
	// public void inviteUserIntoProject() {
	//
	// InviteUserIntoProjectRequest request = new
	// InviteUserIntoProjectRequest();
	// request.setEmail("santosh8pun@gmail.com");
	// request.setProjectId(2);
	// request.setFirstName("santosh");
	// request.setLastName("pun");
	// request.setCompanyId(1);
	//
	// // request.setCompanyName("Test company name");
	// // request.setCompanyAddress1("address1");
	// // request.setCompanyAddress2("address2");
	// // request.setCompanyCity("city");
	// // request.setCompanyState("ST");
	// // request.setCompanyCountry("COU");
	// // request.setCompanyZip("11234");
	// // request.setCompanyTypeId(1);
	//
	// System.out.println("Client request .... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/register/inviteUserIntoProject",
	// request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	// }

	// @Test
	// public void inviteUserIntoNewAccount() {
	//
	// InviteUserIntoProjectRequest request = new
	// InviteUserIntoProjectRequest();
	// request.setEmail("santosh8pun@gmail.com");
	// request.setProjectId(1);
	// request.setFirstName("santosh");
	// request.setLastName("pun");
	// request.setRegistrationToken("424234243424");
	//
	// System.out.println("Client request .... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/register/inviteToNewAccount", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	// }
	//
	// @Test
	// public void validateLink() {
	//
	// System.out.println("Client request .... \n");
	// Response response = getRequest("/register/validateLink?q=token");
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	// }
	//
	@Test
	public void createNewUser() {

		UserSignupRequest request = new UserSignupRequest();
		request.setDiscipline(1);
		request.setUsername("santosh121");
		request.setEmail("santosh8pun@gmail.com");
		request.setFirstName("Santosh");
		request.setLastName("Pun");
		request.setPassword("123456");
		request.setRegistrationToken("749386401592128369547073841169158573798497667515454016839101");
		request.setTitle("Mr");
		request.setAreaCode(977);
		request.setPhoneNumber("9808639594");
		request.setUserImagePath("santosh.jpg");

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/register/createUser", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

//	@Test
//	public void activateAccount() {
//
//		System.out.println("Client request .... \n");
//		Response response = getRequest("/register/activateAccount/1");
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//		String output = response.readEntity(String.class);
//		System.out.println("Server response .... \n");
//		System.out.println(output);
//	}
}
