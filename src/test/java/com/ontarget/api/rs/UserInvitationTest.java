package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.UserInvitationRequest;

public class UserInvitationTest extends BaseTest {

	@Test
	public void testInviteUserIntoNewAccount() {

		UserInvitationRequest userInvitationRequest = new UserInvitationRequest();

		userInvitationRequest.setFirstName("santosh");
		userInvitationRequest.setLastName("Pun234");
		userInvitationRequest.setEmail("santosh8pun@gmail.com");
		userInvitationRequest.setPhoneNumber("45345345");
		userInvitationRequest.setMsg("I want to request for onboard demo");

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(userInvitationRequest, true));
		Response response = sendRequest(
				"/onTargetInvitation/inviteToNewAccount", userInvitationRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
