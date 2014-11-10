package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.bean.Project;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public Map<String, Object> getProject(int projectId) throws Exception {
       return jdbcTemplate.queryForMap(OnTargetQuery.GET_PROJECT, new Object[]{projectId});
    }

    @Override
    public List<Map<String, Object>> getProjectByCompany(int companyId, int userId) throws Exception {
        return jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_BY_COMPANY, new Object[]{companyId,userId});
    }


}
