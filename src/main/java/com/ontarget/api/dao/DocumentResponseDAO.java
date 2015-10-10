package com.ontarget.api.dao;

import com.ontarget.entities.DocumentResponse;

import java.util.List;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
public interface DocumentResponseDAO {


    public List<DocumentResponse> findDocumentReponseByDocumentId(int documentId) throws Exception;

    public DocumentResponse save(DocumentResponse response) throws Exception;

    public DocumentResponse update(DocumentResponse response) throws Exception;

    public DocumentResponse delete(DocumentResponse response) throws Exception;


}
