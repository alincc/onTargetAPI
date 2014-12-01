package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.Project;
import com.ontarget.bean.User;
import com.ontarget.dto.*;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Owner on 11/6/14.
 */
public interface ProjectService {

    public OnTargetResponse addProject(ProjectRequest request) throws Exception;

    public OnTargetResponse updateProject(ProjectRequest request) throws Exception;

    public ProjectResponse getProjectDetail(int projectId) throws Exception;

    public ProjectListResponse getProjectsByCompany(int companyId, int userId) throws Exception;

    public ProjectListResponse getProjectsByUser(int userId) throws Exception;

    public ProjectMemberListResponse getProjectMembers(long projectId) throws Exception;

    public Project getProject(long projectId) throws Exception;
}
