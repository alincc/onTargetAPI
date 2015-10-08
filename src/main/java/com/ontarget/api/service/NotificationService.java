package com.ontarget.api.service;

import com.ontarget.dto.UserNotificationDTO;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationService {
	public UserNotificationDTO getNotifications(int pageNumber, int perPageLimit, int userId) throws Exception;

	public boolean updateStatusToSeen(Long userNotificationId) throws Exception;

	public UserNotificationDTO getNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId)
			throws Exception;

	public boolean updateAllStatusToSeen(Integer userId, Integer projectId) throws Exception;
}
