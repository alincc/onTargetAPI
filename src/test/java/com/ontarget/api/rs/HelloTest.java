package com.ontarget.api.rs;

import com.ontarget.api.OnTargetBaseRSTest;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Owner on 10/13/14.
 */
public class HelloTest extends OnTargetBaseRSTest{


    public HelloTest() throws TestContainerException {
        super("com.ontarget.api.rs.HelloTest");
    }

    @Test
    public void testHello(){
        WebResource resource=resource();
        String msg = resource.path("/hello").get(String.class);
        Assert.assertEquals("Hi there, This is OnTarget - Construction Management Tool.", msg);

    }

}
