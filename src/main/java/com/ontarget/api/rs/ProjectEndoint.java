package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.bean.Company;
import com.ontarget.dto.*;
import com.ontarget.request.bean.ProjectRequest;
import com.ontarget.request.bean.ProjectCompanyRequest;
import com.ontarget.request.bean.ProjectDetailRequest;
import com.ontarget.request.bean.ProjectUserRequest;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectEndoint {

	public OnTargetResponse addProject(@Valid ProjectRequest request);

	public ProjectResponse getProjectDetail(
			ProjectDetailRequest projectDetailRequest);

	public com.ontarget.dto.ProjectListResponse getProjectByCompany(
			ProjectCompanyRequest projectCompanyRequest);

	public ListResponse<Company> getCompanyByProject(
			ProjectDetailRequest projectDetailRequest);

	public ProjectListResponse getProjectByUser(
			ProjectUserRequest projectUserRequest);

	public ProjectMemberListResponse getProjectMembers(
			ProjectDetailRequest projectDetailRequest);
}
