package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectBimFileElementTaskLinkEndpoint;
import com.ontarget.api.service.ProjectBimFileElementTaskLinkService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectBimFileDTO;
import com.ontarget.entities.ProjectBimFileElementTaskLink;
import com.ontarget.request.bean.ProjectBimFileElementToTaskLinkRequest;
import com.ontarget.response.bean.ProjectBimFileElementTaskLinkResponse;
import com.ontarget.response.bean.SaveBIMResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.ontarget.dto.ProjectBimFileElementTaskLinkDTO;

/**
 * Created by TRON on 1/19/2016.
 */

@Component
@Path("/bim/link")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectBimFileElementTaskLinkEndpointImpl  implements ProjectBimFileElementTaskLinkEndpoint {

    @Autowired
    ProjectBimFileElementTaskLinkService projectBimFileElementTaskLinkService;

    @Override
    public ProjectBimFileElementTaskLinkResponse linkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request) {

        ProjectBimFileElementTaskLinkResponse response = new ProjectBimFileElementTaskLinkResponse();
        try {
            ProjectBimFileElementToTaskLinkRequest projectBimFileElementTaskLink = projectBimFileElementTaskLinkService.save(request);

        } catch (Exception e) {

        }

        return null;
    }

    @Override
    public OnTargetResponse unlinkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request) {
        return null;
    }
}
