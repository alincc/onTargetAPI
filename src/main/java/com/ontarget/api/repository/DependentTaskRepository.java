package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.DependentTask;

public interface DependentTaskRepository extends JpaRepository<DependentTask, Long>{

}
