package com.ontarget.api.dao.impl;

import com.ontarget.bean.ActivityLog;
import com.ontarget.bean.ProjectMember;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
@Repository
public class ActivityDAOImpl implements Serializable, com.ontarget.api.dao.ActivityDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ActivityLog> getActivityLog(long recentId) throws Exception {
        List<ActivityLog> activityLogs = new LinkedList<ActivityLog>();
        jdbcTemplate.query(OnTargetQuery.GET_ACTIVITY_LOG, new Object[]{recentId}, new RowMapper<ActivityLog>() {
            @Override
            public ActivityLog mapRow(ResultSet resultSet, int i) throws SQLException {
                ActivityLog projectMember = new ActivityLog();
                projectMember.setCategory(resultSet.getLong("category"));
                projectMember.setId(resultSet.getLong("id"));
                projectMember.setTsInsert(resultSet.getLong("ts_insert"));
                projectMember.setText(resultSet.getString("text"));
                return projectMember;
            }
        });
        return activityLogs;
    }
}
