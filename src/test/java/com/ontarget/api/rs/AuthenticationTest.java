package com.ontarget.api.rs;

import java.io.IOException;

import com.ontarget.request.bean.SignInRequestBean;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.ws.rs.core.MediaType;

/**
 * Created by Owner on 10/27/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class AuthenticationTest extends JerseyTest {

	public AuthenticationTest() {
		super("com.ontarget.api.rs");
	}

	@Test
	public void testSignIn() throws JsonGenerationException,
			JsonMappingException, IOException {
		WebResource resource = resource();

		SignInRequestBean signInRequest = new SignInRequestBean();
		signInRequest.setUsername("sanjeev@ontargetcloud.com");
		signInRequest.setPassword("123456");

		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(signInRequest);

		System.out.println("json data:: " + jsonData);

		ClientResponse response = resource.path("/user/signin")
				.accept(MediaType.APPLICATION_JSON)
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

}
