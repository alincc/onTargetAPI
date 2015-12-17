package com.ontarget.api.jpa.dao.impl;

import com.ontarget.api.dao.ProjectFilePageDAO;
import com.ontarget.api.repository.ProjectFilePageRepository;
import com.ontarget.entities.ProjectFilePage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/16/15.
 */
@Repository
public class ProjectFilePageJPADAOImpl implements ProjectFilePageDAO {

    private Logger logger = Logger.getLogger(ProjectFilePageJPADAOImpl.class);

    @Autowired
    private ProjectFilePageRepository projectFilePageRepository;

    @Override
    public ProjectFilePage save(ProjectFilePage projectFilePage) throws Exception {
        logger.debug("Saving project file page information");
        return projectFilePageRepository.save(projectFilePage);
    }

    @Override
    public List<ProjectFilePage> getPagesForProjectFile(Integer projectFileId) throws Exception {
        logger.debug("Fetching list of project file page for project file: "+ projectFileId);
        return projectFilePageRepository.findPagesByProjectFileId(projectFileId);
    }



}
