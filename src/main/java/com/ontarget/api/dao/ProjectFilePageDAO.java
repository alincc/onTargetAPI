package com.ontarget.api.dao;

import com.ontarget.entities.ProjectFilePage;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/16/15.
 */
public interface ProjectFilePageDAO {

    public ProjectFilePage save(ProjectFilePage projectFilePage) throws  Exception;

    List<ProjectFilePage> getPagesForProjectFile(Integer projectFileId) throws Exception;
}
