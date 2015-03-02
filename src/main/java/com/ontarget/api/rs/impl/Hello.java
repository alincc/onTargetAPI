package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.service.HelloService;

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

	@GET
	public String hello() throws JsonMappingException {
		logger.info("Hello Service");
		System.out.println("Service:: " + helloService.getHello());
		return "Hello Santosh";

	}
}
