package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.DocumentSubmittal;

public interface DocumentSubmittalRepository extends JpaRepository<DocumentSubmittal, Integer>{
	
	DocumentSubmittal findByDocumentSubmittalId(Integer documentSubmittalId);

}
