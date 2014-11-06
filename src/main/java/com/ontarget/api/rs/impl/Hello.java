package com.ontarget.api.rs.impl;

import com.ontarget.api.service.HelloService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Example resource class hosted at the URI path "/hello"
 */
@Component
@Path("/hello")
public class Hello {

    private Logger logger = Logger.getLogger(Hello.class);


    @Autowired
    private HelloService helloService;


    /**
     * Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     *
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET
    @Produces("text/plain")
    public String hello() {
        logger.info("Hello Service");
        return helloService.getHello();
    }
}
