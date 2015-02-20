package com.ontarget.api.dao;

import com.ontarget.bean.DocumentTemplateDTO;

public interface DocumentTemplateDAO extends GenericDAO<DocumentTemplateDTO> {

	DocumentTemplateDTO getByDocumentId(long documentId);
}
