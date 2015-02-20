package com.ontarget.api.dao;

import java.util.Date;
import java.util.List;

import com.ontarget.bean.DocumentDTO;

public interface DocumentDAO extends GenericDAO<DocumentDTO>{

    public boolean updateStatus(long documentId, String newStatus, int modifiedBy);

    public List<DocumentDTO> getByCreatedBy(String createdBy, int projectId);

    public List<DocumentDTO> getByAssigneeUsername(String username, int projectId);

    public List<DocumentDTO> getDocumentsByProject(int projectId, String approved) throws Exception;

    public boolean updateDueDate(long documentId,Date dueDate, String modifiedBy) throws Exception;
}
