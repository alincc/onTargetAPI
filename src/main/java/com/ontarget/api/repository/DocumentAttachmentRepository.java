package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.DocumentAttachment;

public interface DocumentAttachmentRepository extends JpaRepository<DocumentAttachment, Integer> {

	@Query("select d from DocumentAttachment d where d.document.documentId = ?1 and d.status='ACTIVE'")
	List<DocumentAttachment> findByDocumentId(Integer documentId);


    @Query("update DocumentAttachment d set d.status='DELETED', d.modifiedBy.userId=?2 where d.documentAttachmentId=?1")
    Boolean delete(Integer documentAttachmentId, Integer modifiedBy);


}
