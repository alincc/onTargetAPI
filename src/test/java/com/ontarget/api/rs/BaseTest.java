package com.ontarget.api.rs;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;

public class BaseTest extends JerseyTest {
	
	protected BaseTest(String packageName) {
		super(packageName);
	}
	
	protected <T> String toJsonString(T obj, boolean format) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, format);
			String json = mapper.writeValueAsString(obj);
			return json;
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	protected <T> ClientResponse sendRequest(String path, T request) {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
    		String payLoad = mapper.writeValueAsString(request);
        	WebResource resource = resource();
        	ClientResponse response = resource.path(path)
                    .accept(MediaType.APPLICATION_JSON)
                    .type(MediaType.APPLICATION_JSON)
                    .put(ClientResponse.class, payLoad);
            return response;
        } catch(Throwable t) {
        	throw new RuntimeException(t);
        }
	}
}
