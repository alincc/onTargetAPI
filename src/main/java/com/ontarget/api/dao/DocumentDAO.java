package com.ontarget.api.dao;

import java.util.Date;
import java.util.List;

import com.ontarget.bean.DocumentDTO;

public interface DocumentDAO extends GenericDAO<DocumentDTO> {

	public boolean updateStatus(int documentId, String newStatus, int modifiedBy);

	public List<DocumentDTO> getByCreatedBy(Integer createdBy, int projectId) throws Exception;

	public List<DocumentDTO> getByAssigneeUsername(Integer userId, int projectId) throws Exception;

    public List<DocumentDTO> getByNOTAssigneeUsername(Integer userId, int projectId) throws Exception;

    public List<DocumentDTO> getDocumentsByProject(int projectId, String approved) throws Exception;

    public boolean updateDueDate(int documentId, Date dueDate, String modifiedBy) throws Exception;
}
