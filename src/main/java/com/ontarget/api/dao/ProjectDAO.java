package com.ontarget.api.dao;

import com.ontarget.bean.Project;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/5/14.
 */
public interface ProjectDAO {

    public int addProject(Project project) throws Exception;

    public Project getProject(int projectId) throws Exception;

    Project getProjectAndSubProjects(int projectId) throws Exception;

    public List<Map<String, Object>> getProjectByCompany(int companyId, int userId) throws Exception;

    public boolean updateProject(Project project) throws Exception;
}
