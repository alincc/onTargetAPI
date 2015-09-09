package com.ontarget.api.dao.impl;

import com.ontarget.dto.UserNotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by sumit on 12/26/14.
 */
@Repository("notificationDAOImpl")
public class NotificationDAOImpl implements com.ontarget.api.dao.NotificationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// @Override
	// public List<Notification> getNotificationSince(long recentId, int userId)
	// throws Exception {
	// List<Notification> notifications = new LinkedList<>();
	// jdbcTemplate.query(OnTargetQuery.GET_USER_NOTIFICATION, new Object[] {
	// recentId, userId }, new RowMapper<Notification>() {
	// @Override
	// public Notification mapRow(ResultSet resultSet, int i) throws
	// SQLException {
	// Notification notification = new Notification();
	// notification.setCategory(resultSet.getLong("category"));
	// notification.setId(resultSet.getLong("id"));
	// notification.setTsInsert(resultSet.getTimestamp("ts_insert").getTime());
	// notification.setText(resultSet.getString("text"));
	// notification.setUserId(resultSet.getInt("user_id"));
	// notifications.add(notification);
	// return notification;
	// }
	// });
	//
	// return notifications;
	// }

	@Override
	public UserNotificationDTO getUserNotifications(int pageNumber, int perPageLimit, int userId) throws Exception {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean updateStatusToSeen(Long userNotificationId) throws Exception {
		throw new UnsupportedOperationException();
	}

    @Override
    public UserNotificationDTO getUserNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId) throws Exception {
        throw new UnsupportedOperationException();
    }
}
