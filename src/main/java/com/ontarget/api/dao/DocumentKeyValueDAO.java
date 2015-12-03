package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentKeyValueDTO;

public interface DocumentKeyValueDAO extends GenericDAO<DocumentKeyValueDTO> {
	public List<DocumentKeyValueDTO> getByDocumentId(int documentId);

	public boolean updateValue(int documentId, String key, String newValue, int modifiedBy);

	public void deleteDocumentKeyValue(int documentId, List<String> usedKeys);

    public List<String> getUsersInAttentionByDocument(int documentId) throws Exception;
}
