package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentGridKeyValue;

public interface DocumentGridKeyValueDAO extends GenericDAO<DocumentGridKeyValue>{
	List<DocumentGridKeyValue> getByDocumentId(long documentId);
	List<DocumentGridKeyValue> getByDocumentIdAndGridId(long documentId, String gridId);
	boolean updateValue(long documentId, String gridId, int gridRowIndex, String key, String newValue, String modifiedBy);
}
