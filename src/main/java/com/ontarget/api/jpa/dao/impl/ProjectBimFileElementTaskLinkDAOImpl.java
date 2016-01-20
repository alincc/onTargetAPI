package com.ontarget.api.jpa.dao.impl;

import com.ontarget.api.dao.ProjectBimFileElementTaskLinkDAO;
import com.ontarget.api.repository.ProjectBimFileElementTaskLinkRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectBimFileElementTaskLink;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by TRON on 1/18/2016.
 */
@Repository("ProjectBimFileElementTaskLinkDAOImpl")
public class ProjectBimFileElementTaskLinkDAOImpl implements ProjectBimFileElementTaskLinkDAO {
    private Logger logger = Logger.getLogger(CompanyJpaDAOImpl.class);


    @Resource
    private ProjectBimFileElementTaskLinkRepository projectBimFileElementTaskLinkRepository;


    @Override
    public ProjectBimFileElementTaskLink saveLinkBimFileToTask(ProjectBimFileElementTaskLink projectBimFileElementTaskLink) {

        projectBimFileElementTaskLinkRepository.save(projectBimFileElementTaskLink);
        logger.info("persist link: " + projectBimFileElementTaskLink.getProjectBimFileElementTaskLinkId());

        return projectBimFileElementTaskLink;
    }

    @Override
    public ProjectBimFileElementTaskLink unLinkBimFileToTask(ProjectBimFileElementTaskLink  projectBimFileElementTaskLink) {
        ProjectBimFileElementTaskLink projectBimFileElementTaskLink1 = projectBimFileElementTaskLinkRepository.findByLinkId(id);
        projectBimFileElementTaskLink1.setStatus(OnTargetConstant.ProjectBimFileElementTaskLinkStatus.DELETED);
        projectBimFileElementTaskLinkRepository.save(projectBimFileElementTaskLink1);
    }




}
