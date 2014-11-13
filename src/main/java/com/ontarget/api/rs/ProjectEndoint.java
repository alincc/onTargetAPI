package com.ontarget.api.rs;

import com.ontarget.bean.Company;
import com.ontarget.bean.User;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectRequest;
import com.ontarget.dto.ProjectResponse;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectEndoint {

    public OnTargetResponse addProject(ProjectRequest request);

    public ProjectResponse getProjectDetail(int projectId);

    public com.ontarget.dto.ProjectListResponse getProjectByCompany(Company company, User user);

}
