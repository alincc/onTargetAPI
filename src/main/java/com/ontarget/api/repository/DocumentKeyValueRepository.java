package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.DocumentKeyValue;

public interface DocumentKeyValueRepository extends JpaRepository<DocumentKeyValue, Integer> {

	@Query("select d from DocumentKeyValue d where d.document.id = ?1 and d.key = ?2 and d.status !='" + OnTargetConstant.GenericStatus.DELETED + "'")
	DocumentKeyValue findByDocumentIdAndKey(Integer documentId, String key);

	@Query("select d from DocumentKeyValue d where d.document.id = ?1 and d.status !='" + OnTargetConstant.GenericStatus.DELETED + "'")
	List<DocumentKeyValue> getDocumentKeyValueByDocumentId(Integer documentId);

    @Query("select dkv.value from DocumentKeyValue dkv  where dkv.key like 'atten%' and dkv.document.id=?1 and dkv.status !='"+OnTargetConstant.GenericStatus.DELETED+"'")
    List<String> findAllAttentionUsersByDocumentRFI(Integer documentId);

}
