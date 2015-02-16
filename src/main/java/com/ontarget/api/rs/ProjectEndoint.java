package com.ontarget.api.rs;

import com.ontarget.bean.Company;
import com.ontarget.dto.*;
import com.ontarget.request.bean.ProjectRequestBean;
import com.ontarget.request.bean.ProjectCompanyRequestBean;
import com.ontarget.request.bean.ProjectDetailRequestBean;
import com.ontarget.request.bean.ProjectUserRequestBean;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectEndoint {

	public OnTargetResponse addProject(ProjectRequestBean request);

	public ProjectResponse getProjectDetail(
			ProjectDetailRequestBean projectDetailRequest);

	public com.ontarget.dto.ProjectListResponse getProjectByCompany(
			ProjectCompanyRequestBean projectCompanyRequest);

	public ListResponse<Company> getCompanyByProject(
			ProjectDetailRequestBean projectDetailRequest);

	public ProjectListResponse getProjectByUser(
			ProjectUserRequestBean projectUserRequest);

	public ProjectMemberListResponse getProjectMembers(
			ProjectDetailRequestBean projectDetailRequest);
}
