package com.ontarget.api.dao;

import org.springframework.data.domain.Page;

import com.ontarget.entities.UserNotification;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationDAO {

	public Page<UserNotification> getUserNotifications(int pageNumber, int perPageLimit, int userId) throws Exception;

	public boolean updateStatusToSeen(Long userNotificationId) throws Exception;

	public Page<UserNotification> getUserNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId)
			throws Exception;
}
