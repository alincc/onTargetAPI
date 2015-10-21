package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.DocumentSubmittal;
import org.springframework.data.jpa.repository.Query;

public interface DocumentSubmittalRepository extends JpaRepository<DocumentSubmittal, Integer>{
	
	DocumentSubmittal findByDocumentSubmittalId(Integer documentSubmittalId);

    @Query("select doc from DocumentSubmittal doc where doc.document.documentId=?1")
    DocumentSubmittal findDocumentSubmittalByDocumentId(int documentId);
}
