package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.DocumentKeyValue;

public interface DocumentKeyValueRepository extends JpaRepository<DocumentKeyValue, Integer> {

	@Query("select d from DocumentKeyValue d where d.document.id = ?1 and d.key = ?2")
	DocumentKeyValue findByDocumentIdAndKey(Integer documentId, String key);

	@Query("select d from DocumentKeyValue d where d.document.id = ?1")
	List<DocumentKeyValue> getDocumentKeyValueByDocumentId(Integer documentId);
}
