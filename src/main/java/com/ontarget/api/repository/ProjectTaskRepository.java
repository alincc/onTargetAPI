package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProjectTask;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {
	ProjectTask findByProjectTaskId(Integer projectTaskId);

	@Query("select pt from ProjectTask pt where pt.parentTaskId = ?1")
	List<ProjectTask> getAllTaskByParentTaskId(Integer parentTaskId);

	@Query("select pt from DependentTask dt join dt.projectTask pt where dt.projectTask.projectTaskId = ?1")
	List<ProjectTask> getAllDependentTaskByTaskId(Integer projectTaskId);

	@Query("select pt from TaskAssignee ta join ta.projectTask pt where ta.taskAssignee = ?1")
	List<ProjectTask> getAllTaskByAssignee(Long taskAssignee);

	// select *,if(status='COMPLETED',true,false) as completed from project_task
	// t where t.project_id in
	// ( select p.project_id from project p where p.project_id=? or
	// p.project_parent_id=?)
	// and t.status=? and t.modified_date <= t.end_date
	@Query("select pt from ProjectTask pt where pt.project.id in(select projectId from Project where projectId = ?1 and projectParentId = ?2)"
			+ " and pt.status = ?3 and pt.modifiedDate <= pt.endDate")
	List<ProjectTask> getTasksByProjectIdAndStatus(Integer projectId, Integer projectParentId, Integer status);
}
