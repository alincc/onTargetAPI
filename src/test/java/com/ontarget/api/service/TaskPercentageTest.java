package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskPercentage;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 12/4/14.
 */
public class TaskPercentageTest extends BaseTest{

    private Logger logger = Logger.getLogger(TaskPercentageTest.class);

    @Autowired
    private TaskPercentageService taskPercentageService;

    @Test
    public void addTaskPercentageTest(){

        try {
            List<TaskPercentage> taskPercentageList = new ArrayList<>();

            int i = 1;

            TaskPercentage percentage1 = new TaskPercentage();
            Task task = new Task();
            task.setProjectTaskId(1);
            percentage1.setTask(task);
            String string = "January 1, 2014";
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            percentage1.setFromDate(date);

            string = "January 15, 2014";
            Date endDate = format.parse(string);
            percentage1.setToDate(endDate);

            percentage1.setTaskPercentageType("PERCENTAGE");
            percentage1.setTaskPercentageComplete(20.0 + i);

            taskPercentageList.add(percentage1);

            i++;

            TaskPercentage percentage2 = new TaskPercentage();

            percentage2.setTask(task);
            string = "January 16, 2014";
            date = format.parse(string);
            percentage2.setFromDate(date);

            string = "January 28, 2014";
            endDate = format.parse(string);
            percentage2.setToDate(endDate);

            percentage2.setTaskPercentageType("PERCENTAGE");
            percentage2.setTaskPercentageComplete(20.0 + i);

            taskPercentageList.add(percentage2);

            boolean added = taskPercentageService.addTaskPercentage(taskPercentageList);

            Assert.assertTrue(added);
        } catch (Exception e) {
            logger.error("Error while adding budgets");
            fail();
        }



    }


    @Test
    public void updateTaskPercentageTest(){
        try {
            List<TaskPercentage> taskPercentageList = new ArrayList<>();

            int i = 1;

            TaskPercentage percentage1 = new TaskPercentage();
            Task task = new Task();
            task.setProjectTaskId(1);
            percentage1.setTask(task);
            String string = "January 1, 2014";
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            percentage1.setFromDate(date);

            string = "January 30, 2014";
            Date endDate = format.parse(string);
            percentage1.setToDate(endDate);

            percentage1.setTaskPercentageType("PERCENTAGE");
            percentage1.setTaskPercentageComplete(20.0 + i);

            taskPercentageList.add(percentage1);

            i++;

            TaskPercentage percentage2 = new TaskPercentage();

            percentage2.setTask(task);
            string = "February 1, 2014";
            date = format.parse(string);
            percentage2.setFromDate(date);

            string = "February 28, 2014";
            endDate = format.parse(string);
            percentage2.setToDate(endDate);

            percentage2.setTaskPercentageType("PERCENTAGE");
            percentage2.setTaskPercentageComplete(20.0 + i);

            taskPercentageList.add(percentage2);

            boolean added = taskPercentageService.addTaskPercentage(taskPercentageList);

            Assert.assertTrue(added);


            List<TaskPercentage> taskPercentageList1 = taskPercentageService.getTaskPercentageByTask(1);

            Assert.assertTrue(taskPercentageList1.size() > 0);


            boolean updated=taskPercentageService.updateTaskPercentage(taskPercentageList1);

            Assert.assertTrue(updated);

        } catch (Exception e) {
            logger.error("Error while adding budgets");
            fail();
        }
    }

    @Test
    public void getTaskPercentageTest(){

        try {
            List<TaskPercentage> taskPercentageList = new ArrayList<>();

            int i = 1;

            TaskPercentage percentage1 = new TaskPercentage();
            Task task = new Task();
            task.setProjectTaskId(1);
            percentage1.setTask(task);
            String string = "January 1, 2014";
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            percentage1.setFromDate(date);

            string = "January 30, 2014";
            Date endDate = format.parse(string);
            percentage1.setToDate(endDate);

            percentage1.setTaskPercentageType("PERCENTAGE");
            percentage1.setTaskPercentageComplete(20.0 + i);

            taskPercentageList.add(percentage1);

            i++;

            TaskPercentage percentage2 = new TaskPercentage();

            percentage2.setTask(task);
            string = "February 1, 2014";
            date = format.parse(string);
            percentage2.setFromDate(date);

            string = "February 28, 2014";
            endDate = format.parse(string);
            percentage2.setToDate(endDate);

            percentage2.setTaskPercentageType("PERCENTAGE");
            percentage2.setTaskPercentageComplete(20.0 + i);

            taskPercentageList.add(percentage2);

            boolean added = taskPercentageService.addTaskPercentage(taskPercentageList);

            Assert.assertTrue(added);


            List<TaskPercentage> taskPercentageList1 = taskPercentageService.getTaskPercentageByTask(1);

            Assert.assertTrue(taskPercentageList1.size() > 0);


        } catch (Exception e) {
            logger.error("Error while adding budgets");
            fail();
        }
    }

}
