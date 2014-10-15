package com.ontarget.api.rs;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Owner on 10/13/14.
 */
public class HelloTest extends JerseyTest{


    public HelloTest(){
        super("com.ontarget.api.rs");
    }

    @Test
    public void testHello(){
        WebResource resource=resource();
        String msg = resource.path("/services/hello").get(String.class);

        Assert.assertEquals("This is OnTarget - Construction Management Tool.", msg);

    }

}
