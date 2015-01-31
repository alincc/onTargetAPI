package com.ontarget.api.dao;

import java.util.Date;
import java.util.List;

import com.ontarget.bean.Document;

public interface DocumentDAO extends GenericDAO<Document>{

    public boolean updateStatus(long documentId, String newStatus, String modifiedBy);

    public List<Document> getByCreatedBy(String createdBy, long projectId);

    public List<Document> getByAssigneeUsername(String username, long projectId);

    public List<Document> getDocumentsByProject(long projectId, String approved) throws Exception;

    public boolean updateDueDate(long documentId,Date dueDate, String modifiedBy) throws Exception;
}
