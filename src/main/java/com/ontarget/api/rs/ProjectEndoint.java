package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectRequest;
import com.ontarget.dto.ProjectResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectEndoint {

    public OnTargetResponse addProject(ProjectRequest request);

    public ProjectResponse getProjectDetail(int projectId);

    public com.ontarget.dto.ProjectListResponse getProjectByCompany( int companyId, int userId);

    public ProjectListResponse getProjectByUser(int userId);
}
