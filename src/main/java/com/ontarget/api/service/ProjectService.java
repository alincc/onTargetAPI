package com.ontarget.api.service;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectRequest;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectService {

    public OnTargetResponse addProject(ProjectRequest request) throws Exception;

}
