package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.DocumentGridKeyValue;

public interface DocumentGridKeyValueRepository extends JpaRepository<DocumentGridKeyValue, Integer> {
	DocumentGridKeyValue findByDocumentGridKeyValueId(Integer documentGridKeyValueId);

	@Query("select d from DocumentGridKeyValue d where d.document.id = ?1 and d.status !='" + OnTargetConstant.GenericStatus.DELETED + "'")
	List<DocumentGridKeyValue> getDocumentGridKeyValuesByDocumentId(Integer documentId);

	@Query("select d from DocumentGridKeyValue d where d.document.id = ?1 and d.gridId = ?2 and d.status !='" + OnTargetConstant.GenericStatus.DELETED + "'")
	DocumentGridKeyValue getDocumentgridKeyValuesByDocumentIdAndGridId(Integer documentId, String gridId);

	@Query("select d from DocumentGridKeyValue d where d.document.id = ?1 and d.gridId = ?2 and d.gridRowIndex = ?3 and d.key=?4 and d.status !='" + OnTargetConstant.GenericStatus.DELETED + "'")
	DocumentGridKeyValue getDocumentGridKeyValueByDocumentIdGridIdAndRowIndex(Integer documentId, String gridId, Integer gridRowIndex,
			String key);

}
