package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ApplicationFeature;

public interface ApplicationFeatureRepository extends JpaRepository<ApplicationFeature, Integer> {
	@Query("select a from ApplicationFeature a where a.active = ?1")
	List<ApplicationFeature> findApplicationPermissionByActive(Character active);
}
