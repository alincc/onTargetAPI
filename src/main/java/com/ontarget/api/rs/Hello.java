
package com.ontarget.api.rs;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/** Example resource class hosted at the URI path "/hello"
 */
@Component
@Path("/hello")
public class Hello {
    
    /** Method processing HTTP GET requests, producing "text/plain" MIME media
     * type.
     * @return String that will be send back as a response of type "text/plain".
     */
    @GET 
    @Produces("text/plain")
    public String hello() {
        return "Hi there, This is OnTarget - Construction Management Tool.";
    }
}
