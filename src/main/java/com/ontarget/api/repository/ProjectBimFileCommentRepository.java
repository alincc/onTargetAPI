package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProjectBimFileComment;

public interface ProjectBimFileCommentRepository extends JpaRepository<ProjectBimFileComment, Integer> {

	@Query("select c from ProjectBimFileComment c where c.commentStatus !='DELETED' AND c.projectBimFile.projectBimFileId = ?1 order by c.projectBimFileCommentId desc")
	List<ProjectBimFileComment> findCommentsByFileId(Integer projectFileId);

}
