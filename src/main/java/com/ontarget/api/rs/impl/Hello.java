package com.ontarget.api.rs.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * Example resource class hosted at the URI path "/hello"
 */
@Component
@Path("/hello")
public class Hello {

	private Logger logger = Logger.getLogger(Hello.class);

	@GET
	public String hello() {
		return "Welcome to OnTarget: Construction Management System";
	}
}
