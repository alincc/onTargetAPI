package com.ontarget.api.dao;

import com.ontarget.bean.DocumentSubmittalDTO;
import com.ontarget.entities.DocumentSubmittal;

public interface DocumentSubmittalDAO extends GenericDAO<DocumentSubmittalDTO> {

    DocumentSubmittal getDocumentSubmittalByDocumentId(int documentId);
}
