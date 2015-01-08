package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectEndoint;
import com.ontarget.api.service.ProjectService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
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

    @Autowired
    private UserProfileService userProfileService;

    @Override
    @POST
    @Path("/addProject")
    public OnTargetResponse addProject(ProjectRequest request) {
        OnTargetResponse response = null;
        try {
            if (request.getProject().getProjectId() <= 0) {
                response = projectService.addProject(request);
            } else {
                response = projectService.updateProject(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while adding project", e);
            response = new OnTargetResponse();
            response.setReturnMessage("Error while creating project");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/{projectId}")
    public ProjectResponse getProjectDetail(@PathParam("projectId") int projectId) {
        ProjectResponse response = new ProjectResponse();
        try {
            response = projectService.getProjectDetail(projectId);
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully retrieved project info");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while getting project", e);
            response.setReturnMessage("Error while getting project");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/getProjectMembers")
    public ProjectMemberListResponse getProjectMembers(@QueryParam("projectId") long projectId) {
//        System.out.println("project id " + projectId);
        ProjectMemberListResponse response = new ProjectMemberListResponse();
        try {
            response = projectService.getProjectMembers(projectId);
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
    @GET
    @Path("/getProject/company/{companyId}/user/{userId}")
    public ProjectListResponse getProjectByCompany(@PathParam("companyId") int companyId, @PathParam("userId") int userId) {
        ProjectListResponse response = new ProjectListResponse();
        try {
            response = projectService.getProjectsByCompany(companyId, userId);
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully retrieved project info");
        } catch (Exception e) {
            logger.error("Error while getting project by company", e);
            response.setReturnMessage("Error while getting project by company");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }

    @Override
    @GET
    @Path("/getProject/user/{userId}")
    public ProjectListResponse getProjectByUser(@PathParam("userId") int userId) {

        ProjectListResponse response = new ProjectListResponse();
        try {
            response = projectService.getProjectsByUser(userId);
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully retrieved project info");
        } catch (Exception e) {
            logger.error("Error while getting project by company", e);
            response.setReturnMessage("Error while getting project by company");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }


}
