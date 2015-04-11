package com.ontarget.api.jpa.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentSubmittalDAO;
import com.ontarget.api.dao.impl.BaseGenericDAOImpl;
import com.ontarget.api.repository.DocumentSubmittalRepository;
import com.ontarget.bean.DocumentSubmittalDTO;
import com.ontarget.entities.Document;
import com.ontarget.entities.DocumentSubmittal;
import com.ontarget.entities.User;

@Repository("documentSubmittalJpaDAOImpl")
public class DocumentSubmittalJpaDAOImpl extends BaseGenericDAOImpl<DocumentSubmittalDTO> implements DocumentSubmittalDAO {
	@Resource
	private DocumentSubmittalRepository documentSubmittalRepository;

	@Override
	public DocumentSubmittalDTO insert(DocumentSubmittalDTO documentSubmittalDTO) {
		DocumentSubmittal documentSubmittal = new DocumentSubmittal();
		documentSubmittal.setDocument(new Document(documentSubmittalDTO.getDocument().getDocumentId()));
		documentSubmittal.setUser(new User(documentSubmittalDTO.getAssignedTo()));
		documentSubmittal.setCreatedBy(new User(documentSubmittalDTO.getCreatedBy()));
		documentSubmittal.setCreatedDate(new Date());
		documentSubmittalRepository.save(documentSubmittal);
		documentSubmittalDTO.setDocumentSubmittalId(documentSubmittal.getDocumentSubmittalId());
		return documentSubmittalDTO;
	}

	@Override
	public DocumentSubmittalDTO read(long id) {
		DocumentSubmittal documentSubmittal = documentSubmittalRepository.findByDocumentSubmittalId((int) id);

		DocumentSubmittalDTO docSub = new DocumentSubmittalDTO();
		docSub.setDocumentSubmittalId(documentSubmittal.getDocumentSubmittalId());
		return docSub;
	}

	@Override
	public boolean update(DocumentSubmittalDTO bean) {
		throw new UnsupportedOperationException();
	}

}
