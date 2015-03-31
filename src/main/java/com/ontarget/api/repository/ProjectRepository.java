package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Project findByProjectId(Integer id);

	List<Project> findByProjectParentId(Integer projectId);

	@Query("select count(p) from Project p join p.projectMemberList pm"
			+ " where p.projectParentId = 0 and pm.user.userId = ?1 and p.projectId = ?2")
	Long countUserInvolvementInProject(Integer userId, Integer projectId);

}
