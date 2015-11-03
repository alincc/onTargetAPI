package com.ontarget.api.jpa.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.ontarget.api.notification.message.composer.Message;
import com.ontarget.api.notification.message.composer.MessageComposer;
import com.ontarget.api.notification.message.composer.MessageFactory;
import com.ontarget.entities.Notification;
import com.ontarget.entities.NotificationAttribute;
import com.ontarget.util.NotificationUtil;
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
     * Mark all status as seen
     * @param userId
     * @param projectId
     * @return
     * @throws Exception
     */
	@Override
	public boolean updateAllStatusToSeen(Integer userId, Integer projectId) throws Exception {
        logger.debug("Updating all notification for user: "+ userId +" project: "+ projectId);

        List<UserNotification> userNotifications=userNotificationRepository.findNotifcationByUserId(userId,projectId.longValue());
        if(userNotifications!=null && userNotifications.size() > 0){
           for(UserNotification userNotification : userNotifications){
               userNotification.setStatus(OnTargetConstant.UserNotificationStatus.SEEN);
               userNotification.setLastSeenAt(new Date());
               userNotificationRepository.save(userNotification);
           }
        }
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
		return notificationRepository.findNotifcationByUserId(userId, loggedInUserProjectId, pageable);
	}

	/*
	 * Get NEW notification count
	 * 
	 * @param userId
	 * 
	 * @param loggedInUserProjectId
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	@Override
	public BigInteger countNewNotification(Integer userId, Long loggedInUserProjectId) throws Exception {
		return notificationRepository.countNewNotification(userId, loggedInUserProjectId);
	}

}
