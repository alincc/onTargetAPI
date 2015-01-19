package com.ontarget.api.rs;

import com.ontarget.dto.*;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectEndoint {

    public OnTargetResponse addProject(ProjectRequest request);

    public ProjectResponse getProjectDetail(int projectId);

    public com.ontarget.dto.ProjectListResponse getProjectByCompany(int companyId, int userId);

    public ListResponse<Integer> getCompanyByProject(int projectId);

    public ProjectListResponse getProjectByUser(int userId);

    public ProjectMemberListResponse getProjectMembers(long projectId);
}
