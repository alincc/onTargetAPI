package com.ontarget.api.rs;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ontarget.request.bean.UserInvitationRequestBean;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class UserInvitationTest extends JerseyTest {

	public UserInvitationTest() {
		super("com.ontarget.api.rs");
	}

	@Test
	public void testInviteUserIntoNewAccount() throws JsonGenerationException,
			JsonMappingException, IOException {
		WebResource resource = resource();

		UserInvitationRequestBean userInvitationRequest = new UserInvitationRequestBean();
		userInvitationRequest.setFirstName("santosh");
		userInvitationRequest.setLastName("Pun");
		userInvitationRequest.setEmail("santosh8pun@gmail.com");
		userInvitationRequest.setPhoneNumber("45345345");
		userInvitationRequest.setMsg("I want to request for onboard demo");

		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(userInvitationRequest);

		System.out.println("json data:: " + jsonData);

		ClientResponse response = resource
				.path("/onTargetInvitation/inviteToNewAccount")
				// .accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, jsonData);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void testInvitationApprovalList() throws JsonGenerationException,
			JsonMappingException, IOException {
		WebResource resource = resource();

		ClientResponse response = resource
				.path("/onTargetInvitation/pendingRegistrationRequest")
				.post(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}

		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
