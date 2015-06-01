package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.TaskAssignee;

public interface TaskAssigneeRepository extends JpaRepository<TaskAssignee, Integer> {

	TaskAssignee findByTaskAssigneeId(Integer taskAssigneeId);
}
