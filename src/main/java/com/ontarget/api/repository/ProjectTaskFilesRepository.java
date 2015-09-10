package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectTaskFiles;

public interface ProjectTaskFilesRepository extends JpaRepository<ProjectTaskFiles, Integer> {

	ProjectTaskFiles findByTaskFileId(Integer taskFileId);

	@Query("select p from ProjectTaskFiles p where p.projectTask.projectTaskId = ?1 and p.status != '"
			+ OnTargetConstant.ProjectTaskFileStatus.DELETED + "'")
	List<ProjectTaskFiles> getProjectTaskFilesByTaskId(Integer projectTaskId);

}
