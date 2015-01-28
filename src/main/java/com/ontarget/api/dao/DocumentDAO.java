package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.Document;

public interface DocumentDAO extends GenericDAO<Document>{

    public boolean updateStatus(long documentId, String newStatus, int modifiedBy);

    public List<Document> getByCreatedBy(String createdBy, long projectId);

    public List<Document> getByAssigneeUsername(String username, long projectId);

    public List<Document> getDocumentsByProject(long projectId, String approved) throws Exception;
}
