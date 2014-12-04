package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentAttachment;

public interface DocumentAttachmentDAO extends GenericDAO<DocumentAttachment> {
	
	List<DocumentAttachment> getByDocumentId(long documentId);

}
