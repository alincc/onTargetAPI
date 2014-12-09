package com.ontarget.api.rs.impl;

import com.ontarget.api.response.TaskPercentageListResponse;
import com.ontarget.api.response.TaskPercentageResponse;
import com.ontarget.api.rs.TaskPercentageEndpoint;
import com.ontarget.api.service.TaskPercentageService;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskPercentageRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/25/14.
 */
@Component
@Path("/task/percentage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskPercentageEndpointImpl implements TaskPercentageEndpoint {

    private Logger logger = Logger.getLogger(TaskPercentageEndpointImpl.class);

    @Autowired
    private TaskPercentageService taskPercentageService;

    @Override
    @POST
    @Path("/add")
    /**
     * Add task percentage complete
     */
    public OnTargetResponse addTaskPercentageComplete(TaskPercentageRequest request) {
        logger.info("Adding task Percentage");
        OnTargetResponse response = new OnTargetResponse();
        try {
            boolean added = taskPercentageService.addTaskPercentage(request.getTaskPercentageList());
            if(added){
                response.setReturnMessage("Successfully added task Percentages.");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("Error while adding task Percentages", e);
            response.setReturnMessage("Error  adding task Percentages.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @POST
    @Path("/update")
    /**
     * Update task percentage complete.
     */
    public OnTargetResponse updateTaskPercentageComplete(TaskPercentageRequest request) {
        logger.info("update task Percentage");
        OnTargetResponse response = new OnTargetResponse();
        try {
            boolean added = taskPercentageService.updateTaskPercentage(request.getTaskPercentageList());
            if(added){
                response.setReturnMessage("Successfully updated task Percentages.");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("Error while updating task Percentages", e);
            response.setReturnMessage("Error  updating task Percentages.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/{taskId}")
    /**
     * Get Task percentage by task
     */
    public TaskPercentageListResponse getTaskPercentagesByTask(@PathParam("taskId") int taskId){

        TaskPercentageListResponse response = new TaskPercentageListResponse();

        try {
            response.setTaskPercentageList(taskPercentageService.getTaskPercentageByTask(taskId));
            response.setReturnMessage("Successfully retrieved task percentage");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Error while retrieving task percentage", e);
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while retrieving task percentage");
        }

        return response;
    }

    @Override
    @Path("/project/{projectId}")
    @GET
    /**
     * Gets task percentage for all task for the project
     */
    public TaskPercentageResponse getTaskPercentageByProject(@PathParam("projectId") int projectId) {
        TaskPercentageResponse response=new TaskPercentageResponse();
        try {
            response.setTaskListMap(taskPercentageService.getTaskPercentageByProject(projectId));
            response.setReturnMessage("Successfully retrieved task percentage");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Error while retrieving task percentage", e);
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while retrieving task percentage");
        }
        return response;
    }


}
