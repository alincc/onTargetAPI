package com.ontarget.api.rs.impl;

import com.ontarget.api.response.TaskBudgetListResponse;
import com.ontarget.api.response.TaskBudgetResponse;
import com.ontarget.api.rs.TaskBudgetEndpoint;
import com.ontarget.api.service.TaskBudgetService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskBudgetRequest;
import com.ontarget.dto.TaskListResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Owner on 11/22/14.
 */
@Component
@Path("/task/budget")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskBudgetEndpointImpl implements TaskBudgetEndpoint {

    private Logger logger = Logger.getLogger(TaskBudgetEndpointImpl.class);

    @Autowired
    private TaskBudgetService taskBudgetService;

    @Override
    @Path("/project/{projectId}")
    @GET
    /**
     * Get list of task estimated cost by project
     */
    public TaskBudgetResponse getTaskBudgetActualsAndEstimated(@PathParam("projectId") int projectId) {
        TaskBudgetResponse response = new TaskBudgetResponse();
        try {
            response.setTaskCosts(taskBudgetService.getTaskCostByMonthAndYear(projectId));
            response.setTaskIntervals(taskBudgetService.getTaskIntervals(projectId));
            response.setReturnMessage("Successfully retrieved Task budget");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Error while retrieving task budget", e);
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while retrieving task budget");
        }
        return response;
    }

    @Override
    @POST
    @Path("/add")
    /**
     * Add task budget (cost)
     */
    public OnTargetResponse addTaskBudget(TaskBudgetRequest request){
        logger.info("Adding task budget");
        OnTargetResponse response = new OnTargetResponse();

        try {
            boolean added = taskBudgetService.addTaskBudget(request.getCostList());
            if(added){
                response.setReturnMessage("Successfully added task budgets.");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("Error while adding task budgets", e);
            response.setReturnMessage("Error  adding task budgets.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @POST
    @Path("/update")
    /**
     * Update task budget (cost)
     */
    public OnTargetResponse updateTaskBudget(TaskBudgetRequest request){
        logger.info("updating task budget");
        OnTargetResponse response = new OnTargetResponse();

        try {
            boolean added = taskBudgetService.updateTaskBudget(request.getCostList());
            if(added){
                response.setReturnMessage("Successfully updated task budgets.");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("Error while updating task budgets", e);
            response.setReturnMessage("Error  updating task budgets.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/{taskId}")
    /**
     * Get task budget by task
     */
    public TaskBudgetListResponse getTaskBudgetByTaskId(@PathParam("taskId") int taskId){

        TaskBudgetListResponse response = new TaskBudgetListResponse();

        try {
            response.setCostList(taskBudgetService.getTaskBudgetByTask(taskId));
            response.setReturnMessage("Successfully retrieved task budget cost");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Error while retrieving task budget cost", e);
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while retrieving task budget cost");
        }

        return response;

    }


}