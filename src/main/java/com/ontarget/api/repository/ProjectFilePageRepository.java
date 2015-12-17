package com.ontarget.api.repository;

import com.ontarget.entities.ProjectFilePage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/16/15.
 */
public interface ProjectFilePageRepository extends JpaRepository<ProjectFilePage, Integer> {


    @Query("select p from ProjectFilePage p join p.projectFile where p.projectFile.projectFileId=?1 order by p.projectFilePageId")
    public List<ProjectFilePage> findPagesByProjectFileId(Integer projectFileId);
}
