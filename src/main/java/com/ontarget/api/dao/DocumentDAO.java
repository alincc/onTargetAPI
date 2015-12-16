package com.ontarget.api.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ontarget.bean.DocumentDTO;
import com.ontarget.entities.Document;

public interface DocumentDAO extends GenericDAO<DocumentDTO> {

	public boolean updateStatus(int documentId, String newStatus, int modifiedBy);

	public List<DocumentDTO> getByCreatedBy(Integer createdBy, int projectId) throws Exception;

	public List<DocumentDTO> getByAssigneeUsername(Integer userId, int projectId) throws Exception;

    public List<DocumentDTO> getByNOTAssigneeUsername(Integer userId, int projectId) throws Exception;

    public List<DocumentDTO> getDocumentsByProject(int projectId, String approved) throws Exception;

    public boolean updateDueDate(int documentId, Date dueDate, String modifiedBy) throws Exception;

    public List<Object[]> getDocumentsByProjectGroupedByStatusAndDocumentTemplateId(Integer loggedInUserProjectId) throws Exception;
}
