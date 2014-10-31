package com.ontarget.api.rs;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

/**
 * Created by Owner on 10/27/14.
 */
public class AuthenticationTest extends JerseyTest {

    public AuthenticationTest() {
        super("com.ontarget.api.rs");
    }

    @Test
    public void testSignIn() {
        WebResource resource = resource();

        String auth="{\"username\":\"username\",\"password\":\"password\"}";

        ClientResponse response = resource.path("/user/signin")
                //.accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class,auth);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        System.out.println("Server response .... \n");
        System.out.println(output);

    }

}
