package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ProjectBimFileElementTaskLinkDAO;
import com.ontarget.api.repository.ProjectBimFileElementTaskLinkRepository;
import com.ontarget.api.service.ProjectBimFileElementTaskLinkService;
import com.ontarget.entities.ProjectBimFileElementTaskLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by TRON on 1/19/2016.
 */
@Service
public class ProjectBimFileElementTaskLInkServiceImpl implements ProjectBimFileElementTaskLinkService  {

     @Autowired
    ProjectBimFileElementTaskLinkDAO  projectBimFileElementTaskLinkDAO;

    @Autowired
    ProjectBimFileElementTaskLinkService projectBimFileElementTaskLinkService;

    @Resource
    ProjectBimFileElementTaskLinkRepository projectBimFileElementTaskLinkRepository;



    @Override
    ProjectBimFileElementTaskLink save(ProjectBimFileElementTaskLink projectBimFileElementTaskLink) throws Exception {
        return projectBimFileElementTaskLinkDAO.saveLinkBimFileToTask(projectBimFileElementTaskLink);

    }

    @Override
    ProjectBimFileElementTaskLink delete(ProjectBimFileElementTaskLink projectBimFileElementTaskLink) {
        ProjectBimFileElementTaskLink projectBimFileElementTask1 = projectBimFileElementTaskLinkRepository.findByLinkId(id);
        projectBimFileElementTask1.setStatus(projectBimFileElementTaskLink.getStatus());
        projectBimFileElementTask1.setModifiedDate(new Date());
        projectBimFileElementTask1.setModifiedBy(projectBimFileElementTaskLink.getModifiedBy());
        projectBimFileElementTask1.setElementId(projectBimFileElementTaskLink.getElementId());
        projectBimFileElementTask1.setProjectBimFile(projectBimFileElementTaskLink.getProjectBimFile());


         return  projectBimFileElementTaskLinkDAO.unLinkBimFileToTask(projectBimFileElementTask1);
    }
}
