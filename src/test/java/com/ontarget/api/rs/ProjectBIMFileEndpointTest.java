package com.ontarget.api.rs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontarget.request.bean.*;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectBIMFileEndpointTest extends BaseJerseyTest{

    private static final String SAVE_BIM_ENDPOINT_URI=baseURI + "/bim/save";
    private static final String GET_BIM_POID_ENDPOINT_URI=baseURI + "/bim/getAll";
    private static final String DELETE_BIM_ENDPOINT_URI=baseURI + "/bim/delete";
    private static final String UPDATE_BIM_THUMB_PATH_ENDPOINT_URI=baseURI + "/bim/updateThumbnailPath";

    @Test
    public void saveBIMPoid(){
        try {
            SaveBIMRequest request = new SaveBIMRequest();
            request.setPoid(1234567L);
            request.setProjectBimFileLocation("/project/abc.jpg");
            request.setProjectid(42L);
            BaseRequest baseRequest=new BaseRequest();
            baseRequest.setLoggedInUserId(10);
            baseRequest.setLoggedInUserProjectId(42);
            request.setBaseRequest(baseRequest);

           logger.debug("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

             String response= client.target(SAVE_BIM_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            //Assert.assertTrue(status == 200);
           logger.debug(response);

        } catch (Exception e) {
            logger.error("Error while saving bim poid",e);
            fail();
        }
    }



    @Test
    public void getBIMPoidsTest(){

        try {
            BaseRequest baseRequest=new BaseRequest();
            baseRequest.setLoggedInUserId(10);
            baseRequest.setLoggedInUserProjectId(42);
            GetBIMRequest request = new GetBIMRequest();
            request.setBaseRequest(baseRequest);
            request.setProjectid(42L);

            logger.debug("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

            String response= client.target(GET_BIM_POID_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            //Assert.assertTrue(status == 200);
            logger.debug("Response:"+response);


        } catch (Exception e) {
            logger.error("Error while fetching bim poid",e);
            fail();
        }


    }


    @Test
    public void deleteBIMPoidsTest(){

        try {
            BaseRequest baseRequest=new BaseRequest();
            baseRequest.setLoggedInUserId(10);
            baseRequest.setLoggedInUserProjectId(42);
            DeleteBIMRequest request = new DeleteBIMRequest();
            request.setBaseRequest(baseRequest);
            request.setProjectBimFileId(12);

           logger.debug("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

            String response= client.target(DELETE_BIM_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            

            //Assert.assertTrue(status == 200);
           logger.debug("Response:"+response);


        } catch (Exception e) {
            logger.error("Error while fetching bim poid",e);
            fail();
        }
    }


    @Test
    public void updateBIMThumbPath(){

        try {
            UpdateBIMThumbnailPathRequest request=new UpdateBIMThumbnailPathRequest();
            request.setProjectBimFileId(24);
            request.setBimThumbnailPath("/project/def.jpg");
            BaseRequest baseRequest=new BaseRequest();
            baseRequest.setLoggedInUserId(10);
            baseRequest.setLoggedInUserProjectId(42);
            request.setBaseRequest(baseRequest);

           logger.debug("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

            String response= client.target(UPDATE_BIM_THUMB_PATH_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            //Assert.assertTrue(status == 200);
           logger.debug("Response:"+response);

        } catch (Exception e) {
            logger.error("Error while fetching bim poid",e);
            fail();
        }


    }





}
