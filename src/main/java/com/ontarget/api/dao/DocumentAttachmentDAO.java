package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentAttachmentDTO;

public interface DocumentAttachmentDAO extends GenericDAO<DocumentAttachmentDTO> {
	
	List<DocumentAttachmentDTO> getByDocumentId(long documentId) throws Exception;

    boolean delete(long documentAttachmentId, int modifiedBY);
}
