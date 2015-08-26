package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.ProjectFileCategory;

public interface ProjectFileCategoryRepository extends JpaRepository<ProjectFileCategory, Integer> {

	List<ProjectFileCategory> findByActive(String active);
}
