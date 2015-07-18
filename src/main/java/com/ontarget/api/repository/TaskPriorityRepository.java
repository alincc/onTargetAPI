package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.TaskPriority;

public interface TaskPriorityRepository extends JpaRepository<TaskPriority, Integer> {

	@Query("select tp from TaskPriority tp")
	List<TaskPriority> getAllTaskPriority();

}
