package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UserRegistrationInfo;

public class UserRegistrationTest extends BaseTest {

	@Test
	public void inviteUserIntoProject() {

		InviteUserIntoProjectRequest request = new InviteUserIntoProjectRequest();
		request.setEmail("santosh8pun@gmail.com");
		request.setProjectId(1);
		request.setFirstName("santosh");
		request.setLastName("pun");

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

		UserRegistrationInfo request = new UserRegistrationInfo();
		request.setDiscipline(1);
		request.setUsername("santosh");
		request.setEmail("santosh8pun@gmail.com");
		request.setPassword("admin");
		request.setRegistrationToken("680253301170766157484079574362950236876346915699494890162895");

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
