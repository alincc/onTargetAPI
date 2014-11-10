package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectEndoint;
import com.ontarget.api.service.ProjectService;
import com.ontarget.bean.Company;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectRequest;
import com.ontarget.dto.ProjectResponse;
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

    @Override
    @POST
    @Path("/addProject")
    public OnTargetResponse addProject(ProjectRequest request) {
        OnTargetResponse response=null;
        try {
            response= projectService.addProject(request);
        } catch (Exception e) {
            logger.error("Error while adding project",e);
            response=new OnTargetResponse();
            response.setReturnMessage("Error while creating project");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }

    @Override
    @GET
    @Path("/getProjectDetail")
    public ProjectResponse getProjectDetail(ProjectRequest request) {
        ProjectResponse response=new ProjectResponse();
        try {
            response = projectService.getProjectDetail(request.getProject().getProjectId());
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully retrieved project info");
        } catch (Exception e) {
            logger.error("Error while getting project",e);
            response.setReturnMessage("Error while getting project");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/getProjectForCompany")
    public ProjectListResponse getProjectByCompany(Company company, User user) {

        ProjectListResponse response= null;
        try {
            response = projectService.getProjectsByCompany(company,user);
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully retrieved project info");
        } catch (Exception e) {
            logger.error("Error while getting project by company",e);
            response.setReturnMessage("Error while getting project by company");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }


}
