package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.TaskEndpoint;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.Task;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskListResponse;
import com.ontarget.dto.TaskRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
@Component
@Path("/task")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskEndpointImpl implements TaskEndpoint{

    private Logger logger = Logger.getLogger(TaskEndpointImpl.class);

    @Autowired
    private TaskService taskService;

    @Override
    @Path("/addTask")
    @POST
    public OnTargetResponse addTask(TaskRequest request) {
           OnTargetResponse response=new OnTargetResponse();
        try {
            if(taskService.addTaskService(request.getTask())){
                response.setReturnMessage("Successfully added task");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("Add task failed."+ e);
            response.setReturnMessage("Add task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }


    @Override
    @GET
    @Path("/project/{projectId}")
    public TaskListResponse getTask(@PathParam("projectId") int projectId){
        logger.info("Getting all tasks for project: "+ projectId);
        TaskListResponse response = new TaskListResponse();
        try {
            response.setTasks(taskService.getTask(projectId));
            response.setReturnMessage("Successfully retrieved tasks");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Add task failed."+ e);
            response.setReturnMessage("Add task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }

}
