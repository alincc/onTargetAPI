package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long>{
	
	List<ActivityLog> findByIdGreaterThan(Long id);

}
