package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProjectTaskFiles;

public interface ProjectTaskFilesRepository extends JpaRepository<ProjectTaskFiles, Integer> {

	ProjectTaskFiles findByTaskFileId(Integer taskFileId);

	@Query("select p from ProjectTaskFiles p where p.projectTask.projectTaskId = :projectTaskId")
	List<ProjectTaskFiles> getProjectTaskFilesByTaskId(Integer projectTaskId);

}
