package com.ontarget.api.dao;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentResponse;
import com.ontarget.entities.User;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
public class DocumentResponseDAOTest extends BaseTest {

    private Logger logger = Logger.getLogger(CompanyDAOTest.class);

    @Autowired
    private DocumentResponseDAO documentResponseDAO;

    @Test
    public void saveDocumentResponseTest(){
        DocumentResponse response = new DocumentResponse();
        response.setResponse("This is a test response");
        response.setResponseBy(new User(10));
        response.setResponseModifiedDate(new Date());
        response.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
        Document document=new Document();
        document.setDocumentId(1);


        try {
            DocumentResponse documentResponse=documentResponseDAO.save(response);
            Assert.assertTrue(documentResponse.getDocumentResponseId() > 0);
        } catch (Exception e) {
            logger.error("Error while saving response",e);
            fail();
        }


    }

    @Test
    public void updateDocumentResponseTest(){
        DocumentResponse response = new DocumentResponse();
        response.setResponse("This is a test response");
        response.setResponseBy(new User(10));
        response.setResponseModifiedDate(new Date());
        response.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
        Document document=new Document();
        document.setDocumentId(1);

        try {

            DocumentResponse documentResponse=documentResponseDAO.save(response);
            long id=documentResponse.getDocumentResponseId();

            //update text.
            documentResponse.setResponse("the response is changed.");
            documentResponse.setResponseModifiedBY(new User(10));
            documentResponse.setResponseModifiedDate(new Date());

            documentResponse=documentResponseDAO.update(documentResponse);

            Assert.assertTrue(documentResponse.getResponse().equals("the response is changed."));

            Assert.assertTrue(documentResponse.getDocumentResponseId() == id);
        } catch (Exception e) {
            logger.error("Error while saving response",e);
            fail();
        }
    }


    @Test
    public void deleteDocumentResponseTest(){
        DocumentResponse response = new DocumentResponse();
        response.setResponse("This is a test response");
        response.setResponseBy(new User(10));
        response.setResponseModifiedDate(new Date());
        response.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
        Document document=new Document();
        document.setDocumentId(1);

        try {

            DocumentResponse documentResponse=documentResponseDAO.save(response);
            long id=documentResponse.getDocumentResponseId();

            //update text.
            documentResponse.setResponse("the response is changed.");
            documentResponse.setResponseModifiedBY(new User(10));
            documentResponse.setResponseModifiedDate(new Date());

            documentResponse=documentResponseDAO.delete(documentResponse);

            Assert.assertTrue(documentResponse.getStatus().equals(OnTargetConstant.GenericStatus.DELETED));

            Assert.assertTrue(documentResponse.getDocumentResponseId() == id);
        } catch (Exception e) {
            logger.error("Error while saving response",e);
            fail();
        }


    }





}
