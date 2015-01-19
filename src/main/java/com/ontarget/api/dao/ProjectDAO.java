package com.ontarget.api.dao;

import com.ontarget.bean.Project;
import com.ontarget.bean.ProjectMember;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/5/14.
 */
public interface ProjectDAO {

    public int addProject(Project project) throws Exception;

    public Project getProject(long projectId) throws Exception;

    public Project getProjectAndSubProjects(long projectId) throws Exception;

    public List<Map<String,Object>> getProjectByCompany(int companyId, int userId) throws Exception;

    public boolean updateProject(Project project, int updatingUserId) throws Exception;

    public List<ProjectMember> getProjectMembers(long projectId) throws Exception;

    public int addProjectMember(long projectId, int userId);

    public List<Map<String,Object>> getProjectByUser(int userId);

    public List<Project> getChildProjects(long projectId) throws Exception;

    public List<Integer> getCompanyByProject(int projectId) throws Exception;
}
