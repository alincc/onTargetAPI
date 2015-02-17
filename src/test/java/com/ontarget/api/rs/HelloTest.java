package com.ontarget.api.rs;

import com.ontarget.api.OnTargetBaseRSTest;
import com.ontarget.bean.TaskDTO;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

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


    public static void main(String[] args) {
        Map<TaskDTO,Map<TaskInterval,List<TaskEstimatedCost>>> taskMapMap = new LinkedHashMap<>();

        TaskDTO task = new TaskDTO();
        task.setProjectTaskId(1);
        task.setTitle("test");
        task.setDescription("description");

        TaskEstimatedCost taskEstimatedCost = new TaskEstimatedCost();
        taskEstimatedCost.setCost(20.0);
        taskEstimatedCost.setCostType("ACTUAL");

        TaskEstimatedCost taskEstimatedCost1 = new TaskEstimatedCost();
        taskEstimatedCost1.setCost(20.0);
        taskEstimatedCost1.setCostType("PLANNED");

        List<TaskEstimatedCost> costs = new ArrayList<>();
        costs.add(taskEstimatedCost);
        costs.add(taskEstimatedCost1);

        Map<TaskInterval,List<TaskEstimatedCost>> taskIntervalListMap=new HashMap<>();

        taskIntervalListMap.put(new TaskInterval(11,2014), costs);

        taskMapMap.put(task,taskIntervalListMap);

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(taskMapMap));
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

}
