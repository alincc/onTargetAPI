package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long>{
	
	List<ActivityLog> findByIdGreaterThan(Long id);
	
	@Query("select u from ActivityLog u where u.projectId = ? order by u.id desc")
	Page<ActivityLog> findActivityLogsByProjectId(Integer projectId, Pageable pageable);

}
