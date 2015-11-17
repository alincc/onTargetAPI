package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentGridKeyValueDAO;
import com.ontarget.api.repository.DocumentGridKeyValueRepository;
import com.ontarget.bean.DocumentGridKeyValueDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentGridKeyValue;
import com.ontarget.entities.User;

@Repository("documentGridKeyValueJpaDAOImpl")
public class DocumentGridKeyValueJpaDAOImpl implements DocumentGridKeyValueDAO {
	@Resource
	private DocumentGridKeyValueRepository documentGridKeyValueRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DocumentGridKeyValueDTO insert(DocumentGridKeyValueDTO documentGridKeyValueDTO) {
		DocumentGridKeyValue documentGridKeyValue = new DocumentGridKeyValue();
		documentGridKeyValue.setDocument(new Document(documentGridKeyValueDTO.getDocument().getDocumentId()));
		documentGridKeyValue.setGridId(documentGridKeyValueDTO.getGridId());
		documentGridKeyValue.setGridRowIndex(documentGridKeyValueDTO.getGridRowIndex());
		documentGridKeyValue.setKey(documentGridKeyValueDTO.getKey());
		documentGridKeyValue.setValue(documentGridKeyValueDTO.getValue());
		documentGridKeyValue.setCreatedBy(new User(documentGridKeyValueDTO.getCreatedBy()));
		documentGridKeyValue.setCreatedDate(new Date());
		documentGridKeyValue.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
		documentGridKeyValueRepository.save(documentGridKeyValue);

		return documentGridKeyValueDTO;
	}

	@Override
	public DocumentGridKeyValueDTO read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(DocumentGridKeyValueDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<DocumentGridKeyValueDTO> getByDocumentId(int documentId) {

		List<DocumentGridKeyValueDTO> gridKeyValues = new ArrayList<>();

		List<DocumentGridKeyValue> gridValues = documentGridKeyValueRepository.getDocumentGridKeyValuesByDocumentId(documentId);

		if (gridValues != null && !gridValues.isEmpty()) {
			for (DocumentGridKeyValue documentGridKeyValue : gridValues) {
				DocumentGridKeyValueDTO keyValue = new DocumentGridKeyValueDTO();
				keyValue.setGridId(documentGridKeyValue.getGridId());
				keyValue.setGridRowIndex(documentGridKeyValue.getGridRowIndex());
				keyValue.setKey(documentGridKeyValue.getKey());
				keyValue.setValue(documentGridKeyValue.getValue());
				gridKeyValues.add(keyValue);
			}
		}
		return gridKeyValues;
	}

	@Override
	public List<DocumentGridKeyValueDTO> getByDocumentIdAndGridId(int documentId, String gridId) {

		DocumentGridKeyValue docGridKeyValue = documentGridKeyValueRepository.getDocumentgridKeyValuesByDocumentIdAndGridId(documentId,
				gridId);

		List<DocumentGridKeyValueDTO> gridKeyValues = new ArrayList<>();

		DocumentGridKeyValueDTO keyValue = new DocumentGridKeyValueDTO();
		keyValue.setGridRowIndex(docGridKeyValue.getGridRowIndex());
		keyValue.setKey(docGridKeyValue.getKey());
		keyValue.setValue(docGridKeyValue.getValue());
		gridKeyValues.add(keyValue);

		return gridKeyValues;
	}

	@Override
	public boolean updateValue(int documentId, String gridId, int gridRowIndex, String key, String newValue, int modifiedBy) {
		// String hql = "update DocumentGridKeyValue d set d.value = :value,"
		// + "d.modifiedBy =:modifiedBy where d.document.id = :documentId and "
		// + " d.gridId = :gridId and d.gridRowIndex = :gridRowIndex";
		// Query query = entityManager.createQuery(hql);
		// query.setParameter("value", newValue);
		// query.setParameter("modifiedBy", modifiedBy);
		// query.setParameter("documentId", documentId);
		// query.setParameter("gridId", gridId);
		// query.setParameter("gridRowIndex", gridRowIndex);
		// query.executeUpdate();

		DocumentGridKeyValue documentGridKeyValue = documentGridKeyValueRepository.getDocumentGridKeyValueByDocumentIdGridIdAndRowIndex(
				documentId, gridId, gridRowIndex, key);

		// if(documentGridKeyValue == null){// this means while update new row
		// was added
		// DocumentGridKeyValueDTO documentGridKeyValueDTO = new
		// DocumentGridKeyValueDTO();
		// DocumentDTO documentDTO = new DocumentDTO();
		// documentDTO.setDocumentId(documentId);
		// documentGridKeyValueDTO.setDocument(documentDTO);
		// documentGridKeyValueDTO.setKey(key);
		// documentGridKeyValueDTO.setValue(newValue);
		// documentGridKeyValueDTO.setGridId(gridId);
		// documentGridKeyValueDTO.setGridRowIndex(gridRowIndex);
		// documentGridKeyValueDTO.setCreatedBy(modifiedBy);
		// documentGridKeyValueDTO.setModifiedBy(modifiedBy);
		// this.insert(documentGridKeyValueDTO);
		// }else {
		// documentGridKeyValue.setValue(newValue);
		// documentGridKeyValue.setModifiedBy(new User(modifiedBy));
		// documentGridKeyValue.setModifiedDate(new Date());
		// documentGridKeyValueRepository.save(documentGridKeyValue);
		// }
		if (documentGridKeyValue != null) {
			documentGridKeyValue.setValue(newValue);
			documentGridKeyValue.setModifiedBy(new User(modifiedBy));
			documentGridKeyValue.setModifiedDate(new Date());
			documentGridKeyValueRepository.save(documentGridKeyValue);
		} else {
			documentGridKeyValue = new DocumentGridKeyValue();
			documentGridKeyValue.setDocument(new Document(documentId));
			documentGridKeyValue.setGridId(gridId);
			documentGridKeyValue.setGridRowIndex(gridRowIndex);
			documentGridKeyValue.setKey(key);
			documentGridKeyValue.setValue(newValue);
			documentGridKeyValue.setCreatedBy(new User(modifiedBy));
			documentGridKeyValue.setCreatedDate(new Date());
			documentGridKeyValue.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
			documentGridKeyValueRepository.save(documentGridKeyValue);
		}

		return true;
	}

	@Override
	public void deleteDocumentGridKeyValue(int documentId, List<String> usedKeys) {
		List<DocumentGridKeyValue> documentGridKeyValueList = documentGridKeyValueRepository
				.getDocumentGridKeyValuesByDocumentId(documentId);

		for (DocumentGridKeyValue documentGridKeyValue : documentGridKeyValueList) {
			if (!usedKeys.contains(documentGridKeyValue.getKey())) {
				documentGridKeyValue.setStatus(OnTargetConstant.GenericStatus.DELETED);
				documentGridKeyValueRepository.save(documentGridKeyValue);
			}
		}
	}

}
