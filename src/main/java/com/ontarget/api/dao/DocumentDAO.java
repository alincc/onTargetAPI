package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.Document;

public interface DocumentDAO extends GenericDAO<Document>{
	boolean updateStatus(long documentId, String newStatus, String modifiedBy);
	List<Document> getByCreatedBy(String createdBy);
	List<Document> getByAssigneeUsername(String username);
}
