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

    private Logger logger = Logger.getLogger(ProjectBimFileElementTaskLinkDAOImpl.class);


    @Resource
    private ProjectBimFileElementTaskLinkRepository projectBimFileElementTaskLinkRepository;


    @Override
    public ProjectBimFileElementTaskLink saveLinkBimFileToTask(ProjectBimFileElementTaskLink projectBimFileElementTaskLink) {
        projectBimFileElementTaskLinkRepository.save(projectBimFileElementTaskLink);
        projectBimFileElementTaskLink.setStatus(OnTargetConstant.ProjectBimFileElementTaskLinkStatus.DELETED);
        logger.info("persist link: " + projectBimFileElementTaskLink.getProjectBimFileElementTaskLinkId());
        return projectBimFileElementTaskLink;
    }

    @Override
    public boolean unLinkBimFileToTask(ProjectBimFileElementTaskLink  projectBimFileElementTaskLink) {
        logger.debug("Unlinking bim file element task::"+ projectBimFileElementTaskLink.getElementId());
        projectBimFileElementTaskLink = projectBimFileElementTaskLinkRepository.findByBimFileIdElementId(projectBimFileElementTaskLink.getProjectBimFile().getProjectBimFileId(), projectBimFileElementTaskLink.getElementId());
        projectBimFileElementTaskLink.setStatus(OnTargetConstant.ProjectBimFileElementTaskLinkStatus.DELETED);
        projectBimFileElementTaskLinkRepository.save(projectBimFileElementTaskLink);
        return projectBimFileElementTaskLink.getStatus().equals(OnTargetConstant.ProjectBimFileElementTaskLinkStatus.DELETED);
    }




}
