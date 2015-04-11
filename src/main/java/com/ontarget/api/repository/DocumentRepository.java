package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.Document;
import com.ontarget.entities.User;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

	Document findByDocumentId(Integer documentId);

	List<Document> findByCreatedByAndProjectId(User createdBy, Integer projectId);

	@Query("select doc from Document doc JOIN doc.documentSubmittalList sub"
			+ " JOIN sub.user u WHERE u.userId = ?1 and doc.projectId = ?2 and doc.status !='APPROVED'")
	List<Document> findByAssigneAndProject(Integer assignee, Integer projectId);

	@Query("select d from Document d where d.projectId = ?1 and d.status = ?2")
	List<Document> findByProjectIdAndStatus(Integer projectId, String status);

}
