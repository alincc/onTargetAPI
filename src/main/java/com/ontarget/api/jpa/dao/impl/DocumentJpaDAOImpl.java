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
import com.ontarget.api.repository.DocumentRepository;
import com.ontarget.bean.Contact;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.bean.UserDTO;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentTemplate;
import com.ontarget.entities.User;

@Repository("documentJpaDAOImpl")
public class DocumentJpaDAOImpl implements DocumentDAO {

	@Resource
	private DocumentRepository documentRepository;
	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	private static final Logger logger = Logger.getLogger(DocumentJpaDAOImpl.class);

	@Override
	public DocumentDTO insert(DocumentDTO documentDTO) {
		Document document = new Document();
		document.setDocumentTemplate(new DocumentTemplate((int) documentDTO.getDocumentTemplate().getDocumentTemplateId()));
		document.setName(documentDTO.getName());
		document.setStatus(documentDTO.getStatus());
		document.setCreatedBy(new User(documentDTO.getCreatedBy()));
		document.setCreatedDate(new Date());
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
		doc.setCreatedBy(document.getCreatedBy().getUserId());
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
		document.setModifiedBy(new User(modifiedBy));
		document.setModifiedDate(new Date());
		documentRepository.save(document);
		return true;
	}

	@Override
	public List<DocumentDTO> getByCreatedBy(Integer createdBy, int projectId) throws Exception {

		List<Document> documents = documentRepository.findByCreatedByAndProjectId(new User(createdBy), projectId);

		List<DocumentDTO> documentDTOList = new ArrayList<>();
		if (documents != null && !documents.isEmpty()) {
			for (Document document : documents) {
				DocumentDTO doc = new DocumentDTO();
				doc.setDocumentId(document.getDocumentId());
				doc.setName(document.getName());
				doc.setStatus(document.getStatus());
				doc.setCreatedBy(document.getCreatedBy().getUserId());
				doc.setDueDate(document.getDueDate());

				Contact contact = null;
				try {
					contact = contactDAO.getContact(doc.getCreatedBy());
				} catch (Exception e) {
					logger.error("Error while getting contact info", e);
					throw e;
				}
				UserDTO creator = new UserDTO();
				creator.setContact(contact);
				doc.setCreator(creator);
				documentDTOList.add(doc);
			}
		}

		return documentDTOList;
	}

	@Override
	public List<DocumentDTO> getByAssigneeUsername(Integer userId, int projectId) throws Exception {

		List<Document> documents = documentRepository.findByAssigneAndProject(userId, projectId);

		List<DocumentDTO> documentDTOList = new ArrayList<>();
		if (documents != null && !documents.isEmpty()) {
			for (Document document : documents) {
				DocumentDTO doc = new DocumentDTO();
				doc.setDocumentId(document.getDocumentId());
				doc.setName(document.getName());
				doc.setStatus(document.getStatus());
				doc.setCreatedBy(document.getCreatedBy().getUserId());
				doc.setDueDate(document.getDueDate());

				Contact contact = null;
				try {
					contact = contactDAO.getContact(doc.getCreatedBy());
				} catch (Exception e) {
					logger.error("Error while getting contact info", e);
					throw e;
				}
				UserDTO creator = new UserDTO();
				creator.setContact(contact);
				doc.setCreator(creator);
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
				doc.setCreatedBy(document.getCreatedBy().getUserId());
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
		document.setModifiedBy(new User(Integer.parseInt(modifiedBy)));
		document.setModifiedDate(new Date());
		documentRepository.save(document);
		return true;
	}

}
