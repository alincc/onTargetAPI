package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.SignInRequest;

/**
 * Created by Owner on 10/27/14.
 */

public class AuthenticationTest extends BaseTest {

	@Test
	public void testSignIn() {

		SignInRequest signInRequest = new SignInRequest();
		signInRequest.setUsername("sanjeev@ontargetcloud.com");
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

}
