package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.TaskComment;

public interface TaskCommentRepository extends JpaRepository<TaskComment, Integer> {
	
	TaskComment findByTaskCommentId(Integer taskCommentId);

}
