package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectRequest;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectEndpoint {

    public OnTargetResponse addProject(ProjectRequest request);


}
