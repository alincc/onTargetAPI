package com.ontarget.api.dao.impl;

import com.ontarget.bean.Notification;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sumit on 12/26/14.
 */
@Repository
public class NotificationDAOImpl implements com.ontarget.api.dao.NotificationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Notification> getNotificationSince(long recentId) throws Exception {
        List<Notification> notifications = new LinkedList<>();
        jdbcTemplate.query(OnTargetQuery.GET_USER_NOTIFICATION, new Object[]{recentId}, new RowMapper<Notification>() {
            @Override
            public Notification mapRow(ResultSet resultSet, int i) throws SQLException {
                Notification notification = new Notification();
                notification.setCategory(resultSet.getLong("category"));
                notification.setId(resultSet.getLong("id"));
                notification.setTsInsert(resultSet.getTimestamp("ts_insert").getTime());
                notification.setText(resultSet.getString("text"));
                notification.setUserId(resultSet.getInt("user_id"));
                notifications.add(notification);
                return notification;
            }
        });

        return notifications;
    }
}
