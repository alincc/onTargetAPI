package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectBimFileElementTaskLinkEndpoint;
import com.ontarget.api.service.ProjectBimFileElementTaskLinkService;
import com.ontarget.entities.ProjectBimFileElementTaskLink;
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

    @Autowired
    ProjectBimFileElementTaskLinkService projectBimFileElementTaskLinkService;




    @Override
    @POST
    @Path("/save")
    public ProjectBimFileElementTaskLink linkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementTaskLink request) throws Exception {
        return projectBimFileElementTaskLinkService.save(request);
    }

    @Override
    @POST
    @Path("/unlink")
    public ProjectBimFileElementTaskLink unlinkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementTaskLink request) throws Exception {
        return  projectBimFileElementTaskLinkService.delete(request);

    }


}
