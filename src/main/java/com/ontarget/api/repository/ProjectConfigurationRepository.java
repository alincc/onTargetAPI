package com.ontarget.api.repository;

import com.ontarget.entities.ProjectConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectConfigurationRepository extends JpaRepository<ProjectConfiguration, Integer>{

    @Query("SELECT pc from ProjectConfiguration pc where pc.project.projectId=?1 and pc.configKey='UNIT_OF_MEASUREMENT'")
    ProjectConfiguration findByProjectId(Integer projectId);
}
