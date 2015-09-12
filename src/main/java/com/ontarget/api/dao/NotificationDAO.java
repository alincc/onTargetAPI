package com.ontarget.api.dao;

import com.ontarget.dto.UserNotificationDTO;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationDAO {
	public UserNotificationDTO getUserNotifications(int pageNumber, int perPageLimit, int userId) throws Exception;

	public boolean updateStatusToSeen(Long userNotificationId) throws Exception;

	public UserNotificationDTO getUserNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId)
			throws Exception;

	public boolean updateAllStatusToSeen(Integer userId) throws Exception;
}
