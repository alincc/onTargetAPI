package com.ontarget.api.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ontarget.bean.ActivityLog;
import com.ontarget.constant.OnTargetQuery;

/**
 * Created by sumit on 12/6/14.
 */
@Repository
public class ActivityDAOImpl implements Serializable, com.ontarget.api.dao.ActivityDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ActivityLog> getActivityLog(long projectId) throws Exception {
        List<ActivityLog> activityLogs = new LinkedList<ActivityLog>();
        jdbcTemplate.query(OnTargetQuery.GET_ACTIVITY_LOG, new Object[]{projectId}, new RowMapper<ActivityLog>() {
            @Override
            public ActivityLog mapRow(ResultSet resultSet, int i) throws SQLException {
                ActivityLog activityLog = new ActivityLog();
                activityLog.setCategory(resultSet.getLong("category"));
                activityLog.setId(resultSet.getLong("id"));
                activityLog.setTsInsert(resultSet.getTimestamp("ts_insert").getTime());
                activityLog.setText(resultSet.getString("text"));
                activityLogs.add(activityLog);
                return activityLog;
            }
        });
        
        return activityLogs;
    }
}
