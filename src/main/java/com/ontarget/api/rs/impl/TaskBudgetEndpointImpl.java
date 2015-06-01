package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.response.TaskBudgetListResponse;
import com.ontarget.api.response.TaskBudgetResponse;
import com.ontarget.api.rs.TaskBudgetEndpoint;
import com.ontarget.api.service.TaskBudgetService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskBudgetRequest;
import com.ontarget.exception.NoTaskFoundException;
import com.ontarget.request.bean.TaskBudget;
import com.ontarget.request.bean.TaskBudgetEstimationOfProject;
import com.ontarget.request.bean.TaskBudgetOfTask;
import com.ontarget.util.ConvertPOJOUtils;

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
	@Path("getTaskBudgetEstimationOfProject")
	@POST
	public TaskBudgetResponse getTaskBudgetActualsAndEstimated(TaskBudgetEstimationOfProject taskBudgetEstimationOfProject) {
		TaskBudgetResponse response = new TaskBudgetResponse();
		try {
			int projectId = taskBudgetEstimationOfProject.getProjectId();
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
	public OnTargetResponse addTaskBudget(TaskBudget taskBudget) {
		logger.info("Adding task budget");
		OnTargetResponse response = new OnTargetResponse();

		try {

			TaskBudgetRequest taskBudgetRequest = ConvertPOJOUtils.convertToTaskBudgetRequest(taskBudget);

			boolean added = taskBudgetService.addTaskBudget(taskBudgetRequest.getCostList());
			if (added) {
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

	// this service is not use/ handles update by add end point
	@Override
	@POST
	@Path("/update")
	public OnTargetResponse updateTaskBudget(TaskBudget taskBudget) {
		logger.info("updating task budget");
		OnTargetResponse response = new OnTargetResponse();

		try {
			TaskBudgetRequest taskBudgetRequest = ConvertPOJOUtils.convertToTaskBudgetRequest(taskBudget);

			boolean added = taskBudgetService.updateTaskBudget(taskBudgetRequest.getCostList());
			if (added) {
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
	@POST
	@Path("/getTaskBudgetByTaskId")
	public TaskBudgetListResponse getTaskBudgetByTaskId(TaskBudgetOfTask taskBudgetOfTask) {

		TaskBudgetListResponse response = new TaskBudgetListResponse();

		int taskId = taskBudgetOfTask.getTaskId();
		try {
			response.setTask(taskBudgetService.getTaskBudgetByTaskAndMonthYear(taskId));
			response.setReturnMessage("Successfully retrieved task budget cost");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (NoTaskFoundException e) {
			logger.error("No Task found with id " + taskId, e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("No task found with id " + taskId);
		} catch (Exception e) {
			logger.error("Error while retrieving task budget cost", e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while retrieving task budget cost");
		}
		return response;
	}

}