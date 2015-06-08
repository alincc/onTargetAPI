package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import junit.framework.Assert;
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
        userInvitationRequest.setCompanyName("Test company name");
        userInvitationRequest.setCompanyAddress1("address1");
        userInvitationRequest.setCompanyAddress2("address2");
        userInvitationRequest.setCompanyCity("city");
        userInvitationRequest.setCompanyState("ST");
        userInvitationRequest.setCompanyCountry("COU");
        userInvitationRequest.setCompanyZip("11234");

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(userInvitationRequest, true));
		Response response = sendRequest(
				"/onTargetInvitation/inviteToNewAccount", userInvitationRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
        Assert.assertTrue(output.contains("SUCCESS"));
        System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void getPendingRequestList() {
		System.out.println("Client request.... \n");
		Response response = sendRequest(
				"/onTargetInvitation/pendingRegistrationRequest", "");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void approveRequest() {
		System.out.println("Client request.... \n");
		Response response = sendRequest(
				"/onTargetInvitation/approvalRequest?id=1", "");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void verifyToken() {
		System.out.println("Client request.... \n");
		Response response = getRequest("/onTargetInvitation/validateLink?q=289491604971351964613053906223968544910802334885836803590542");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
