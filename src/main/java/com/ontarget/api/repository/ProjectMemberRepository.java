package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.ProjectMember;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Integer>{

	
}
