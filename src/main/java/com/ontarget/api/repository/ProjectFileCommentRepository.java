package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProjectFileComment;

public interface ProjectFileCommentRepository extends JpaRepository<ProjectFileComment, Integer> {

	@Query("select c from ProjectFileComment c where c.commentStatus !='DELETED' AND c.projectFile.projectFileId = ?1 order by c.projectFileCommentId desc")
	List<ProjectFileComment> findCommentsByFileId(Integer projectFileId);
}
