package com.ontarget.api.rs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.GetDocumentQuestionResponseRequest;
import com.ontarget.request.bean.UpdateDocumentQuestionResponseRequest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
public class DocumentResponseEndpointTest extends BaseJerseyTest {

    private static final String DOCUMENT_RESPONSE_SAVE_ENDPOINT_URI=baseURI + "/document/response/save";
    private static final String DOCUMENT_RESPONSE_UPDATE_ENDPOINT_URI=baseURI + "document/response/update";
    private static final String DOCUMENT_RESPONSE_DELETE_ENDPOINT_URI=baseURI + "/document/response/delete";
    private static final String DOCUMENT_RESPONSE_GET_ENDPOINT_URI=baseURI + "/document/response";


    @Test
    public void saveDocumentResponseTest(){
        UpdateDocumentQuestionResponseRequest responseRequest=new UpdateDocumentQuestionResponseRequest();
        responseRequest.setDocumentId(2);
        responseRequest.setResponse("This is a new response");
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setLoggedInUserId(10);
        baseRequest.setLoggedInUserProjectId(42);
        responseRequest.setBaseRequest(baseRequest);

        try {
            logger.debug("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(responseRequest));

            String response= client.target(DOCUMENT_RESPONSE_SAVE_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).put(Entity.entity(responseRequest, MediaType.APPLICATION_JSON_TYPE), String.class);
            // int status = response.getStatus();

            //Assert.assertTrue(status == 200);
            logger.debug(response);
        } catch (Exception e) {
            logger.error("Error while saving document response.",e);
            fail();
        }
    }

    @Test
    public void fetchDocumentResponseTest(){

        try {

            GetDocumentQuestionResponseRequest request=new GetDocumentQuestionResponseRequest();
            request.setDocumentId(2);

            logger.debug("Request: "+new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(request));

            String response= client.target(DOCUMENT_RESPONSE_GET_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);
            // int status = response.getStatus();

            //Assert.assertTrue(status == 200);
            logger.debug(response);

        } catch (Exception e) {
            logger.error("Error while saving document response.",e);
            fail();
        }
    }



    @Test
    public void updateDocumentResponseTest(){
        UpdateDocumentQuestionResponseRequest responseRequest=new UpdateDocumentQuestionResponseRequest();
        responseRequest.setResponse("This is a new response");
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setLoggedInUserId(10);
        baseRequest.setLoggedInUserProjectId(42);
        responseRequest.setBaseRequest(baseRequest);

        try {

            GetDocumentQuestionResponseRequest request=new GetDocumentQuestionResponseRequest();
            request.setDocumentId(2);

            String response= client.target(DOCUMENT_RESPONSE_SAVE_ENDPOINT_URI).request().accept(MediaType.APPLICATION_JSON_TYPE).put(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE),String.class);


            responseRequest.setResponse("this is updated response");
            //responseRequest.setDocumentResponseId((int)response.getResponse().getDocumentResponseId());

            //response =  documentService.updateDocumentQuestionResponse(responseRequest);
            //Assert.assertTrue(response.getResponse().getResponse().equals("this is updated response"));

        } catch (Exception e) {
            logger.error("Error while saving document response.",e);
            fail();
        }
    }


    @Test
    public void deleteDocumentResponseTest(){
        UpdateDocumentQuestionResponseRequest responseRequest=new UpdateDocumentQuestionResponseRequest();
        responseRequest.setDocumentId(2);
        responseRequest.setResponse("This is a new response");
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setLoggedInUserId(10);
        baseRequest.setLoggedInUserProjectId(42);
        responseRequest.setBaseRequest(baseRequest);

        try {


        } catch (Exception e) {
            logger.error("Error while saving document response.",e);
            fail();
        }
    }





}
