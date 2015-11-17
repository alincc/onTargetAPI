package com.ontarget.api.dao;

import com.ontarget.bean.DocumentSubmittalDTO;
import com.ontarget.entities.DocumentSubmittal;

import java.util.List;

public interface DocumentSubmittalDAO extends GenericDAO<DocumentSubmittalDTO> {

    List<DocumentSubmittal> getDocumentSubmittalByDocumentId(int documentId);
}
