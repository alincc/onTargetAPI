package com.ontarget.api.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectTask;

public interface TaskBurnDownRepository extends JpaRepository<ProjectTask, Integer> {

	@Query(value = "SELECT COUNT(1) FROM project p JOIN project_task pt ON(p.project_id=pt.project_id) where p.project_id = ?1"
			+ " AND (pt.status=" + OnTargetConstant.TaskStatus.COMPLETED + " AND ?2>=DATE(pt.modified_date))", nativeQuery = true)
	BigInteger getCompletedTaskCount(Integer projectId, String toDate);

	@Query(value = "SELECT COUNT(1) FROM project p JOIN project_task pt ON(p.project_id=pt.project_id) where p.project_id = ?1"
			+ " AND ?2>=DATE(pt.start_date) and (pt.status=" + OnTargetConstant.TaskStatus.COMPLETED + " AND ?2<DATE(pt.modified_date))", nativeQuery = true)
	BigInteger getIncompletTaskCount(Integer projectId, String toDate);
}
