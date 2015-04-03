package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.response.TaskPercentageListResponse;
import com.ontarget.api.response.TaskPercentageResponse;
import com.ontarget.api.rs.TaskPercentageEndpoint;
import com.ontarget.api.service.TaskPercentageService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddTaskProgress;
import com.ontarget.request.bean.TaskPercentageOfProject;
import com.ontarget.request.bean.TaskPercentageOfTask;
import com.ontarget.request.bean.UpdateTaskProgress;

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
	public OnTargetResponse addTaskPercentageComplete(AddTaskProgress addTaskProgress) {
		logger.info("Adding task Percentage");
		OnTargetResponse response = new OnTargetResponse();

		try {
			boolean added = taskPercentageService.addTaskPercentage(addTaskProgress.getTaskProgressList(), addTaskProgress
					.getBaseRequest().getLoggedInUserId());
			if (added) {
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
	public OnTargetResponse updateTaskPercentageComplete(UpdateTaskProgress request) {
		logger.info("update task Percentage");
		OnTargetResponse response = new OnTargetResponse();

		try {
			boolean added = taskPercentageService.updateTaskPercentage(request.getTaskProgressList(), request.getBaseRequest()
					.getLoggedInUserId());
			if (added) {
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
	@POST
	@Path("/getPercentageCompleteOfTask")
	public TaskPercentageListResponse getTaskPercentagesByTask(TaskPercentageOfTask taskPercentageOfTask) {

		TaskPercentageListResponse response = new TaskPercentageListResponse();

		try {
			response.setTaskPercentageList(taskPercentageService.getTaskPercentageByTask(taskPercentageOfTask.getTaskId()));
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
	@Path("/getTaskPercentageByProject")
	@POST
	public TaskPercentageResponse getTaskPercentageByProject(TaskPercentageOfProject taskPercentageOfProject) {
		TaskPercentageResponse response = new TaskPercentageResponse();
		try {
			response.setTaskListMap(taskPercentageService.getTaskPercentageByProject(taskPercentageOfProject.getProjectId()));
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
