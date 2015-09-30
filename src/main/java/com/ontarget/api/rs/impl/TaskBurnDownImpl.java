package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.TaskBurnDown;
import com.ontarget.api.service.TaskBurnDownService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.request.bean.ProjectDetailRequest;
import com.ontarget.response.bean.TaskBurnDownListResponse;

@Component
@Path("/taskBurnDown")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskBurnDownImpl implements TaskBurnDown {
	private Logger logger = Logger.getLogger(TaskBurnDownImpl.class);

	@Autowired
	private TaskBurnDownService taskBurnDownService;

	@Override
	@POST
	@Path("/project")
	public TaskBurnDownListResponse getTaskBurnDownOfProject(ProjectDetailRequest request) {
		TaskBurnDownListResponse response = null;
		logger.debug("getting task burn down of project");
		try {
			return taskBurnDownService.getTaskBurnDownOfProject(request.getProjectId());
		} catch (Exception e) {
			logger.error("Error while retrieving task burn down of project", e);
			response = new TaskBurnDownListResponse();
			response.setReturnMessage("Error while retrieving task burn down of project");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}
}
