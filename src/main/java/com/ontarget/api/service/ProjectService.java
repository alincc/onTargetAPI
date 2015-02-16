package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.dto.*;
import com.ontarget.request.bean.ProjectRequestBean;

import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectService {

    public OnTargetResponse addProject(ProjectRequestBean request) throws Exception;

    public OnTargetResponse updateProject(ProjectRequestBean request) throws Exception;

    public ProjectResponse getProjectDetail(long projectId) throws Exception;

    public ProjectListResponse getProjectsByCompany(int companyId, int userId) throws Exception;

    public List<Company> getCompanyByProject(int projectId) throws Exception;

    public ProjectListResponse getProjectsByUser(int userId) throws Exception;

    public ProjectMemberListResponse getProjectMembers(int projectId) throws Exception;

    public ProjectDTO getProject(long projectId) throws Exception;

    public ProjectDTO getProjectTree(long projectId) throws Exception;
}
