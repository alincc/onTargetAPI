package com.ontarget.api.rs;

import com.ontarget.dto.TaskMemberRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by sumit on 11/22/14.
 */
public class TaskTest extends JerseyTest {

    public TaskTest() throws TestContainerException {
        super("com.ontarget.api.rs");
    }

    @Test
    public void testUpdateTaskStatus() {
        WebResource resource = resource();
        ObjectMapper mapper = new ObjectMapper();
        String params = "{\"taskId\":\"1\",\"taskStatus\":\"A\"}";
        ClientResponse response = null;
        try {
            response = resource.path("/task/updateTaskStatus")
                    //.accept(MediaType.APPLICATION_JSON)
                    .type(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (response == null) {
            System.out.println("response if null..");
        } else if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

    }

    @Test
    public void testAddTaskMembers(){
        TaskMemberRequest taskMemberRequest = new TaskMemberRequest();
        taskMemberRequest.setProjectId(1);
        taskMemberRequest.setTaskId(1);
        taskMemberRequest.setMembers(new ArrayList<Long>(){{
            add(1L);
            add(2L);
        }});
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(taskMemberRequest));
            assert true;
        } catch (IOException e) {
            assert false;
        }
    }
}
