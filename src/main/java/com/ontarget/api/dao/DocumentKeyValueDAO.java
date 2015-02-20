package com.ontarget.api.dao;


import java.util.List;

import com.ontarget.bean.DocumentKeyValueDTO;

public interface DocumentKeyValueDAO extends GenericDAO<DocumentKeyValueDTO>{
	List<DocumentKeyValueDTO> getByDocumentId(long documentId);
	boolean updateValue(long documentId, String key, String newValue, int modifiedBy);
}
