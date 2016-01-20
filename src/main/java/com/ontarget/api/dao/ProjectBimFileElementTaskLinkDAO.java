package com.ontarget.api.dao;


import com.ontarget.entities.ProjectBimFileElementTaskLink;

/**
 * Created by TRON on 1/18/2016.
 */
public interface ProjectBimFileElementTaskLinkDAO {

    public ProjectBimFileElementTaskLink saveLinkBimFileToTask(ProjectBimFileElementTaskLink projectBimFileElementTaskLink) throws  Exception;

    public boolean unLinkBimFileToTask(ProjectBimFileElementTaskLink projectBinFileElementTaskLink) throws  Exception;


    public ProjectBimFileElementTaskLink getLinkBimFileToTask(Integer projectBimFileId, Long projectElementId) throws Exception;

}
