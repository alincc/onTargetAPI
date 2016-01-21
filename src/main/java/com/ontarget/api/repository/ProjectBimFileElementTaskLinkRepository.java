package com.ontarget.api.repository;

import com.ontarget.entities.ProjectBimFileElementTaskLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by TRON on 1/18/2016.
 */
public interface ProjectBimFileElementTaskLinkRepository extends JpaRepository<ProjectBimFileElementTaskLink, Long> {

    @Query("select b from ProjectBimFileElementTaskLink b where b.projectBimFile.projectBimFileId=?1 and b.elementId=?2 and b.status='ACTIVE'")
    ProjectBimFileElementTaskLink findByBimFileIdElementId(Integer projectBimFileId, long elementId);
}
