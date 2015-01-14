package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 12/27/14.
 */
public class TaskServiceTest extends BaseTest{

    private Logger logger = Logger.getLogger(TaskServiceTest.class);

    @Autowired
    private TaskService taskService;

    @Test
    public void assignTaskToUserTest(){

        try {
            boolean assigned = taskService.assignTaskToUser(1,1, 1);
            Assert.assertTrue(assigned);
        } catch (Exception e) {
           logger.error(e);
            fail();
        }


    }


}
