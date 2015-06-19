package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ApplicationPermission;

public interface ApplicationPermissionRepository extends JpaRepository<ApplicationPermission, Integer> {
	@Query("select a from ApplicationPermission a where a.active = ?1")
	List<ApplicationPermission> findApplicationPermissionByActive(Character active);
}
