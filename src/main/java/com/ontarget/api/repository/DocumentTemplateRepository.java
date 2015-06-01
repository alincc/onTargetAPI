package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.DocumentTemplate;

public interface DocumentTemplateRepository extends JpaRepository<DocumentTemplate, Integer> {

	DocumentTemplate findByDocumentTemplateId(Integer documentTemplateId);
	
	//select dt.* from document_template dt, document d where dt.document_template_id = d.document_template_id 
	//and document_id = ?
	DocumentTemplate findByDocumentListDocumentId(Integer documentId);
	
}
