package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.TaskEstimatedCostDAO;
import com.ontarget.bean.TaskEstimatedCost;
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

/**
 * Created by Owner on 11/17/14.
 */
@Repository
public class TaskPlannedEstimatedCostDAOImpl implements TaskEstimatedCostDAO {

    private Logger logger = Logger.getLogger(TaskPlannedEstimatedCostDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addPlannedAcutalCost(TaskEstimatedCost cost) throws Exception {

        logger.info("Adding Percentage: " + cost);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_TASK_PLANNED_ESTIMATED_COST, new String[]{"id"});
                        ps.setInt(1, cost.getTask().getProjectTaskId());
                        ps.setDate(2, new java.sql.Date(cost.getFromDate().getTime()));
                        ps.setDate(3, new java.sql.Date(cost.getToDate().getTime()));
                        ps.setString(4, cost.getCostType());
                        ps.setDouble(5, cost.getCost());
                        ps.setInt(6, cost.getCreatedBy());
                        ps.setInt(7, cost.getModifiedBy());
                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added Task Costs: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }

    @Override
    public boolean updatePlannedActualCost(TaskEstimatedCost cost) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_PLANNED_ESTIMATED_COST, new Object[]{cost.getCost(),
        		cost.getModifiedBy(), cost.getId()});
        if (row == 0) {
            return false;
        }
        return true;
    }

}
