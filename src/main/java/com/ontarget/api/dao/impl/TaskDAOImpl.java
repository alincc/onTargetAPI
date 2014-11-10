package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.bean.Task;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/6/14.
 */
@Repository
public class TaskDAOImpl implements TaskDAO {

    private Logger logger = Logger.getLogger(AddressDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addTask(Task task) throws Exception {

        logger.info("Adding address: " + task);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_TASK, new String[]{"id"});
                        //ps.setInt(1, task.getProject().getProjectId());
                        ps.setInt(1, 3);

                        ps.setString(2, task.getTitle());
                        ps.setString(3, task.getDescription());
                        ps.setInt(4, task.getParentTask().getProjectTaskId());

                        ps.setInt(4, 0);
                        ps.setString(5, task.getStatus());
                        ps.setString(6, task.getSeverity());
                        ps.setDate(7, new java.sql.Date(task.getStartDate().getTime()));
                        ps.setDate(8, new java.sql.Date(task.getEndDate().getTime()));
                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added address with id: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Task> getTask(int projectId) throws Exception {
        List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK, new Object[]{projectId});
        List<Task> tasks = new ArrayList<>();
        for (Map<String, Object> taskMap : taskList) {
            Task task = new Task();
            task.setTitle((String) taskMap.get("title"));
            task.setDescription((String) taskMap.get("description"));
            task.setStatus((String) taskMap.get("status"));
            task.setSeverity((String) taskMap.get("severity"));
            task.setProjectTaskId((Integer) taskMap.get("project_task_id"));
            task.setStartDate((Date) taskMap.get("start_date"));
            task.setEndDate((Date) taskMap.get("end_date"));
            task.setCompleted((String) taskMap.get("status"));
            tasks.add(task);
        }

        return tasks;
    }
}
