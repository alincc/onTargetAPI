package com.ontarget.api.repository;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectBimFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileRepository extends JpaRepository<ProjectBimFile, Integer> {

    @Query("select p from ProjectBimFile p where p.project.id = ?1 and p.status != '" + OnTargetConstant.GenericStatus.DELETED + "'")
    List<ProjectBimFile> findByProjectId(int projectId);

}
