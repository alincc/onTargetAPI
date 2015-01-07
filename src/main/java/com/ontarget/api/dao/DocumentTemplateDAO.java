package com.ontarget.api.dao;

import com.ontarget.bean.DocumentTemplate;

public interface DocumentTemplateDAO extends GenericDAO<DocumentTemplate> {

	DocumentTemplate getByDocumentId(long documentId);
}
