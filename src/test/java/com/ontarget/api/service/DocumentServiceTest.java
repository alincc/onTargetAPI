package com.ontarget.api.service;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DeleteDocumentAttachmentRequest;
import com.ontarget.request.bean.GetDocumentQuestionResponseRequest;
import com.ontarget.request.bean.UpdateDocumentQuestionResponseRequest;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 10/8/15.
 */
public class DocumentServiceTest extends BaseTest{

    private Logger logger = Logger.getLogger(DocumentServiceTest.class);

    @Autowired
    private DocumentService documentService;

    @Test
    public void deleteDocumentAttachmentTest(){

        DeleteDocumentAttachmentRequest request=new DeleteDocumentAttachmentRequest();
        request.setDocumentAttachmentId(1L);
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setLoggedInUserProjectId(42);
        baseRequest.setLoggedInUserId(10);
        request.setBaseRequest(baseRequest);

        try{
            AddDocumentAttachmentResponse response = documentService.deleteDocumentAttachment(request);
            Assert.assertTrue(response.getReturnVal().equals("SUCCESS"));
        }catch (Exception e){
            logger.error("Error while deleting document attachment.",e);
            fail();
        }
    }

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
            UpdateDocumentQuestionResponse response=documentService.saveDocumentQuestionResponse(responseRequest);
            Assert.assertTrue(response.getResponse().getDocumentResponseId() > 0);
        } catch (Exception e) {
            logger.error("Error while saving document response.",e);
            fail();
        }
    }

    @Test
    public void fetchDocumentResponseTest(){
        UpdateDocumentQuestionResponseRequest responseRequest=new UpdateDocumentQuestionResponseRequest();
        responseRequest.setDocumentId(2);
        responseRequest.setResponse("This is a new response");
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setLoggedInUserId(10);
        baseRequest.setLoggedInUserProjectId(42);
        responseRequest.setBaseRequest(baseRequest);

        try {
            UpdateDocumentQuestionResponse response=documentService.saveDocumentQuestionResponse(responseRequest);
            Assert.assertTrue(response.getResponse().getDocumentResponseId() > 0);

            GetDocumentQuestionResponseRequest request=new GetDocumentQuestionResponseRequest();
            request.setDocumentId(2);

            GetDocumentQuestionResponse getDocumentQuestionResponse =  documentService.getDocumentQuestionsResponses(request);
            Assert.assertTrue(getDocumentQuestionResponse.getDocumentResponses().size() > 0);

        } catch (Exception e) {
            logger.error("Error while saving document response.",e);
            fail();
        }
    }



    @Test
    public void updateDocumentResponseTest(){
        UpdateDocumentQuestionResponseRequest responseRequest=new UpdateDocumentQuestionResponseRequest();
        responseRequest.setDocumentId(2);
        responseRequest.setResponse("This is a new response");
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setLoggedInUserId(10);
        baseRequest.setLoggedInUserProjectId(42);
        responseRequest.setBaseRequest(baseRequest);

        try {
            UpdateDocumentQuestionResponse response=documentService.saveDocumentQuestionResponse(responseRequest);
            Assert.assertTrue(response.getResponse().getDocumentResponseId() > 0);

            responseRequest.setResponse("this is updated response");
            responseRequest.setDocumentResponseId((int)response.getResponse().getDocumentResponseId());

            response =  documentService.updateDocumentQuestionResponse(responseRequest);
            Assert.assertTrue(response.getResponse().getResponse().equals("this is updated response"));

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
            UpdateDocumentQuestionResponse response=documentService.saveDocumentQuestionResponse(responseRequest);
            Assert.assertTrue(response.getResponse().getDocumentResponseId() > 0);

            responseRequest.setDocumentResponseId((int)response.getResponse().getDocumentResponseId());

            response =  documentService.deleteDocumentQuestionResponse(responseRequest);
            Assert.assertTrue(response.getReturnVal().equals(OnTargetConstant.SUCCESS));

        } catch (Exception e) {
            logger.error("Error while saving document response.",e);
            fail();
        }
    }

}
