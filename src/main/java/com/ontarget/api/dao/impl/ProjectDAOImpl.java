package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.bean.Project;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        logger.info("Adding address: " + project);
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
                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added address with id: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();

    }

    @Override
    public Project getProject(int projectId) throws Exception {

        final Project project = new Project();

       jdbcTemplate.query(OnTargetQuery.GET_PROJECT, new Object[]{projectId}, new RowMapper<Project>() {
           @Override
           public Project mapRow(ResultSet resultSet, int i) throws SQLException {
               project.setProjectId(projectId);
               project.setProjectName( resultSet.getString("PROJECT_NAME"));
               project.setProjectDescription(resultSet.getString("PROJECT_DESCRIPTION"));
               project.setProjectTypeId(resultSet.getInt("PROJECT_TYPE_ID"));
               project.setProjectParentId(resultSet.getInt("PROJECT_PARENT_ID"));
               project.setCompanyId(resultSet.getInt("COMPANY_ID"));

               return project;
           }
       });
        return project;
    }


    @Override
    public Project getProjectAndSubProjects(int projectId) throws Exception {

        final Project project = new Project();

        Map<Integer, List<Project>> projectToSubProject=new HashMap<>();

        jdbcTemplate.query(OnTargetQuery.GET_PROJECT_AND_TASKS, new Object[]{projectId}, new RowMapper<Project>() {
            @Override
            public Project mapRow(ResultSet resultSet, int i) throws SQLException {

                int parentProjectId=resultSet.getInt("PROJECT_PARENT_ID");
                int projectId = resultSet.getInt("PROJECT_ID");

                Project project1=new Project();
                project1.setProjectId(projectId);
                project1.setProjectName( resultSet.getString("PROJECT_NAME"));
                project1.setProjectDescription(resultSet.getString("PROJECT_DESCRIPTION"));
                project1.setProjectTypeId(resultSet.getInt("PROJECT_TYPE_ID"));
                project1.setProjectParentId(parentProjectId);
                project1.setCompanyId(resultSet.getInt("COMPANY_ID"));


               if(parentProjectId==0 && projectToSubProject.get(projectId)==null){
                   List<Project> subProjects = new ArrayList<>();
                   subProjects.add(project1);
                   projectToSubProject.put(projectId,subProjects);
               }

                return project;
            }
        });
        return project;
    }



    @Override
    public List<Map<String, Object>> getProjectByCompany(int companyId, int userId) throws Exception {
        return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_COMPANY, new Object[]{companyId,userId});
    }


}
