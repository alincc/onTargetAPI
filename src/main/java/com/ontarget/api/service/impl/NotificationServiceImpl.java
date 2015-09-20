package com.ontarget.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.NotificationDAO;
import com.ontarget.dto.UserNotificationDTO;

/**
 * Created by sumit on 12/26/14.
 */
@Service
public class NotificationServiceImpl implements com.ontarget.api.service.NotificationService {
	@Autowired
	@Qualifier("notificationJpaDAOImpl")
	private NotificationDAO notificationDAO;

	@Override
	public UserNotificationDTO getNotifications(int pageNumber, int perPageLimit, int userId) throws Exception {
		return notificationDAO.getUserNotifications(pageNumber, perPageLimit, userId);
	}

	@Override
	public boolean updateStatusToSeen(Long userNotificationId) throws Exception {
		return notificationDAO.updateStatusToSeen(userNotificationId);
	}

	@Override
	public boolean updateAllStatusToSeen(Integer userId, Integer projectId) throws Exception {
		return notificationDAO.updateAllStatusToSeen(userId, projectId);
	}

	@Override
	public UserNotificationDTO getNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId)
			throws Exception {
		return notificationDAO.getUserNotifications(pageNumber, perPageLimit, userId, loggedInUserProjectId);
	}
}
