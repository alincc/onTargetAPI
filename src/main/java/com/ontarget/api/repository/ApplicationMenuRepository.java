package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ApplicationMenu;

public interface ApplicationMenuRepository extends JpaRepository<ApplicationMenu, Integer> {
	@Query("select a from ApplicationMenu a where a.active = ?1")
	List<ApplicationMenu> findApplicationMenuByActive(Character active);
}
