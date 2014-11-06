package com.ontarget.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.After;
import org.junit.Before;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

/**
 * Created by Owner on 11/6/14.
 */
public class OnTargetBaseRSTest{

    private static JerseyTest jerseyTest;


    @Before
    public void init(){
        jerseyTest = new JerseyTest( new WebAppDescriptor.Builder(
                "com.ontarget.api.rs" ).contextPath( "rest" )
                .contextParam(
                        "contextConfigLocation", "classpath:applicationContext.xml" )
                .servletClass( SpringServlet.class )
                .contextListenerClass( ContextLoaderListener.class )
                .requestListenerClass( RequestContextListener.class )
                .build() ) {
        };
    }

    public WebResource resource() {
        return jerseyTest.resource();
    }

    public Client client() {
        return jerseyTest.client();
    }

    @After
    public void destroy() throws Exception{
        jerseyTest.tearDown();
    }

}
