package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.Company;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectMemberListResponse;
import com.ontarget.dto.UserProjectListResponse;
import com.ontarget.entities.Project;
import com.ontarget.request.bean.ActivityRequest;
import com.ontarget.request.bean.ProjectRequest;
import com.ontarget.response.bean.ProjectResponse;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectService {

	public com.ontarget.response.bean.ProjectResponse addProject(ProjectRequest request) throws Exception;

	public com.ontarget.response.bean.ProjectResponse updateProject(ProjectRequest request) throws Exception;

	public OnTargetResponse addActivity(ActivityRequest request) throws Exception;

	public OnTargetResponse updateActivity(ActivityRequest request) throws Exception;

	public com.ontarget.response.bean.ProjectResponse getProjectDetail(int projectId);

	public ProjectListResponse getProjectsByCompany(int companyId, int userId) throws Exception;

	public List<Company> getCompanyByProject(int projectId) throws Exception;

	public ProjectListResponse getProjectsByUser(int userId) throws Exception;

	public ProjectMemberListResponse getProjectMembers(int projectId) throws Exception;

	public ProjectInfo getProject(int projectId) throws Exception;

	public ProjectInfo getProjectTree(int projectId) throws Exception;

	public ProjectListResponse getUserProjectDetails(int userId) throws Exception;

	public boolean deleteProject(int projectId, int userId);

	public UserProjectListResponse getUserAssociatedProjectDetails(int userId) throws Exception;

	public ProjectListResponse getUserProjectList(Integer userId) throws Exception;

    public ProjectListResponse getUserProjectListV1(Integer userId) throws Exception;

    public com.ontarget.response.bean.ProjectListResponse getActivityOfProject(Integer projectId) throws Exception;

	public com.ontarget.entities.Project findProjectById(int projectId) throws Exception;

    public ProjectResponse updateProjectArn(String projectArn, int projectId) throws Exception;
}
