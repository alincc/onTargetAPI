package com.ontarget.api.service;

import com.ontarget.api.rs.BaseTest;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 8/28/15.
 */
public class BashScriptServiceTest extends BaseTest {


    private Logger logger = Logger.getLogger(BashScriptServiceTest.class);

    @Autowired
    private BashScriptService bashScriptService;


    @Test
    public void runBashScriptInRemoteServerTest() {

        try {
            boolean done  = bashScriptService.runBashScriptInRemoteServer("abcdefgh123456");
            Assert.assertTrue(done);


        }catch(Exception e){
            logger.error("Error while running bash script");
            fail();
        }

    }



}
