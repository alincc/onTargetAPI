package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProjectFileTag;

public interface ProjectFileTagRepository extends JpaRepository<ProjectFileTag, Long> {

	@Query("select p from ProjectFileTag p where p.fileId = ?1 order by p.projectFileTagId desc")
	List<ProjectFileTag> findRecentByProjectFileId(Integer projectFileId, Pageable pageable);

}
