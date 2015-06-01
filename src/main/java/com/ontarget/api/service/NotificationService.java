package com.ontarget.api.service;

import com.ontarget.dto.UserNotificationDTO;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationService {
	UserNotificationDTO getNotifications(int pageNumber, int perPageLimit, int userId) throws Exception;

	boolean updateStatusToSeen(Long userNotificationId) throws Exception;
}
