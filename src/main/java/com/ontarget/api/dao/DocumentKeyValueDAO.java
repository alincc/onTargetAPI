package com.ontarget.api.dao;


import java.util.List;

import com.ontarget.bean.DocumentKeyValue;

public interface DocumentKeyValueDAO extends GenericDAO<DocumentKeyValue>{
	List<DocumentKeyValue> getByDocumentId(long documentId);
	boolean updateValue(long documentId, String key, String newValue, String modifiedBy);
}
