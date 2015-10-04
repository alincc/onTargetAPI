package com.ontarget.api.jpa.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.NotificationDAO;
import com.ontarget.api.repository.NotificationRepository;
import com.ontarget.api.repository.UserNotificationRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.UserNotification;

@Repository("notificationJpaDAOImpl")
public class NotificationJpaDAOImpl implements NotificationDAO {

	private Logger logger = Logger.getLogger(NotificationJpaDAOImpl.class);

	@Resource
	private NotificationRepository notificationRepository;
	@Resource
	private UserNotificationRepository userNotificationRepository;

	@Override
	public Page<UserNotification> getUserNotifications(int pageNumber, int perPageLimit, int userId) throws Exception {
		Pageable pageable = new PageRequest(pageNumber - 1, perPageLimit);
		return notificationRepository.findUserNotificationByUserId(userId, pageable);
	}

	@Override
	public boolean updateStatusToSeen(Long userNotificationId) throws Exception {
		UserNotification userNotification = userNotificationRepository.findById(userNotificationId);
		userNotification.setStatus(OnTargetConstant.UserNotificationStatus.SEEN);
		userNotification.setLastSeenAt(new Date());
		userNotificationRepository.save(userNotification);
		return true;
	}

	/**
	 * Get notification by user and project
	 * 
	 * @param pageNumber
	 * @param perPageLimit
	 * @param userId
	 * @param loggedInUserProjectId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<UserNotification> getUserNotifications(Integer pageNumber, Integer perPageLimit, Integer userId, Long loggedInUserProjectId)
			throws Exception {
		Pageable pageable = new PageRequest(pageNumber - 1, perPageLimit);
		return notificationRepository.findNotifcationByUserId(userId, loggedInUserProjectId,pageable);
	}

}
