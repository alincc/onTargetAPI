package com.ontarget.api.dao;

import java.util.Date;
import java.util.List;

import com.ontarget.bean.Document;

public interface DocumentDAO extends GenericDAO<Document>{

    public boolean updateStatus(long documentId, String newStatus, int modifiedBy);

    public List<Document> getByCreatedBy(String createdBy, int projectId);

    public List<Document> getByAssigneeUsername(String username, int projectId);

    public List<Document> getDocumentsByProject(int projectId, String approved) throws Exception;

    public boolean updateDueDate(long documentId,Date dueDate, String modifiedBy) throws Exception;
}
