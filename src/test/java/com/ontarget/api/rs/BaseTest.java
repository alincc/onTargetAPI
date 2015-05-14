package com.ontarget.api.rs;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.module.SimpleModule;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.config.JerseyResourceInitializer;
import com.ontarget.util.JsonDateSerializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration
@Transactional
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

	private WebTarget target;
	private ClientConfig config;
	private Client client;
	private Response response;
	private String BASE_URI = "http://localhost:8080/ontargetrs/services";

	protected <T> String toJsonString(T obj, boolean format) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, format);
			SimpleModule simpleModule = new SimpleModule("SimpleModule", new Version(2, 0, 0, null));
			simpleModule.addSerializer(Date.class, new JsonDateSerializer());
			mapper.registerModule(simpleModule);
			String json = mapper.writeValueAsString(obj);
			return json;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	protected <T> Response sendRequest(String path, T request) {
		try {
			client = ClientBuilder.newClient();

			client.register(JerseyResourceInitializer.class);

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
			config = new ClientConfig();
			client = ClientBuilder.newClient(config);
			String fullUri = BASE_URI + path;
			System.out.println(fullUri);
			target = client.target(BASE_URI).path(path);
			String payload = mapper.writeValueAsString(request);
			response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(payload));
			return response;
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	protected <T> Response sendPutRequest(String path, T request) {
		try {
			client = ClientBuilder.newClient();

			client.register(JerseyResourceInitializer.class);

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
			config = new ClientConfig();
			client = ClientBuilder.newClient(config);
			String fullUri = BASE_URI + path;
			System.out.println(fullUri);
			target = client.target(BASE_URI).path(path);
			String payload = mapper.writeValueAsString(request);
			response = target.request(MediaType.APPLICATION_JSON).put(Entity.json(payload));
			return response;
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	protected <T> Response getRequest(String path) {
		try {
			client = ClientBuilder.newClient();

			client.register(JerseyResourceInitializer.class);
			config = new ClientConfig();
			client = ClientBuilder.newClient(config);
			String fullUri = BASE_URI + path;
			System.out.println(fullUri);
			target = client.target(BASE_URI).path(path);
			response = target.request(MediaType.APPLICATION_JSON).get();
			return response;
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

}
