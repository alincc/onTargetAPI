package com.ontarget.api.dao.impl;

import com.ontarget.dto.UserNotificationDTO;
import com.ontarget.entities.UserNotification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by sumit on 12/26/14.
 */
@Repository("notificationDAOImpl")
public class NotificationDAOImpl implements com.ontarget.api.dao.NotificationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean updateStatusToSeen(Long userNotificationId) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public Page<UserNotification> getUserNotifications(int pageNumber, int perPageLimit, int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserNotification> getUserNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId)
			throws Exception {
        return null;
    }

	public boolean updateAllStatusToSeen(Integer userId, Integer projectId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
