package com.ontarget.api.dao;

import com.ontarget.dto.UserNotificationDTO;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationDAO {
	UserNotificationDTO getUserNotifications(int pageNumber, int perPageLimit, int userId) throws Exception;
	
	boolean updateStatusToSeen(Long userNotificationId) throws Exception;
}
