package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectEndpoint;
import com.ontarget.api.service.ProjectService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectRequest;
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
public class ProjectEndpointImpl implements ProjectEndpoint {

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
}
