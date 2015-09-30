package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.DocumentAttachment;

public interface DocumentAttachmentRepository extends JpaRepository<DocumentAttachment, Integer> {

	@Query("select d from DocumentAttachment d where d.document.documentId = ?1")
	List<DocumentAttachment> findByDocumentId(Integer documentId);
}
