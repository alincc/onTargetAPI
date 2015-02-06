package com.ontarget.api.rs;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class UserInvitationTest extends JerseyTest {

	public UserInvitationTest() {
		super("com.ontarget.api.rs");
	}

	@Test
	public void testInviteUserIntoNewAccount() {
		WebResource resource = resource();

		String auth = "{\"username\":\"username\",\"password\":\"password\",\"email\":\"test@email.com\""
				+ ",\"phoneNumber\":\"424234324\",\"msg\":\"Invitation request\"}";

		ClientResponse response = resource.path("/onTargetInvitation/inviteToNewAccount")
				// .accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, auth);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
