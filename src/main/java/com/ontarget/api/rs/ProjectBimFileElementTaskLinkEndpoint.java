package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.ProjectBimFileElementTaskLink;
import com.ontarget.request.bean.ProjectBimFileElementToTaskLinkRequest;
import com.ontarget.response.bean.ProjectBimFileElementTaskLinkResponse;


import javax.validation.Valid;

/**
 * Created by TRON on 1/19/2016.
 */
public interface ProjectBimFileElementTaskLinkEndpoint {

    public ProjectBimFileElementTaskLinkResponse linkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request);

    public OnTargetResponse unlinkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request);

    public ProjectBimFileElementTaskLinkResponse getProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request);

}
