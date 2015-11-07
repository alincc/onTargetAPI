package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentKeyValueDTO;

public interface DocumentKeyValueDAO extends GenericDAO<DocumentKeyValueDTO> {
	List<DocumentKeyValueDTO> getByDocumentId(int documentId);

	boolean updateValue(int documentId, String key, String newValue, int modifiedBy);

	void deleteDocumentKeyValue(int documentId, List<String> usedKeys);
}
