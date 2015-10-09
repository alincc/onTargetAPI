package com.ontarget.api.service;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DeleteDocumentAttachmentRequest;
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
            fail();
        }



    }



}
