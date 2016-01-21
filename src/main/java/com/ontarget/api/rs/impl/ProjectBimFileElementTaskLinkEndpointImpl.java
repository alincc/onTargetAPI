package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectBimFileElementTaskLinkEndpoint;
import com.ontarget.api.service.ProjectBimFileElementTaskLinkService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.ProjectBimFileElementToTaskLinkRequest;
import com.ontarget.response.bean.ProjectBimFileElementTaskLinkResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by TRON on 1/19/2016.
 */

@Component
@Path("/bim/link")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectBimFileElementTaskLinkEndpointImpl  implements ProjectBimFileElementTaskLinkEndpoint {

    private Logger logger = Logger.getLogger(ProjectBimFileElementTaskLinkEndpointImpl.class);

    @Autowired
    ProjectBimFileElementTaskLinkService projectBimFileElementTaskLinkService;

    @Override
    @POST
    @Path("/add")
    public ProjectBimFileElementTaskLinkResponse linkProjectBinFileElementTaskLink(ProjectBimFileElementToTaskLinkRequest request) {
        logger.debug("linking bim element: "+ request.getBimFileElementId() + " with task: "+ request.getTaskId());
        ProjectBimFileElementTaskLinkResponse response = new ProjectBimFileElementTaskLinkResponse();
        try {
            response = projectBimFileElementTaskLinkService.save(request);
            response.setReturnMessage("Successfully linked task to bim element.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Error while linking bim element to task",e);
            response.setReturnMessage("Error while  linking task to bim element.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }


    @Override
    @POST
    @Path("/delete")
    public OnTargetResponse unlinkProjectBinFileElementTaskLink(ProjectBimFileElementToTaskLinkRequest request) {
        logger.debug("Unlinking bim element: "+ request.getBimFileElementId() + " with task: "+ request.getTaskId());
        OnTargetResponse response = new OnTargetResponse();
        try {
            response = projectBimFileElementTaskLinkService.delete(request);
            response.setReturnMessage("Successfully unlinked task to bim element.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Error while unlinking bim element to task",e);
            response.setReturnMessage("Error while  unlinking task to bim element.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }

    @Override
    @POST
    @Path("/get")
    public ProjectBimFileElementTaskLinkResponse getProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request) {
        logger.debug("getting bim element: "+ request.getBimFileId() + " with task: "+ request.getBimFileElementId());

        ProjectBimFileElementTaskLinkResponse response;
        try {
            response = projectBimFileElementTaskLinkService.get(request);
            response.setReturnMessage("Error while getting task linked to bim element");
            response.setReturnVal(OnTargetConstant.ERROR);
        } catch (Exception e) {
            logger.error("Error while getting task linked to bim element",e);
            response =  new ProjectBimFileElementTaskLinkResponse();
            response.setReturnMessage("Error while getting task linked to bim element");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }
}
