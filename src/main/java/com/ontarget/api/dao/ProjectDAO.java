package com.ontarget.api.dao;

import com.ontarget.bean.Company;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectMember;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/5/14.
 */
public interface ProjectDAO {

	public int addProject(ProjectDTO project) throws Exception;

	public ProjectDTO getProject(int projectId) throws Exception;

	public ProjectDTO getProjectAndSubProjects(int projectId) throws Exception;

	public List<Map<String, Object>> getProjectByCompany(int companyId,
			int userId) throws Exception;

	public boolean updateProject(ProjectDTO project, int updatingUserId)
			throws Exception;

	public List<ProjectMember> getProjectMembers(int projectId)
			throws Exception;

	public int addProjectMember(int projectId, int userId);

	public List<Map<String, Object>> getProjectByUser(int userId);

	public List<ProjectDTO> getChildProjects(int projectId) throws Exception;

	public List<Company> getCompanyByProject(int projectId) throws Exception;
}
