package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.CompanyListResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectMemberListResponse;
import com.ontarget.dto.ProjectResponse;
import com.ontarget.request.bean.ActivityRequest;
import com.ontarget.request.bean.ProjectDetailRequest;
import com.ontarget.request.bean.ProjectRequest;
import com.ontarget.request.bean.ProjectUserRequest;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectEndoint {

	public OnTargetResponse addProject(@Valid ProjectRequest request);

	public OnTargetResponse addActivity(@Valid ActivityRequest request);

	public com.ontarget.response.bean.ProjectResponse getProjectDetail(@Valid ProjectDetailRequest projectDetailRequest);

	public CompanyListResponse getCompanyByProject(@Valid ProjectDetailRequest projectDetailRequest);

	public ProjectMemberListResponse getProjectMembers(@Valid ProjectDetailRequest projectDetailRequest);

	public ProjectResponse deleteProject(ProjectDetailRequest projectDetailRequest);

	public ProjectListResponse getProjectByUser(@Valid ProjectUserRequest projectUserRequest);

	public ProjectListResponse getUserProjectList(@Valid ProjectUserRequest projectUserRequest);

	public com.ontarget.response.bean.ProjectListResponse getActivityOfProject(@Valid ProjectDetailRequest projectDetailRequest);
}
