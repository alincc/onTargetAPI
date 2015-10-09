package com.ontarget.api.repository;

import com.ontarget.entities.DocumentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sanjeevghimire on 10/9/15.
 */
public interface DocumentResponseRepository extends JpaRepository<DocumentResponse, Long> {

    @Query(value = "select dr from DocumentResponse dr where dr.document.documentId=?1")
    public List<DocumentResponse> findByDocumentId(Integer documentId);

}
