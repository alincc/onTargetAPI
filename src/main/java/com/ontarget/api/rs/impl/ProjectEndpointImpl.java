package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.ProjectEndoint;
import com.ontarget.api.service.ProjectService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.CompanyListResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectMemberListResponse;
import com.ontarget.dto.ProjectResponse;
import com.ontarget.request.bean.ProjectCompanyRequest;
import com.ontarget.request.bean.ProjectDetailRequest;
import com.ontarget.request.bean.ProjectRequest;
import com.ontarget.request.bean.ProjectUserRequest;

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
        if (request.getProject().getProjectId() == null) {
            try {
                response = projectService.addProject(request);
            } catch (Exception e) {
                logger.error("Error while adding project", e);
                response = new OnTargetResponse();
                response.setReturnMessage("Error while creating project");
                response.setReturnVal(OnTargetConstant.ERROR);
            }
        } else {
            try {
                response = projectService.updateProject(request);
            } catch (Exception e) {
                logger.error("Error while updating project", e);
                response = new OnTargetResponse();
                response.setReturnMessage("Error while updating project");
                response.setReturnVal(OnTargetConstant.ERROR);
            }
        }
        return response;
    }

    @Override
    @POST
    @Path("/getProject")
    public ProjectResponse getProjectDetail(
            ProjectDetailRequest projectDetailRequest) {
        ProjectResponse response = new ProjectResponse();
        try {
            response = projectService.getProjectDetail(projectDetailRequest
                    .getProjectId());
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
    @POST
    @Path("/getProjectMembers")
    public ProjectMemberListResponse getProjectMembers(
            ProjectDetailRequest projectDetailRequest) {
        ProjectMemberListResponse response = new ProjectMemberListResponse();
        try {
            response = projectService.getProjectMembers(projectDetailRequest
                    .getProjectId());
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
    @Path("/getProjectsByCompany")
    public ProjectListResponse getProjectByCompany(
            ProjectCompanyRequest projectCompanyRequest) {
        ProjectListResponse response = new ProjectListResponse();
        try {
            response = projectService.getProjectsByCompany(
                    projectCompanyRequest.getCompanyId(),
                    projectCompanyRequest.getProjectId());
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
    @POST
    @Path("/getCompanyByProject")
    public CompanyListResponse getCompanyByProject(
            ProjectDetailRequest projectDetailRequest) {
        CompanyListResponse response = new CompanyListResponse();
        try {
            response.setCompanyList(projectService
                    .getCompanyByProject(projectDetailRequest.getProjectId()));
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully retrieved company by project");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error while getting company by project", e);
            response.setReturnMessage("Error while getting company by project");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @POST
    @Path("/getProjectsByUser")
    public ProjectListResponse getProjectByUser(
            ProjectUserRequest projectUserRequest) {

        ProjectListResponse response = new ProjectListResponse();
        try {
            response = projectService.getProjectsByUser(projectUserRequest
                    .getUserId());
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
