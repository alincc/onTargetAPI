package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectBIMFileEndpoint;
import com.ontarget.api.service.ProjectBIMFileService;
import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.GetBIMRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import com.ontarget.request.bean.UpdateBIMThumbnailPathRequest;
import com.ontarget.response.bean.GetBIMResponse;
import com.ontarget.response.bean.SaveBIMResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Component
@Path("/bim")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectBIMFileEndpointImpl implements ProjectBIMFileEndpoint {

    private Logger logger = Logger.getLogger(ProjectBIMFileEndpointImpl.class);

    @Autowired
    private ProjectBIMFileService projectBIMFileService;

    @Override
    @POST
    @Path("/getAll")
    public GetBIMResponse getBIMPoids(GetBIMRequest request) {
        logger.debug("Getting BIM projects for project: "+ request.getProjectid());
        GetBIMResponse response = null;
        try {
            response = projectBIMFileService.getBIMPoids(request.getProjectid());
        } catch (Exception e) {
            logger.error("Error while getting poids: ",e);
            response=new GetBIMResponse();
            response.setReturnVal("false");
            response.setReturnMessage("Error while fetching BIM files.");

        }
        return response;
    }

    @Override
    @POST
    @Path("/save")
    public SaveBIMResponse saveProjectBIMPoids(SaveBIMRequest request) {
        logger.debug("Saving BIM projects for project: "+ request.getProjectid());
        SaveBIMResponse response = new SaveBIMResponse();
        try {
            Boolean saved = projectBIMFileService.saveProjectBIMFile(request);
            if(saved){
                response.setReturnVal("true");
                response.setReturnMessage("Successfully saved bim poid.");
            }
        } catch (Exception e) {
            logger.error("Error while saving bim poid: ",e);
            response.setReturnVal("false");
            response.setReturnMessage("Error while saving BIM files.");

        }
        return response;
    }


    @Override
    @POST
    @Path("/delete")
    public SaveBIMResponse deleteProjectBIMPoids(DeleteBIMRequest request) {
        logger.debug("Saving BIM projects for project bim file id: "+ request.getProjectBimFileId());
        SaveBIMResponse response = new SaveBIMResponse();
        try {
            Boolean saved = projectBIMFileService.deleteProjectBIMFile(request);
            if(saved){
                response.setReturnVal("true");
                response.setReturnMessage("Successfully deleted bim poid.");
            }
        } catch (Exception e) {
            logger.error("Error while deleted bim poid: ",e);
            response.setReturnVal("false");
            response.setReturnMessage("Error while deleted BIM files.");

        }
        return response;
    }


    @Override
    @POST
    @Path("/updateThumbnailPath")
    public SaveBIMResponse updateProjectBIMThumbnailPath(UpdateBIMThumbnailPathRequest request) {
        logger.debug("updating thumbnail path for  project bim file id: "+ request.getProjectBimFileId());
        SaveBIMResponse response = new SaveBIMResponse();
        try {
            Boolean saved = projectBIMFileService.updateBimThumbnailPath(request);
            if(saved){
                response.setReturnVal("true");
                response.setReturnMessage("Successfully updated thumbnail");
            }
        } catch (Exception e) {
            logger.error("Error while updating thumbnail path for  bim : ",e);
            response.setReturnVal("false");
            response.setReturnMessage("Error while updating thumbnail path for BIM");

        }
        return response;
    }




}
