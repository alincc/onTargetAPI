package com.ontarget.api.service;


import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.ProjectBimFileElementToTaskLinkRequest;
import com.ontarget.response.bean.ProjectBimFileElementTaskLinkResponse;
import org.springframework.stereotype.Service;

/**
 * Created by TRON on 1/19/2016.
 */
@Service
public interface ProjectBimFileElementTaskLinkService {

   public ProjectBimFileElementTaskLinkResponse save(ProjectBimFileElementToTaskLinkRequest request) throws Exception;


    public OnTargetResponse delete(ProjectBimFileElementToTaskLinkRequest request) throws Exception;


}
