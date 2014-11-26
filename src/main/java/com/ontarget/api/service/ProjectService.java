package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.User;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectListResponse;
import com.ontarget.dto.ProjectRequest;
import com.ontarget.dto.ProjectResponse;
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
}
