package com.ontarget.api.rs.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.ProjectFileTagging;
import com.ontarget.api.service.ProjectFileTaggingService;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddProjectFileTagRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.response.bean.ProjectFileTagResponse;

@Component
@Path("/project/file/tag")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectFileTaggingImpl implements ProjectFileTagging {
	private Logger logger = Logger.getLogger(ProjectFileTaggingImpl.class);
	@Autowired
	private ProjectFileTaggingService projectFileTaggingService;

	@Override
	@POST
	@Path("/save")
	public OnTargetResponse save(AddProjectFileTagRequest request) {
		logger.debug("Saving project file tags: " + request.getTags());
		OnTargetResponse response = new OnTargetResponse();
		try {
			return projectFileTaggingService.save(request.getTags(), request.getBaseRequest().getLoggedInUserId());
		} catch (Exception e) {
			logger.error(e);
			response.setReturnMessage(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/get")
	public ProjectFileTagResponse getProjectFileTags(GetProjectFileTagRequest request) {
		logger.debug("Getting project file tags for file id: " + request.getProjectFileId());
		ProjectFileTagResponse response = new ProjectFileTagResponse();
		try {
			List<ProjectFileTagBean> projectFileTags = projectFileTaggingService.getProjectFileTags(request);
			response.setTags(projectFileTags);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved project file tags");
		} catch (Exception e) {
			logger.error(e);
			response.setReturnMessage(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
