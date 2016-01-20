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

    ProjectBimFileElementTaskLinkResponse linkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request);

    OnTargetResponse unlinkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementToTaskLinkRequest request);

}
