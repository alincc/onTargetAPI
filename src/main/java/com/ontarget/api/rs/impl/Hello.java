package com.ontarget.api.rs.impl;

import com.ontarget.api.service.HelloService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Example resource class hosted at the URI path "/hello"
 */
@Component
@Path("/hello")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Hello {

	private Logger logger = Logger.getLogger(Hello.class);

	@Autowired
	private HelloService helloService;

	/**
	 * Method processing HTTP GET requests, producing "text/plain" MIME media
	 * type.
	 *
	 * @return String that will be send back as a response of type "text/plain".
	 * @throws Exception
	 */
	// @GET
	// @Produces("text/plain")
	// public String hello() throws Exception {
	// logger.info("Hello Service");
	// User user = new User();
	// user.setUsername("sanj@gmail.com");
	// user.setPassword("hello123");
	//
	// //return Boolean.toString(new
	// AuthenticationDAOImpl().getUserSignInInfo(user));
	// return helloService.getHello();
	//
	// }

	@POST
	public String hello() throws JsonMappingException {
		logger.info("Hello Service");
		return "Hello Santosh";

	}
}
