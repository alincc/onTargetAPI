package com.ontarget.api.repository;

import com.ontarget.entities.ProjectBimFileElementTaskLink;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TRON on 1/18/2016.
 */
public interface ProjectBimFileElementTaskLinkRepository extends JpaRepository<ProjectBimFileElementTaskLink, Long> {

    ProjectBimFileElementTaskLink findByLinkId(Long projectBimFileElementTaskLink);

}
