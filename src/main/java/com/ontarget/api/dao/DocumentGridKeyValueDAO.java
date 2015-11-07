package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentGridKeyValueDTO;

public interface DocumentGridKeyValueDAO extends GenericDAO<DocumentGridKeyValueDTO> {
	List<DocumentGridKeyValueDTO> getByDocumentId(int documentId);

	List<DocumentGridKeyValueDTO> getByDocumentIdAndGridId(int documentId, String gridId);

	boolean updateValue(int documentId, String gridId, int gridRowIndex, String key, String newValue, int modifiedBy);

	public void deleteDocumentGridKeyValue(int documentId, List<String> usedKeys);
}
