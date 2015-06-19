package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ContactPhone;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectInfo;
import com.ontarget.bean.ProjectMember;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.entities.Project;

/**
 * Created by Owner on 11/5/14.
 */
@Repository("projectDAOImpl")
public class ProjectDAOImpl implements ProjectDAO {

	private Logger logger = Logger.getLogger(ProjectDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addProject(ProjectDTO project, int userId) throws Exception {

		logger.info("Adding project: " + project);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.ADD_PROJECT, new String[] { "id" });
				ps.setString(1, project.getProjectName());
				ps.setString(2, project.getProjectDescription());
				ps.setInt(3, project.getProjectTypeId());
				ps.setInt(4, project.getCompanyId());
				ps.setInt(5, project.getProjectAddress().getAddressId());
				ps.setString(6, project.getStatus());
				ps.setInt(7, project.getProjectParentId());
				ps.setDate(8, new java.sql.Date(project.getStartDate().getTime()));
				ps.setDate(9, new java.sql.Date(project.getEndDate().getTime()));
				ps.setLong(10, userId);
				ps.setLong(11, userId);
				ps.setString(10, project.getProjectImagePath());
				ps.setLong(11, project.getProjectOwnerId());

				return ps;
			}
		}, keyHolder);

		logger.debug("Added project with id: " + keyHolder.getKey().intValue());

		return keyHolder.getKey().intValue();
	}

	@Override
	public ProjectDTO getProject(int projectId) throws Exception {

		final ProjectDTO project = new ProjectDTO();

		jdbcTemplate.query(OnTargetQuery.GET_PROJECT, new Object[] { projectId }, new RowMapper<ProjectDTO>() {
			@Override
			public ProjectDTO mapRow(ResultSet resultSet, int i)

			throws SQLException {
				project.setProjectId(projectId);
				project.setProjectName(resultSet.getString("PROJECT_NAME"));
				project.setProjectDescription(resultSet.getString("PROJECT_DESCRIPTION"));
				project.setProjectTypeId(resultSet.getInt("PROJECT_TYPE_ID"));
				project.setProjectParentId(resultSet.getInt("PROJECT_PARENT_ID"));
				project.setCompanyId(resultSet.getInt("COMPANY_ID"));
				project.setProjectOwnerId(resultSet.getInt("project_owner_id"));

				project.setStartDate(resultSet.getDate("project_start_date"));
				project.setEndDate(resultSet.getDate("project_end_date"));

				return project;
			}
		});

		return project;
	}

	@Override
	public ProjectInfo getProjectInfo(int projectId) throws Exception {

		final ProjectInfo project = new ProjectInfo();

		jdbcTemplate.query(OnTargetQuery.GET_PROJECT, new Object[] { projectId }, new RowMapper<ProjectInfo>() {
			@Override
			public ProjectInfo mapRow(ResultSet resultSet, int i) throws SQLException {
				project.setProjectId(projectId);
				project.setProjectName(resultSet.getString("PROJECT_NAME"));
				project.setProjectDescription(resultSet.getString("PROJECT_DESCRIPTION"));
				project.setProjectTypeId(resultSet.getInt("PROJECT_TYPE_ID"));
				project.setProjectParentId(resultSet.getInt("PROJECT_PARENT_ID"));
				project.setCompanyId(resultSet.getInt("COMPANY_ID"));
				project.setProjectOwnerId(resultSet.getInt("project_owner_id"));
				project.setStartDate(resultSet.getDate("project_start_date"));
				project.setEndDate(resultSet.getDate("project_end_date"));

				return project;
			}
		});

		return project;
	}

	public List<ProjectInfo> getChildProjects(int projectId) throws Exception {
		List<ProjectInfo> projects = new LinkedList<>();

		List<Map<String, Object>> rs = jdbcTemplate.queryForList(OnTargetQuery.GET_CHILD_PROJECTS, projectId);
		if (rs != null)
			for (Map<String, Object> row : rs) {
				ProjectInfo project = new ProjectInfo();

				project.setProjectId((int) row.get("project_id"));
				project.setProjectName((String) row.get("PROJECT_NAME"));
				project.setProjectDescription((String) row.get("PROJECT_DESCRIPTION"));
				project.setProjectParentId((int) row.get("PROJECT_PARENT_ID"));
				project.setCompanyId((int) row.get("COMPANY_ID"));
				if (row.containsKey("project_owner_id") && row.get("project_owner_id") != null)
					project.setProjectOwnerId((int) row.get("project_owner_id"));
				Date startDate = (Date) row.get("project_start_date");
				project.setStartDate(startDate);
				Date endDate = (Date) row.get("project_end_date");
				project.setEndDate(endDate);

				projects.add(project);
			}

		return projects;
	}

	@Override
	public ProjectDTO getProjectAndSubProjects(int projectId) throws Exception {

		final ProjectDTO project = new ProjectDTO();

		Map<Integer, List<ProjectDTO>> projectToSubProject = new HashMap<>();

		jdbcTemplate.query(OnTargetQuery.GET_PROJECT_AND_TASKS, new Object[] { projectId }, new RowMapper<ProjectDTO>() {
			@Override
			public ProjectDTO mapRow(ResultSet resultSet, int i)

			throws SQLException {

				int parentProjectId = resultSet.getInt("PROJECT_PARENT_ID");
				int projectId = resultSet.getInt("PROJECT_ID");

				ProjectDTO project1 = new ProjectDTO();

				project1.setProjectId(projectId);
				project1.setProjectName(resultSet.getString("PROJECT_NAME"));
				project1.setProjectDescription(resultSet.getString("PROJECT_DESCRIPTION"));
				project1.setProjectTypeId(resultSet.getInt("PROJECT_TYPE_ID"));
				project1.setProjectParentId(parentProjectId);
				project1.setCompanyId(resultSet.getInt("COMPANY_ID"));

				if (parentProjectId == 0 && projectToSubProject.get(projectId) == null) {
					List<ProjectDTO> subProjects = new ArrayList<>();

					subProjects.add(project1);
					projectToSubProject.put(projectId, subProjects);
				}

				return project;
			}
		});
		return project;
	}

	@Override
	public List<Map<String, Object>> getProjectByCompany(int companyId, int userId) throws Exception {
		return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_COMPANY, new Object[] { companyId, userId });
	}

	@Override
	public List<Company> getCompanyByProject(int projectId) throws Exception {
		List<Map<String, Object>> rs = jdbcTemplate
				.queryForList(OnTargetQuery.GET_COMPANY_BY_PROJECT, new Object[] { projectId });
		logger.info("project id:: " + projectId);

		List<Company> companies = new ArrayList<>();
		if (rs != null && rs.size() > 0) {
			for (Map<String, Object> map : rs) {
				Company company = new Company();
				company.setCompanyId((int) map.get("company_id"));
				company.setCompanyName((String) map.get("company_name"));
				company.setWebsite((String) map.get("website"));
				company.setCompanyTypeId((int) map.get("company_type_id"));

				AddressDTO address = new AddressDTO();

				address.setAddress1((String) map.get("address1"));
				address.setAddress2((String) map.get("address2"));
				address.setCity((String) map.get("city"));
				address.setCountry((String) map.get("country"));
				address.setState((String) map.get("state"));
				address.setZip((String) map.get("zipcode"));

				company.setAddress(address);
				companies.add(company);
			}
		}

		return companies;
	}

	@Override
	// TODO: get user from project task
	public boolean updateProject(ProjectDTO project, int updatingUserId)

	throws Exception {
		int row = jdbcTemplate.update(
				OnTargetQuery.UPDATE_PROJECT,
				new Object[] { project.getProjectName(), project.getProjectDescription(), project.getProjectTypeId(),
						project.getProjectParentId(), project.getStatus(), project.getStartDate(), project.getEndDate(),
						updatingUserId, project.getProjectId() });
		if (row == 0) {
			throw new Exception("Unable to update project.");
		}
		return true;
	}

	@Override
	public List<ProjectMember> getProjectMembers(int projectId) throws Exception {
		List<ProjectMember> projectMemberList = new LinkedList<ProjectMember>();
		jdbcTemplate.query(OnTargetQuery.GET_PROJECT_MEMBERS, new Object[] { projectId }, new RowMapper<ProjectMember>() {
			@Override
			public ProjectMember mapRow(ResultSet resultSet, int i) throws SQLException {
				ProjectMember projectMember = new ProjectMember();
				projectMember.setMemberStatus(resultSet.getString("member_status"));
				projectMember.setProjectId(projectId);
				projectMember.setProjectMemberId(resultSet.getLong("project_member_id"));
				projectMember.setUserId(resultSet.getLong("user_id"));

				Contact contact = new Contact();
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));

				UserDTO user = new UserDTO();

				user.setUserId(resultSet.getInt("user_id"));
				contact.setUser(user);

				ContactPhone phone = new ContactPhone();
				phone.setAreaCode(resultSet.getInt("area_code"));
				phone.setPhoneNumber(resultSet.getString("phone_number"));
				phone.setPhoneType(resultSet.getString("phone_type"));

				projectMember.setContact(contact);
				projectMember.setPhone(phone);

				projectMemberList.add(projectMember);
				return projectMember;
			}
		});
		return projectMemberList;
	}

	@Override
	public int addProjectMember(int projectId, int userId) {
		logger.info("Adding project member for project: " + projectId);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.ADD_PROJECT_MEMBER, new String[] { "id" });
				ps.setLong(1, projectId);
				ps.setInt(2, userId);
				ps.setString(3, OnTargetConstant.MemberStatus.ACTIVE);

				return ps;
			}
		}, keyHolder);
		logger.debug("Added address with id: " + keyHolder.getKey().intValue());

		return keyHolder.getKey().intValue();
	}

	@Override
	public List<Map<String, Object>> getProjectByUser(int userId) {
		return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_USER, new Object[] { userId });
	}

	@Override
	public List<Project> getUndeletedProjectsByParentId(Integer parentProjectId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Project findProjectById(int projectId) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public Project getMainProjectByUser(int userId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteProject(int projectId,int userId) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public int addMainProject(ProjectDTO projectDTO, CompanyInfo companyInfo, int userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addActivity(ProjectDTO projectDTO, int userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateActivity(ProjectDTO projectDTO, int updatingUserId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
