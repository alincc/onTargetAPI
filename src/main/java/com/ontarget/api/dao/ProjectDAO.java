package com.ontarget.api.dao;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.Company;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.bean.ProjectMember;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectConfiguration;

/**
 * Created by Owner on 11/5/14.
 */
public interface ProjectDAO {

	public int addProject(ProjectDTO project, int userId) throws Exception;

	public int addActivity(ProjectDTO projectDTO, int userId) throws Exception;

	public int addMainProject(ProjectDTO projectDTO, CompanyInfo companyInfo, int userId) throws Exception;

	public ProjectDTO getProject(int projectId) throws Exception;

	public ProjectInfo getProjectInfo(int projectId) throws Exception;

	public ProjectDTO getProjectAndSubProjects(int projectId) throws Exception;

	public List<Map<String, Object>> getProjectByCompany(int companyId, int userId) throws Exception;

	public boolean updateProject(ProjectDTO project, int updatingUserId) throws Exception;

	public boolean updateActivity(ProjectDTO projectDTO, int updatingUserId) throws Exception;

	public List<ProjectMember> getProjectMembers(int projectId) throws Exception;

	public int addProjectMember(int projectId, int userId);

	public List<Map<String, Object>> getProjectByUser(int userId);

	public Project getMainProjectByUser(int userId);

	public List<ProjectInfo> getChildProjects(int projectId) throws Exception;

	public List<Company> getCompanyByProject(int projectId) throws Exception;

	public List<Project> getUndeletedProjectsByParentId(Integer parentProjectId);

	public Project findProjectById(int projectId) throws Exception;

	public boolean deleteProject(int projectId, int userId) throws Exception;

	public ProjectConfiguration getProjectUnitOfMeasureMent(Integer projectId);

	public List<Project> getAlllAssociatedProjectsByUser(int userId);

	public List<Project> getUndeletedProjectsByParentIdAndUserId(Integer parentProjectId, int userId);

	public com.ontarget.response.bean.Project getProjectById(int projectId) throws Exception;
	
	public List<Project> getProjectsByUserId(Integer userId);

    public boolean isExistsProjectFolderName(String projectFolderName) throws Exception;

    public boolean updateProjectAssetFolderName(Integer projectId, String projectFolderName) throws Exception;
}
