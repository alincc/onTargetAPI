package com.ontarget.api.jpa.dao.impl;

import com.ontarget.api.dao.DocumentResponseDAO;
import com.ontarget.api.repository.DocumentResponseRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.DocumentResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
@Repository("documentResponseJpaDAOImpl")
public class DocumentResponseJpaDAOImpl implements DocumentResponseDAO {

    private static final Logger logger = Logger.getLogger(DocumentResponseJpaDAOImpl.class);


    @Resource
    private DocumentResponseRepository documentResponseRepository;

    @Override
    public List<DocumentResponse> findDocumentReponseByDocumentId(int documentId) throws Exception {
        logger.debug("Getting all document responses for documentid:"+ documentId);
        return documentResponseRepository.findByDocumentId(documentId);
    }

    @Override
    public DocumentResponse save(DocumentResponse response) throws Exception {
        return documentResponseRepository.save(response);
    }

    @Override
    public DocumentResponse update(DocumentResponse response) throws Exception {
        logger.debug("Expiring the existing response: "+ response.getDocumentResponseId());
        //expire the first one.
        DocumentResponse documentResponse=documentResponseRepository.findOne(response.getDocumentResponseId());
        documentResponse.setResponseModifiedBY(response.getResponseModifiedBY());
        documentResponse.setResponseModifiedDate(response.getResponseModifiedDate());
        documentResponse.setStatus(OnTargetConstant.GenericStatus.DELETED);
        documentResponseRepository.save(documentResponse);

        logger.debug("saving the new response.");
        response.setDocumentResponseId(0L);
        response.setResponseBy(documentResponse.getResponseBy());
        response.setResponseDate(documentResponse.getResponseDate());
        response.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
        return documentResponseRepository.save(response);
    }

    @Override
    public DocumentResponse delete(DocumentResponse response) throws Exception {
        logger.debug("Expiring the existing response: "+ response.getDocumentResponseId());
        DocumentResponse documentResponse=documentResponseRepository.findOne(response.getDocumentResponseId());
        documentResponse.setStatus(OnTargetConstant.GenericStatus.DELETED);
        documentResponse.setResponseModifiedBY(response.getResponseModifiedBY());
        documentResponse.setResponseModifiedDate(response.getResponseModifiedDate());
        return documentResponseRepository.save(documentResponse);
    }
}
