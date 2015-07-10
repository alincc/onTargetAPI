package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.TaskFieldWorker;

public interface TaskFieldWorkerRepository extends JpaRepository<TaskFieldWorker, Integer> {

	TaskFieldWorker findByTaskFieldWorkerId(Integer taskFieldWorkerId);

	@Query("select tf from TaskFieldWorker tf join tf.projectTask pt where pt.projectTaskId = ?1")
	List<TaskFieldWorker> getAllFieldworkersByTaskId(int projectTaskId);

}
