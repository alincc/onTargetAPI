package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.TaskPercentageDAO;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskPercentage;
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
 * Created by Owner on 11/25/14.
 */
@Repository
public class TaskPercentageDAOImpl implements TaskPercentageDAO {

    private Logger logger = Logger.getLogger(TaskPercentageDAOImpl.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<Task, List<TaskPercentage>> getTaskPercentageCompletes() throws Exception {
        return null;
    }

    @Override
    public int addTaskPercentageComplete(TaskPercentage taskPercentage) throws Exception{
        logger.info("Adding task percentage: " + taskPercentage);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_TASK_PERCENTAGE_COMPLETE, new String[]{"id"});
                        ps.setInt(1, taskPercentage.getTask().getProjectTaskId());
                        ps.setDate(2, new java.sql.Date(taskPercentage.getFromDate().getTime()));
                        ps.setDate(3, new java.sql.Date(taskPercentage.getToDate().getTime()));
                        ps.setString(4, taskPercentage.getTaskPercentageType());
                        ps.setDouble(5, taskPercentage.getTaskPercentageComplete());
                        ps.setString(6,"");//get user who added this.
                        ps.setString(7, "");// get user who modified this.
                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added Task Costs: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }

    @Override
    public boolean updateTaskPercentageComplete(TaskPercentage cost) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_PERCENTAGE_COMPLETE, new Object[]{cost.getTaskPercentageComplete(), "USER", cost.getId()});
        if (row == 0) {
            throw new Exception("Unable to update task estimated and planned cost");
        }
        return true;
    }


}
