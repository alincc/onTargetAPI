package com.ontarget.api.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectTask;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {
	ProjectTask findByProjectTaskId(Integer projectTaskId);

	@Query("select pt from ProjectTask pt where pt.parentTaskId = ?1")
	List<ProjectTask> getAllTaskByParentTaskId(Integer parentTaskId);

	@Query("select pt from DependentTask dt join dt.projectTask pt where dt.projectTask.projectTaskId = ?1")
	List<ProjectTask> getAllDependentTaskByTaskId(Integer projectTaskId);

	@Query("select pt from TaskAssignee ta join ta.projectTask pt where ta.taskAssignee = ?1")
	List<ProjectTask> getAllTaskByAssignee(Long taskAssignee);

	@Query("select pt from ProjectTask pt where pt.project.id in(select projectId from Project where projectId = ?1 and projectParentId = ?2)"
			+ " and pt.status = ?3 and pt.modifiedDate <= pt.endDate")
	List<ProjectTask> getTasksByProjectIdAndStatus(Integer projectId, Integer projectParentId, Integer status);

	@Query("select pt from ProjectTask pt where pt.project.id = ?1 and pt.status !=" + OnTargetConstant.TaskStatus.DELETED)
	List<ProjectTask> findUndeletedTasksByProject(Integer projectId);

	@Query("select pt from ProjectTask pt JOIN pt.taskAssigneeList ta WHERE pt.project.id = ?1 and ta.taskAssignee = ?2 and pt.status !="
			+ OnTargetConstant.TaskStatus.DELETED)
	List<ProjectTask> findUndeletedTasksByActivityAndUser(Integer projectId, Integer userId);

	@Query(value = "SELECT SUM(pt.task_percentage) from project_task pt WHERE pt.status !='" + OnTargetConstant.TaskStatus.DELETED + "'"
			+ " AND pt.project_id = :activityId", nativeQuery = true)
	BigDecimal getActivityTotalPercentageComplete(@Param("activityId") Integer activityId);

	@Query(value = "SELECT COUNT(pt.task_percentage) from project_task pt WHERE pt.status !=" + OnTargetConstant.TaskStatus.DELETED
			+ " AND pt.project_id = :activityId", nativeQuery = true)
	BigInteger getActivityTaskCount(@Param("activityId") Integer activityId);

	@Query(value = "SELECT SUM(pt.task_percentage) from project p JOIN project_task pt ON(pt.project_id=p.project_id) "
			+ " WHERE pt.status !=" + OnTargetConstant.TaskStatus.DELETED + " AND p.project_status !="
			+ OnTargetConstant.ProjectStatus.DELETED + " and p.project_parent_id = :projectId", nativeQuery = true)
	BigDecimal getProjectTotalPercentageComplete(@Param("projectId") Integer projectId);

	@Query(value = "SELECT COUNT(pt.task_percentage) from project p JOIN project_task pt ON(pt.project_id=p.project_id) "
			+ " WHERE pt.status !=" + OnTargetConstant.TaskStatus.DELETED + " AND p.project_status !="
			+ OnTargetConstant.ProjectStatus.DELETED + " and p.project_parent_id = :projectId", nativeQuery = true)
	BigInteger getProjectTaskCount(@Param("projectId") Integer projectId);

	@Query(value = "select pt.* from project_task pt , task_assignee ta WHERE pt.project_task_id=ta.project_task_id and pt.project_id in (select project_id from  project where project_parent_id=?1 and project_status!=2) and ta.task_Assignee =?2 and pt.status !=4",nativeQuery = true)
	List<ProjectTask> findAllUndeletedTasksByProjectAndUser(Integer projectId, Integer userId);
}