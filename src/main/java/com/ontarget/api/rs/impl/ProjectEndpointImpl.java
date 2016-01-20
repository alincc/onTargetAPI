package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectEndoint;
import com.ontarget.api.service.ProjectService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.*;
import com.ontarget.request.bean.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Owner on 11/6/14.
 */
@Component
@Path("/project")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectEndpointImpl implements ProjectEndoint {

	private Logger logger = Logger.getLogger(ProjectEndpointImpl.class);

	@Autowired
	private ProjectService projectService;

	@Override
	@POST
	@Path("/addProject")
	public com.ontarget.response.bean.ProjectResponse addProject(ProjectRequest request) {
        com.ontarget.response.bean.ProjectResponse response = new com.ontarget.response.bean.ProjectResponse();
		if (request.getProject().getProjectId() == null) {
			try {
				response = projectService.addProject(request);
			} catch (Exception e) {
				logger.error("Error while adding project", e);
				response = new com.ontarget.response.bean.ProjectResponse();
				response.setReturnMessage("Error while creating project");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} else {
			try {
				response = projectService.updateProject(request);
			} catch (Exception e) {
				logger.error("Error while updating project", e);
				response.setReturnMessage("Error while updating project");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		}
		return response;
	}

	@Override
	@POST
	@Path("/addActivity")
	public OnTargetResponse addActivity(ActivityRequest request) {
		OnTargetResponse response = null;
		if (request.getProject().getProjectId() == null) {
			try {
				response = projectService.addActivity(request);
			} catch (Exception e) {
				logger.error("Error while adding activity", e);
				response = new OnTargetResponse();
				response.setReturnMessage("Error while creating activity");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} else {
			try {
				response = projectService.updateActivity(request);
			} catch (Exception e) {
				logger.error("Error while updating activity", e);
				response = new OnTargetResponse();
				response.setReturnMessage("Error while updating activity");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		}
		return response;
	}

	@Override
	@POST
	@Path("/getProject")
	public com.ontarget.response.bean.ProjectResponse getProjectDetail(ProjectDetailRequest projectDetailRequest) {
		com.ontarget.response.bean.ProjectResponse response = new com.ontarget.response.bean.ProjectResponse();
		try {
			response = projectService.getProjectDetail(projectDetailRequest.getProjectId());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved project info");
			response.setAuthenticated(true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error while getting project", e);
			response.setReturnMessage("Error while getting project");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}


    @Override
    @POST
    @Path("/arn/add")
    public com.ontarget.response.bean.ProjectResponse updateProjectTopicArn(ProjectArnRequest projectArnRequest) {
        com.ontarget.response.bean.ProjectResponse response = new com.ontarget.response.bean.ProjectResponse();
        try {
            response = projectService.updateProjectArn(projectArnRequest.getProjectArn(),projectArnRequest.getBaseRequest().getLoggedInUserProjectId());
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully updated project arn");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while getting project", e);
            response.setReturnMessage("Error while getting project");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }






	@Override
	@POST
	@Path("/getProjectMembers")
	public ProjectMemberListResponse getProjectMembers(ProjectDetailRequest projectDetailRequest) {
		ProjectMemberListResponse response = new ProjectMemberListResponse();
		try {
			response = projectService.getProjectMembers(projectDetailRequest.getProjectId());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved project members");

		} catch (Exception e) {
			logger.error("Error while reading project members", e);
			response.setReturnMessage("Error while getting project members");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/getCompanyByProject")
	public CompanyListResponse getCompanyByProject(ProjectDetailRequest projectDetailRequest) {
		CompanyListResponse response = new CompanyListResponse();
		try {
			response.setCompanyList(projectService.getCompanyByProject(projectDetailRequest.getProjectId()));
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved company by project");
		} catch (Exception e) {
			logger.error("Error while getting company by project", e);
			response.setReturnMessage("Error while getting company by project");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/getProjectsByUser")
	public ProjectListResponse getProjectByUser(ProjectUserRequest projectUserRequest) {
		logger.info("Getting project detail list of user id: " + projectUserRequest.getUserId());

		ProjectListResponse response = new ProjectListResponse();
		try {
			response = projectService.getUserProjectDetails(projectUserRequest.getUserId());
			if (response.getResponseCode().equalsIgnoreCase("SUCC")) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Successfully retrieved project info");
			} else {
				response = new ProjectListResponse();
				response.setReturnMessage("User not assigned to main project");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			logger.error("Error while getting project by user", e);
			response.setReturnMessage("Error while getting project by user");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/deleteProject")
	public ProjectResponse deleteProject(ProjectDetailRequest projectDetailRequest) {
		ProjectResponse response = new ProjectResponse();
		try {
			boolean deleted = projectService.deleteProject(projectDetailRequest.getProjectId(), projectDetailRequest.getBaseRequest()
					.getLoggedInUserId());
			if (deleted) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Successfully deleted project");
			} else {
				response.setReturnMessage("Error while deleting project");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			logger.error("Error while getting project", e);
			response.setReturnMessage("Error while deleting project");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

    @Override
    @POST
    @Path("/getUserProjectList")
    public ProjectListResponse getUserProjectList(ProjectUserRequest projectUserRequest) {
        logger.info("Getting project list of user id: " + projectUserRequest.getUserId());
        ProjectListResponse response = new ProjectListResponse();
        try {
            response = projectService.getUserProjectListV1(projectUserRequest.getUserId());
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully retrieved projects assigned to user");
        } catch (Exception e) {
            logger.error("Error while getting projects assigned to user", e);
            response.setReturnMessage("Error while getting projects assigned to user");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }

	@Override
	@POST
	@Path("/getActivityOfProject")
	public com.ontarget.response.bean.ProjectListResponse getActivityOfProject(ProjectDetailRequest projectDetailRequest) {
		com.ontarget.response.bean.ProjectListResponse response = new com.ontarget.response.bean.ProjectListResponse();
		try {
			response = projectService.getActivityOfProject(projectDetailRequest.getProjectId());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved project activities");
		} catch (Exception e) {
			logger.error("Error while getting project activities", e);
			response.setReturnMessage("Error while getting project activities");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}




}
