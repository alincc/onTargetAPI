package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.TaskAssignee;

public interface TaskAssigneeRepository extends JpaRepository<TaskAssignee, Integer> {

	TaskAssignee findByTaskAssigneeId(Integer taskAssigneeId);
	
	@Query("select ta from TaskAssignee ta join ta.projectTask pt where pt.projectTaskId = ?1")
	List<TaskAssignee> getAllTaskAssigneeByTaskId(int projectTaskId);
}
