package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.DocumentResponse;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
public interface DocumentResponseRepository extends JpaRepository<DocumentResponse, Long> {

	@Query("select d from DocumentResponse d where d.documentResponseId =?1")
	public DocumentResponse findById(Long documentResponseId);

	@Query(value = "select dr from DocumentResponse dr where dr.document.documentId=?1 and dr.status='ACTIVE'")
	public List<DocumentResponse> findByDocumentId(Integer documentId);

}
