package com.ontarget.api.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProjectFileTagTaskLink;

public interface ProjectFileTagTaskLinkRepository extends JpaRepository<ProjectFileTagTaskLink, Serializable> {

	@Query("select p from ProjectFileTagTaskLink p where p.projectFileTag.projectFileTagId = ?1 and p.projectTask.projectTaskId = ?2")
	ProjectFileTagTaskLink findByTagIdAndFileId(Long tagId, Integer taskId);
}
