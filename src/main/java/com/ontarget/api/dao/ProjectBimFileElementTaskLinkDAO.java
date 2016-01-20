package com.ontarget.api.dao;


import com.ontarget.entities.ProjectBimFileElementTaskLink;

/**
 * Created by TRON on 1/18/2016.
 */
public interface ProjectBimFileElementTaskLinkDAO {

    ProjectBimFileElementTaskLink saveLinkBimFileToTask(ProjectBimFileElementTaskLink projectBimFileElementTaskLink);

    ProjectBimFileElementTaskLink unLinkBimFileToTask(ProjectBimFileElementTaskLink projectBinFileElementTaskLink);

}
