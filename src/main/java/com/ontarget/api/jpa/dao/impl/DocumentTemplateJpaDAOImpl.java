package com.ontarget.api.jpa.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentTemplateDAO;
import com.ontarget.api.dao.impl.BaseGenericDAOImpl;
import com.ontarget.api.repository.DocumentTemplateRepository;
import com.ontarget.bean.DocumentTemplateDTO;
import com.ontarget.entities.DocumentTemplate;

@Repository("documentTemplateJpaDAOImpl")
public class DocumentTemplateJpaDAOImpl extends BaseGenericDAOImpl<DocumentTemplateDTO> implements DocumentTemplateDAO {

	@Resource
	private DocumentTemplateRepository documentTemplateRepository;

	@Override
	public DocumentTemplateDTO insert(DocumentTemplateDTO documentTemplateDTO) {
		DocumentTemplate documentTemplate = new DocumentTemplate();
		documentTemplate.setName(documentTemplateDTO.getName());
		documentTemplate.setCreatedBy(String.valueOf(documentTemplateDTO.getCreatedBy().getUserId()));
		documentTemplate.setCreatedDate(new Date());
		documentTemplate.setModifiedBy(String.valueOf(documentTemplateDTO.getModifiedBy().getUserId()));
		documentTemplate.setModfiedDate(new Date());
		documentTemplateRepository.save(documentTemplate);
		documentTemplateDTO.setDocumentTemplateId(documentTemplate.getDocumentTemplateId());
		return documentTemplateDTO;
	}

	@Override
	public DocumentTemplateDTO read(long id) {
		DocumentTemplate documentTemplate = documentTemplateRepository.findByDocumentTemplateId((int) id);

		DocumentTemplateDTO documentTemplateDTO = new DocumentTemplateDTO();
		documentTemplateDTO.setDocumentTemplateId(documentTemplate.getDocumentTemplateId());
		documentTemplateDTO.setName(documentTemplate.getName());

		return documentTemplateDTO;
	}

	@Override
	public boolean update(DocumentTemplateDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public DocumentTemplateDTO getByDocumentId(long documentId) {
		Integer documentID = Integer.parseInt(String.valueOf(documentId));
		DocumentTemplate documentTemplate = documentTemplateRepository.findByDocumentListDocumentId(documentID);

		DocumentTemplateDTO documentTemplateDTO = new DocumentTemplateDTO();
		documentTemplateDTO.setDocumentTemplateId(documentTemplate.getDocumentTemplateId());
		documentTemplateDTO.setName(documentTemplate.getName());

		return documentTemplateDTO;
	}

}
