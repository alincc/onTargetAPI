package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentGridKeyValueDTO;

public interface DocumentGridKeyValueDAO extends GenericDAO<DocumentGridKeyValueDTO>{
	List<DocumentGridKeyValueDTO> getByDocumentId(long documentId);
	List<DocumentGridKeyValueDTO> getByDocumentIdAndGridId(long documentId, String gridId);
	boolean updateValue(long documentId, String gridId, int gridRowIndex, String key, String newValue, int modifiedBy);
}
