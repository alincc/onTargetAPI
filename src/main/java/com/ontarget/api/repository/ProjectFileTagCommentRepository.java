package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectFileTagComment;

public interface ProjectFileTagCommentRepository extends JpaRepository<ProjectFileTagComment, Long> {

	@Query("select p from ProjectFileTagComment p where p.projectFileTag.projectFileTagId = ?1 and p.status !='"
			+ OnTargetConstant.GenericStatus.DELETED + "' order by p.projectFileTagCommentId desc")
	List<ProjectFileTagComment> findCommentsByFileTag(Long projectFileTagId);

	@Query("select p from ProjectFileTagComment p where p.projectFileTagCommentId = ?1")
	ProjectFileTagComment findById(Long projectFileTagCommentId);
}
