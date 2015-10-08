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

<<<<<<< HEAD
=======
	@Override
	public boolean updateAllStatusToSeen(Integer userId, Integer projectId) throws Exception {
        logger.debug("Updating all notification for user: "+ userId +" project: "+ projectId);
		userNotificationRepository.setAllNotificationAsSeen(OnTargetConstant.UserNotificationStatus.SEEN, new Date(), userId,projectId.longValue());
		return true;
	}

>>>>>>> ontarget.phase4
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
<<<<<<< HEAD
		return notificationRepository.findNotifcationByUserId(userId, loggedInUserProjectId,pageable);
=======
		Page<UserNotification> userNotifications = userNotificationRepository.findNotifcationByUserId(userId, loggedInUserProjectId,
				pageable);

		UserNotificationDTO userNotificationDTO = new UserNotificationDTO();
		List<Notification> notifications = new LinkedList<>();

		if (userNotifications != null && userNotifications.getTotalPages() > 0) {
			for (UserNotification userNotification : userNotifications) {
				Notification notification = new Notification();
				notification.setId(userNotification.getId());
				notification.setTsInsert(userNotification.getTsInsert().getTime());
				notification.setText(userNotification.getText());
				notification.setUserId(userNotification.getUser().getUserId());
				notification.setStatus(userNotification.getStatus());
				notification.setLastSeenAt(userNotification.getLastSeenAt());
				notification.setNotificationType(userNotification.getNotificationType());

				List<UserNotificationAttribute> notificationAttributes = userNotification.getUserNotificationAttributeList();
				NotificationUtil.setNotificationAttributes(notification, notificationAttributes);
				notifications.add(notification);
			}
		}
		userNotificationDTO.setTotalNotification(userNotifications.getTotalElements());

        Page<UserNotification> unReadUserNotifications = userNotificationRepository.countSeenNotificationById(userId, loggedInUserProjectId,
                pageable);

        userNotificationDTO.setTotalUnReadNotification(unReadUserNotifications.getTotalElements());

		userNotificationDTO.setUserNotificationList(notifications);
		return userNotificationDTO;
>>>>>>> ontarget.phase4
	}

}
