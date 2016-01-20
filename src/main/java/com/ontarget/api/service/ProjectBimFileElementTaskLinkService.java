package com.ontarget.api.service;


import com.ontarget.entities.ProjectBimFileElementTaskLink;

/**
 * Created by TRON on 1/19/2016.
 */
public interface ProjectBimFileElementTaskLinkService {

    ProjectBimFileElementTaskLink save(ProjectBimFileElementTaskLink projectBimFileElementTaskLink) throws Exception;


    ProjectBimFileElementTaskLink delete(ProjectBimFileElementTaskLink projectBimFileElementTaskLink) throws Exception;



}
