package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectFile;

public interface ProjectFileRepository extends JpaRepository<ProjectFile, Integer> {

	@Query("select p from ProjectFile p where p.projectFileId =?1")
	ProjectFile findById(Integer projectFileId);

	@Query("select p from ProjectFile p where p.project.id = ?1 and p.status != '" + OnTargetConstant.ProjectFileStatus.DELETED + "'")
	List<ProjectFile> getProjectFilesByProjectId(Integer projectId);

}
