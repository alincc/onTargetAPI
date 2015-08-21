package com.ontarget.api.repository;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.TaskPercentageLog;

public interface TaskPercentageLogRepository extends JpaRepository<TaskPercentageLog, Integer> {

	TaskPercentageLog findByTaskPercentageLogId(Integer id);

	@Query(value = "SELECT sum(amount) FROM account_transaction WHERE account_id = :accountId", nativeQuery = true)
	BigDecimal getAccountBalance(@Param("accountId") Long accountId);

	@Query(value = "SELECT SUM(tpl.percentage_complete) from task_percentage_log tpl "
			+ " JOIN project_task pt ON(pt.project_task_id=tpl.task_id) WHERE pt.project_id = :activityId", nativeQuery = true)
	Double getActivityTotalPercentageComplete(@Param("activityId") Integer activityId);

	@Query(value = "SELECT COUNT(tpl.percentage_complete) from task_percentage_log tpl "
			+ " JOIN project_task pt ON(pt.project_task_id=tpl.task_id) WHERE pt.project_id = :activityId", nativeQuery = true)
	BigInteger getActivityTaskCount(@Param("activityId") Integer activityId);

	@Query(value = "SELECT SUM(tpl.percentage_complete) from project p JOIN task_percentage_log tpl "
			+ " JOIN project_task pt ON(pt.project_task_id=tpl.task_id) WHERE p.project_status !=" + OnTargetConstant.ProjectStatus.DELETED
			+ " and p.project_parent_id = :projectId", nativeQuery = true)
	Double getProjectTotalPercentageComplete(@Param("projectId") Integer projectId);

	@Query(value = "SELECT COUNT(tpl.percentage_complete) from project p JOIN task_percentage_log tpl "
			+ " JOIN project_task pt ON(pt.project_task_id=tpl.task_id) WHERE p.project_status !=" + OnTargetConstant.ProjectStatus.DELETED
			+ " and p.project_parent_id = :projectId", nativeQuery = true)
	BigInteger getProjectTaskCount(@Param("projectId") Integer projectId);

}
