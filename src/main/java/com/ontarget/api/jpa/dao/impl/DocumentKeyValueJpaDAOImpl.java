package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentKeyValueDAO;
import com.ontarget.api.repository.DocumentKeyValueRepository;
import com.ontarget.bean.DocumentKeyValueDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentKeyValue;
import com.ontarget.entities.User;

@Repository("documentKeyValueJpaDAOImpl")
public class DocumentKeyValueJpaDAOImpl implements DocumentKeyValueDAO {
	@Resource
	private DocumentKeyValueRepository documentKeyValueRepository;

	@Override
	public DocumentKeyValueDTO insert(DocumentKeyValueDTO documentKeyValueDTO) {
		DocumentKeyValue documentKeyValue = new DocumentKeyValue();
		documentKeyValue.setDocument(new Document(documentKeyValueDTO.getDocument().getDocumentId()));

		documentKeyValue.setKey(documentKeyValueDTO.getKey());
		documentKeyValue.setValue(documentKeyValueDTO.getValue());
		documentKeyValue.setCreatedBy(new User(documentKeyValueDTO.getCreatedBy()));
		documentKeyValue.setCreatedDate(new Date());
		documentKeyValue.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
		documentKeyValueRepository.save(documentKeyValue);
		return documentKeyValueDTO;
	}

	@Override
	public DocumentKeyValueDTO read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(DocumentKeyValueDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<DocumentKeyValueDTO> getByDocumentId(int documentId) {
		List<DocumentKeyValue> documentKeyValues = documentKeyValueRepository.getDocumentKeyValueByDocumentId(documentId);

		List<DocumentKeyValueDTO> keyValueDTOList = new ArrayList<>();
		if (documentKeyValues != null && !documentKeyValues.isEmpty()) {
			for (DocumentKeyValue docKeyValue : documentKeyValues) {
				DocumentKeyValueDTO keyValue = new DocumentKeyValueDTO();
				keyValue.setKey(docKeyValue.getKey());
				keyValue.setValue(docKeyValue.getValue());
				keyValueDTOList.add(keyValue);
			}
		}
		return keyValueDTOList;

	}

	@Override
	public boolean updateValue(int documentId, String key, String newValue, int modifiedBy) {

		DocumentKeyValue documentKeyValue = documentKeyValueRepository.findByDocumentIdAndKey(documentId, key);
		if (documentKeyValue != null) {
			documentKeyValue.setValue(newValue);
			documentKeyValue.setModifiedBy(new User(modifiedBy));
			documentKeyValue.setModifiedDate(new Date());
			documentKeyValueRepository.save(documentKeyValue);
		} else {
			documentKeyValue = new DocumentKeyValue();
			documentKeyValue.setDocument(new Document(documentId));
			documentKeyValue.setKey(key);
			documentKeyValue.setValue(newValue);
			documentKeyValue.setCreatedBy(new User(modifiedBy));
			documentKeyValue.setCreatedDate(new Date());
			documentKeyValue.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
			documentKeyValueRepository.save(documentKeyValue);
		}
		return true;
	}

	@Override
	public void deleteDocumentKeyValue(int documentId, List<String> usedKeys) {
		List<DocumentKeyValue> documentKeyValueList = documentKeyValueRepository.getDocumentKeyValueByDocumentId(documentId);

		for (DocumentKeyValue documentKeyValue : documentKeyValueList) {
			if (!usedKeys.contains(documentKeyValue.getKey())) {
				documentKeyValue.setStatus(OnTargetConstant.GenericStatus.DELETED);
				documentKeyValueRepository.save(documentKeyValue);
			}
		}
	}

}
