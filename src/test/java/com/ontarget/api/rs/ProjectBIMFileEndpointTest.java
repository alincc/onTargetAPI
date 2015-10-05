package com.ontarget.api.rs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.GetBIMRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectBIMFileEndpointTest extends BaseJerseyTest{

    private static final String SAVE_BIM_ENDPOINT_URI=baseURI + "/bim/save";
    private static final String GET_BIM_POID_ENDPOINT_URI=baseURI + "/bim/getAll";
    private static final String DELETE_BIM_ENDPOINT_URI=baseURI + "/bim/delete";

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

            System.out.println("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

             String response= client.target(SAVE_BIM_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            //Assert.assertTrue(status == 200);
            System.out.println(response);


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

            System.out.println("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

            String response= client.target(GET_BIM_POID_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            //Assert.assertTrue(status == 200);
            System.out.println("Response:"+response);


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

            System.out.println("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

            String response= client.target(DELETE_BIM_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            

            //Assert.assertTrue(status == 200);
            System.out.println("Response:"+response);


        } catch (Exception e) {
            logger.error("Error while fetching bim poid",e);
            fail();
        }


    }





}
