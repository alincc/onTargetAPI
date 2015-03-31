package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

	Document findByDocumentId(Integer documentId);

	List<Document> findByCreatedByAndProjectId(String createdBy, Integer projectId);

	// select doc.* from document doc " +
	// "inner join document_submittal sub on doc.document_id = sub.document_id "
	// +
	// "inner join user u on u.user_id = sub.assignee_user_id " +
	// "where u.user_id=? and doc.project_id=? and doc.status != 'APPROVED'
	@Query("select doc from Document doc JOIN doc.documentSubmittalList sub"
			+ " JOIN sub.user u WHERE u.userId = ?1 and doc.projectId = ?2 and doc.status !='APPROVED'")
	List<Document> findByAssigneAndProject(Integer assignee, Integer projectId);

	@Query("select d from Document d where d.projectId = ?1 and d.status = ?2")
	List<Document> findByProjectIdAndStatus(Integer projectId, String status);

}
