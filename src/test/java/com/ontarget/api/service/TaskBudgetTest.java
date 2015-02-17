package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.TaskDTO;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 12/4/14.
 */
public class TaskBudgetTest extends BaseTest {

    private Logger logger = Logger.getLogger(TaskBudgetTest.class);

    @Autowired
    private TaskBudgetService taskBudgetService;


    @Test
    public void addTaskBudgetTest() {

        try {
            List<TaskEstimatedCost> costList = new ArrayList<>();

            int i = 1;

            TaskEstimatedCost estimatedCost = new TaskEstimatedCost();
            TaskDTO task = new TaskDTO();
            task.setProjectTaskId(1);
            estimatedCost.setTask(task);
            String string = "January 1, 2014";
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            estimatedCost.setFromDate(date);

            string = "January 30, 2014";
            Date endDate = format.parse(string);
            estimatedCost.setToDate(endDate);

            estimatedCost.setCostType("ESTIMATED");
            estimatedCost.setCost(23.4 + i);

            costList.add(estimatedCost);

            i++;

            TaskEstimatedCost actualCost = new TaskEstimatedCost();

            actualCost.setTask(task);
            string = "February 1, 2014";
            date = format.parse(string);
            actualCost.setFromDate(date);

            string = "February 28, 2014";
            endDate = format.parse(string);
            actualCost.setToDate(endDate);

            actualCost.setCostType("ACTUAL");
            actualCost.setCost(23.4 + i);

            costList.add(actualCost);

            boolean added = taskBudgetService.addTaskBudget(costList);

            Assert.assertTrue(added);
        } catch (Exception e) {
            logger.error("Error while adding budgets");
            fail();
        }

    }

    @Test
    public void updateTaskBudgetTest() {
        try {
            List<TaskEstimatedCost> costList = new ArrayList<>();

            int i = 1;

            TaskEstimatedCost estimatedCost = new TaskEstimatedCost();
            TaskDTO task = new TaskDTO();
            task.setProjectTaskId(1);
            estimatedCost.setTask(task);
            String string = "January 1, 2014";
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            estimatedCost.setFromDate(date);

            string = "January 30, 2014";
            Date endDate = format.parse(string);
            estimatedCost.setToDate(endDate);

            estimatedCost.setCostType("ESTIMATED");
            estimatedCost.setCost(23.4 + i);

            costList.add(estimatedCost);

            i++;

            TaskEstimatedCost actualCost = new TaskEstimatedCost();

            actualCost.setTask(task);
            string = "February 1, 2014";
            date = format.parse(string);
            actualCost.setFromDate(date);

            string = "February 28, 2014";
            endDate = format.parse(string);
            actualCost.setToDate(endDate);

            actualCost.setCostType("ACTUAL");
            actualCost.setCost(23.4 + i);

            costList.add(actualCost);

            boolean added = taskBudgetService.addTaskBudget(costList);

            Assert.assertTrue(added);


            TaskDTO task1 = taskBudgetService.getTaskBudgetByTask(1);

            Assert.assertTrue(task1.getCosts().size() > 0);

            boolean updated = taskBudgetService.updateTaskBudget(task1.getCosts());
            Assert.assertTrue(updated);


        } catch (Exception e) {
            logger.error("Error while getting budgets");
            fail();
        }
    }

    @Test
    public void getTaskBudgetTest() {
        try {
            List<TaskEstimatedCost> costList = new ArrayList<>();

            int i = 1;

            TaskEstimatedCost estimatedCost = new TaskEstimatedCost();
            TaskDTO task = new TaskDTO();
            task.setProjectTaskId(1);
            estimatedCost.setTask(task);
            String string = "January 1, 2014";
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            Date date = format.parse(string);
            estimatedCost.setFromDate(date);

            string = "January 30, 2014";
            Date endDate = format.parse(string);
            estimatedCost.setToDate(endDate);

            estimatedCost.setCostType("ESTIMATED");
            estimatedCost.setCost(23.4 + i);

            costList.add(estimatedCost);

            i++;

            TaskEstimatedCost actualCost = new TaskEstimatedCost();

            actualCost.setTask(task);
            string = "February 1, 2014";
            date = format.parse(string);
            actualCost.setFromDate(date);

            string = "February 28, 2014";
            endDate = format.parse(string);
            actualCost.setToDate(endDate);

            actualCost.setCostType("ACTUAL");
            actualCost.setCost(23.4 + i);

            costList.add(actualCost);

            boolean added = taskBudgetService.addTaskBudget(costList);

            Assert.assertTrue(added);


            TaskDTO task1 = taskBudgetService.getTaskBudgetByTask(1);

            Assert.assertTrue(task1.getCosts().size() > 0);


        } catch (Exception e) {
            logger.error("Error while getting budgets");
            fail();
        }

    }


}
