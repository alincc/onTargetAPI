package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserSignupRequest;

public class UserRegistrationTest extends BaseTest {

	@Test
	public void inviteUserIntoProject() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		InviteUserIntoProjectRequest request = new InviteUserIntoProjectRequest();
		request.setEmail("santosh7pun@gmail.com");
		request.setProjectId(45);
		request.setFirstName("santosh");
		request.setLastName("pun");
		request.setCompanyId(6);

		// request.setCompanyName("Test company name");
		// request.setCompanyAddress1("address1");
		// request.setCompanyAddress2("address2");
		// request.setCompanyCity("city");
		// request.setCompanyState("ST");
		// request.setCompanyCountry("COU");
		// request.setCompanyZip("11234");
		// request.setCompanyTypeId(1);
		// request.setCompanyLogoPath("company.jpg");

		request.setBaseRequest(baseRequest);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/register/inviteUserIntoProject", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void inviteUserIntoNewAccount() {

		InviteUserIntoProjectRequest request = new InviteUserIntoProjectRequest();
		request.setEmail("santosh8pun@gmail.com");
		request.setProjectId(1);
		request.setFirstName("santosh");
		request.setLastName("pun");
		request.setRegistrationToken("424234243424");

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/register/inviteToNewAccount", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void validateLink() {

		System.out.println("Client request .... \n");
		Response response = getRequest("/register/validateLink?q=token");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void createNewUser() {

		UserSignupRequest request = new UserSignupRequest();
		request.setDiscipline(1);
		request.setUsername("santosh121");
		request.setEmail("santosh8pun@gmail.com");
		request.setFirstName("Santosh");
		request.setLastName("Pun");
		request.setPassword("123456");
		request.setRegistrationToken("151713024037716336156861413352402694741280362992645859889189");
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

	@Test
	public void activateAccount() {

		System.out.println("Client request .... \n");
		Response response = getRequest("/register/activateAccount/1");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}
}
