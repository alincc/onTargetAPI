package com.ontarget.api.jpa.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.DocumentDAO;
import com.ontarget.api.dao.impl.BaseGenericDAOImpl;
import com.ontarget.api.repository.DocumentRepository;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentTemplate;

@Repository("documentJpaDAOImpl")
public class DocumentJpaDAOImpl extends BaseGenericDAOImpl<DocumentDTO> implements DocumentDAO {

	@Resource
	private DocumentRepository documentRepository;
	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	private static final Logger logger = Logger.getLogger(BaseGenericDAOImpl.class);

	@Override
	public DocumentDTO insert(DocumentDTO documentDTO) {
		Document document = new Document();
		document.setDocumentTemplate(new DocumentTemplate((int) documentDTO.getDocumentTemplate().getDocumentTemplateId()));
		document.setName(documentDTO.getName());
		document.setStatus(documentDTO.getStatus());
		document.setCreatedBy(documentDTO.getStatus());
		document.setCreatedBy(String.valueOf(documentDTO.getCreatedBy()));
		document.setCreatedDate(new Date());
		document.setModifiedBy(String.valueOf(documentDTO.getModifiedBy()));
		document.setModifiedDate(new Date());
		document.setProjectId(documentDTO.getProjectId());
		document.setDueDate(documentDTO.getDueDate());
		documentRepository.save(document);

		documentDTO.setDocumentId(document.getDocumentId());
		return documentDTO;
	}

	@Override
	public DocumentDTO read(long id) {
		Document document = documentRepository.findByDocumentId((int) id);

		DocumentDTO doc = new DocumentDTO();
		doc.setDocumentId(document.getDocumentId());
		doc.setName(document.getName());
		doc.setStatus(document.getStatus());
		doc.setCreatedBy(Integer.parseInt(document.getCreatedBy()));
		doc.setDueDate(document.getDueDate());
		return doc;
	}

	@Override
	public boolean update(DocumentDTO documentDTO) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean updateStatus(int documentId, String newStatus, int modifiedBy) {
		Document document = documentRepository.findByDocumentId(documentId);
		document.setStatus(newStatus);
		document.setModifiedBy(String.valueOf(modifiedBy));
		document.setModifiedDate(new Date());
		documentRepository.save(document);
		return true;
	}

	@Override
	public List<DocumentDTO> getByCreatedBy(Integer createdBy, int projectId) {

		List<Document> documents = documentRepository.findByCreatedByAndProjectId(String.valueOf(createdBy), projectId);

		List<DocumentDTO> documentDTOList = new ArrayList<>();
		if (documents != null && !documents.isEmpty()) {
			for (Document document : documents) {
				DocumentDTO doc = new DocumentDTO();
				doc.setDocumentId(document.getDocumentId());
				doc.setName(document.getName());
				doc.setStatus(document.getStatus());
				doc.setCreatedBy(Integer.parseInt(document.getCreatedBy()));
				doc.setDueDate(document.getDueDate());
				documentDTOList.add(doc);
			}
		}

		return documentDTOList;
	}

	@Override
	public List<DocumentDTO> getByAssigneeUsername(Integer userId, int projectId) {

		List<Document> documents = documentRepository.findByAssigneAndProject(userId, projectId);

		List<DocumentDTO> documentDTOList = new ArrayList<>();
		if (documents != null && !documents.isEmpty()) {
			for (Document document : documents) {
				DocumentDTO doc = new DocumentDTO();
				doc.setDocumentId(document.getDocumentId());
				doc.setName(document.getName());
				doc.setStatus(document.getStatus());
				doc.setCreatedBy(Integer.parseInt(document.getCreatedBy()));
				doc.setDueDate(document.getDueDate());
				documentDTOList.add(doc);
			}
		}

		return documentDTOList;
	}

	@Override
	public List<DocumentDTO> getDocumentsByProject(int projectId, String approved) throws Exception {
		List<Document> documents = documentRepository.findByProjectIdAndStatus(projectId, approved);

		List<DocumentDTO> documentDTOList = new ArrayList<>();
		if (documents != null && !documents.isEmpty()) {
			for (Document document : documents) {
				DocumentDTO doc = new DocumentDTO();
				doc.setDocumentId(document.getDocumentId());
				doc.setName(document.getName());
				doc.setStatus(document.getStatus());
				doc.setCreatedBy(Integer.parseInt(document.getCreatedBy()));
				doc.setDueDate(document.getDueDate());
				documentDTOList.add(doc);
			}
		}

		return documentDTOList;
	}

	@Override
	public boolean updateDueDate(int documentId, Date dueDate, String modifiedBy) throws Exception {
		Document document = documentRepository.findByDocumentId(documentId);
		document.setDueDate(dueDate);
		document.setModifiedBy(modifiedBy);
		document.setModifiedDate(new Date());
		documentRepository.save(document);
		return true;
	}

}
