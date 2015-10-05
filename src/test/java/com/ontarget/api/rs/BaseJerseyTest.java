package com.ontarget.api.rs;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.ontarget.api.config.JerseyResourceInitializer;
import com.ontarget.api.filter.LoggingResponseFilter;
import com.ontarget.util.JsonDateSerializer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.log4j.Logger;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Date;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@TransactionConfiguration
@Transactional
public class BaseJerseyTest {

    protected Logger logger = Logger.getLogger(BaseJerseyTest.class);

    protected static String baseURI="http://localhost:8282/ontargetrs";

    protected  static HttpServer server;
    protected  static URI uri = UriBuilder.fromUri("http://localhost/ontargetrs/").port(8282).build();
    protected  static Client client = ClientBuilder.newClient();

    @BeforeClass
    public static void init() throws IOException{
        // create a new server listening at port 8080
        server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);

        // create a handler wrapping the JAX-RS application
        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new JerseyResourceInitializer(), HttpHandler.class);

        // map JAX-RS handler to the server root
        server.createContext(uri.getPath(), handler);

        // start the server
        server.start();

        // add client config
        client.register(MultiPartFeature.class);
        //log request and response
        client.register(new LoggingFilter());

    }


    @AfterClass
    public static void stop() {
        server.stop(0);
    }

    protected <T> String toJsonString(T obj, boolean format) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.INDENT_OUTPUT, format);
            SimpleModule simpleModule = new SimpleModule("SimpleModule", new Version(2, 0, 0, null));
            simpleModule.addSerializer(Date.class, new JsonDateSerializer());
            mapper.registerModule(simpleModule);
            String json = mapper.writeValueAsString(obj);
            return json;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }



}
