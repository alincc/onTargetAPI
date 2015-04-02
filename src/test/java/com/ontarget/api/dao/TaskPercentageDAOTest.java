//package com.ontarget.api.dao;
//
//import com.ontarget.api.BaseTest;
//import com.ontarget.bean.TaskPercentage;
//import org.apache.log4j.Logger;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static junit.framework.Assert.fail;
//
///**
// * Created by Owner on 2/18/15.
// */
//public class TaskPercentageDAOTest extends BaseTest {
//
//    private Logger logger = Logger.getLogger(TaskPercentageDAOTest.class);
//
//
//    @Autowired
//    TaskPercentageDAO taskPercentageDAO;
//
//
//    @Test
//    public void testGetExistingTaskPercentage() {
//
//        try {
//            TaskPercentage tp = taskPercentageDAO.getExistingTaskPercentageForTheMonth(7);
//            Assert.assertTrue(tp!=null);
//        } catch (Exception e) {
//            logger.error("Error while getting task percentage",e);
//            fail();
//
//        }
//
//    }
//
//
//}
