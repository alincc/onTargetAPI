package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

/**
 * Created by Owner on 11/5/14.
 */
@Repository
public class ProjectDAOImpl implements ProjectDAO {

    private Logger logger = Logger.getLogger(ProjectDAOImpl.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addProject(Project project) throws Exception {
        logger.info("Adding project: " + project);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_PROJECT, new String[]{"id"});
                        ps.setString(1, project.getProjectName());
                        ps.setString(2, project.getProjectDescription());
                        ps.setInt(3, project.getProjectTypeId());//TODO: get project type id and get it from project type table.
                        ps.setInt(4, project.getCompanyId());
                        ps.setInt(5, project.getProjectAddress().getAddressId());
                        ps.setString(6, project.getStatus());
                        ps.setInt(7, project.getProjectParentId());
                        ps.setDate(8, new java.sql.Date(project.getStartDate().getTime()));
                        ps.setDate(9, new java.sql.Date(project.getEndDate().getTime()));
                        ps.setString(10, project.getProjectImagePath());
                        return ps;
                    }
                },
                keyHolder);

        logger.debug("Added project with id: " + keyHolder.getKey().intValue());

        return keyHolder.getKey().intValue();
    }

    @Override
    public Project getProject(int projectId) throws Exception {

        final Project project = new Project();

        jdbcTemplate.query(OnTargetQuery.GET_PROJECT, new Object[]{projectId}, new RowMapper<Project>() {
            @Override
            public Project mapRow(ResultSet resultSet, int i) throws SQLException {
                project.setProjectId(projectId);
                project.setProjectName(resultSet.getString("PROJECT_NAME"));
                project.setProjectDescription(resultSet.getString("PROJECT_DESCRIPTION"));
                project.setProjectTypeId(resultSet.getInt("PROJECT_TYPE_ID"));
                project.setProjectParentId(resultSet.getInt("PROJECT_PARENT_ID"));
                project.setCompanyId(resultSet.getInt("COMPANY_ID"));
                project.setProjectOwnerId(resultSet.getLong("project_owner_id"));
                project.setStartDate(resultSet.getDate("project_start_date"));
                project.setEndDate(resultSet.getDate("project_end_date"));

                return project;
            }
        });

        return project;
    }

    public List<Project> getChildProjects(int projectId) throws Exception {
        List<Project> projects = new LinkedList<>();
        List<Map<String, Object>> rs = jdbcTemplate.queryForList(OnTargetQuery.GET_CHILD_PROJECTS, projectId);
        if (rs != null)
            for (Map<String, Object> row : rs) {
                Project project = new Project();
                project.setProjectId((int) row.get("project_id"));
                project.setProjectName((String) row.get("PROJECT_NAME"));
                project.setProjectDescription((String) row.get("PROJECT_DESCRIPTION"));
                project.setProjectParentId((int) row.get("PROJECT_PARENT_ID"));
                project.setCompanyId((int) row.get("COMPANY_ID"));
                if (row.containsKey("project_owner_id") && row.get("project_owner_id") != null)
                    project.setProjectOwnerId((int) row.get("project_owner_id"));
                project.setStartDate((Timestamp) row.get("project_start_date"));
                project.setEndDate((Timestamp) row.get("project_end_date"));

                projects.add(project);
            }

        return projects;
    }


    @Override
    public Project getProjectAndSubProjects(int projectId) throws Exception {

        final Project project = new Project();

        Map<Integer, List<Project>> projectToSubProject = new HashMap<>();

        jdbcTemplate.query(OnTargetQuery.GET_PROJECT_AND_TASKS, new Object[]{projectId}, new RowMapper<Project>() {
            @Override
            public Project mapRow(ResultSet resultSet, int i) throws SQLException {

                int parentProjectId = resultSet.getInt("PROJECT_PARENT_ID");
                int projectId = resultSet.getInt("PROJECT_ID");

                Project project1 = new Project();
                project1.setProjectId(projectId);
                project1.setProjectName(resultSet.getString("PROJECT_NAME"));
                project1.setProjectDescription(resultSet.getString("PROJECT_DESCRIPTION"));
                project1.setProjectTypeId(resultSet.getInt("PROJECT_TYPE_ID"));
                project1.setProjectParentId(parentProjectId);
                project1.setCompanyId(resultSet.getInt("COMPANY_ID"));


                if (parentProjectId == 0 && projectToSubProject.get(projectId) == null) {
                    List<Project> subProjects = new ArrayList<>();
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
        return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_COMPANY, new Object[]{companyId, userId});
    }

    @Override
    //TODO: get user from project task
    public boolean updateProject(Project project) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_PROJECT, new Object[]{project.getProjectName(), project.getProjectDescription(), project.getProjectTypeId(), project.getProjectParentId(), project.getStatus(), project.getStartDate(), project.getEndDate(), "0", project.getProjectId()});
        if (row == 0) {
            throw new Exception("Unable to update project.");
        }
        return true;
    }

    @Override
    public List<ProjectMember> getProjectMembers(long projectId) throws Exception {
        List<ProjectMember> projectMemberList = new LinkedList<ProjectMember>();
        jdbcTemplate.query(OnTargetQuery.GET_PROJECT_MEMBERS, new Object[]{projectId}, new RowMapper<ProjectMember>() {
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

                User user = new User();
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
//        System.out.println("total read " + projectMemberList.size());
        return projectMemberList;
    }


    @Override
    public int addProjectMember(int projectId, int userId) {
        logger.info("Adding project member for project: " + projectId);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(OnTargetQuery.ADD_PROJECT_MEMBER, new String[]{"id"});
                        ps.setInt(1, projectId);
                        ps.setInt(2, userId);
                        ps.setString(3, OnTargetConstant.MemberStatus.ACTIVE);

                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added address with id: " + keyHolder.getKey().intValue());

        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Map<String, Object>> getProjectByUser(int userId) {
        return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_USER, new Object[]{userId});
    }
}
