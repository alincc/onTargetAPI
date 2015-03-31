package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.TaskPercentageLog;

public interface TaskPercentageLogRepository extends JpaRepository<TaskPercentageLog, Integer> {

}
