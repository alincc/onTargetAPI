package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ProjectBimFileElementTaskLinkDAO;
import com.ontarget.api.service.ProjectBimFileElementTaskLinkService;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.ProjectBimFileElementTaskLink;
import com.ontarget.request.bean.ProjectBimFileElementToTaskLinkRequest;
import com.ontarget.response.bean.ProjectBimFileElementTaskLinkResponse;
import com.ontarget.util.ProjectBimFileElementTaskLinkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by TRON on 1/19/2016.
 */
@Service
public class ProjectBimFileElementTaskLInkServiceImpl implements ProjectBimFileElementTaskLinkService  {

    @Autowired
    ProjectBimFileElementTaskLinkDAO  projectBimFileElementTaskLinkDAO;


    @Override
    public ProjectBimFileElementTaskLinkResponse save(ProjectBimFileElementToTaskLinkRequest request) throws Exception {
        ProjectBimFileElementTaskLink projectBimFileElementTaskLink = ProjectBimFileElementTaskLinkUtil.getBimFileElementLinkEnitityFromBimFileElementLinkRequest(request);
        projectBimFileElementTaskLinkDAO.saveLinkBimFileToTask(projectBimFileElementTaskLink);

        ProjectBimFileElementTaskLinkResponse response = new ProjectBimFileElementTaskLinkResponse();
        response.setProjectBimFileElementTaskLink(projectBimFileElementTaskLink);

        return response;
    }

    @Override
    public OnTargetResponse delete(ProjectBimFileElementToTaskLinkRequest request) throws Exception {
        //create ProjectBimfile link entity from
        ProjectBimFileElementTaskLink projectBimFileElementTaskLink = ProjectBimFileElementTaskLinkUtil.getBimFileElementLinkEnitityFromBimFileElementLinkRequest(request);
        projectBimFileElementTaskLinkDAO.unLinkBimFileToTask(projectBimFileElementTaskLink);
            
        return null;
    }
}
