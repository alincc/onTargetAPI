package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.ActivityCategory;

public interface ActivityCategoryRepository extends JpaRepository<ActivityCategory, Long>{

}
