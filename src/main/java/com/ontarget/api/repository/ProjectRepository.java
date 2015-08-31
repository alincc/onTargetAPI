package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	Project findByProjectId(Integer id);

	List<Project> findByProjectParentId(Integer projectId);

	@Query("select p from Project p where p.projectParentId = ?1 and p.projectStatus !=" + OnTargetConstant.ProjectStatus.DELETED)
	List<Project> findUndeletedProjectsByProjectParentId(Integer parentProjectId);

	@Query("select p from Project p join p.projectMemberList pm where p.projectParentId = ?1 and pm.user.userId = ?2 and p.projectStatus !="
			+ OnTargetConstant.ProjectStatus.DELETED)
	List<Project> findUndeletedProjectsByProjectParentIdAndUserId(Integer parentProjectId, int userId);

	@Query("select p from Project p JOIN p.projectMemberList pm where pm.user.userId = ?1 and p.projectParentId = 0 and p.projectStatus !="
			+ OnTargetConstant.ProjectStatus.DELETED)
	Project getUserMainProject(Integer userId);

	@Query("select p from Project p JOIN p.projectMemberList pm where pm.user.userId = ?1 and p.projectStatus !="
			+ OnTargetConstant.ProjectStatus.DELETED)
	List<Project> findAlllAssociatedProjectsByUser(Integer userId);

	@Query("select count(p) from Project p join p.projectMemberList pm where pm.user.userId = ?1 and p.projectId = ?2")
	Long countUserProject(Integer userId, Integer projectId);

	@Query("select p from Project p join p.projectMemberList pm where pm.user.userId = ?1 and p.projectParentId !=0 and p.projectStatus !="
			+ OnTargetConstant.ProjectStatus.DELETED)
	List<Project> getProjectsByUserId(Integer userId);

    @Query("select p from Project p where p.projectAssetFolderName=?1")
    Project getProjectByProjectFolderName(String projectFolderName);
}
