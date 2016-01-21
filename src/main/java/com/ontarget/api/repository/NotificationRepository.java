package com.ontarget.api.repository;

import java.math.BigInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Notification;
import com.ontarget.entities.UserNotification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	@Query("select u from UserNotification u where u.user.userId = ? order by u.userNotificationId desc")
	Page<UserNotification> findUserNotificationByUserId(Integer userId, Pageable pageable);

	@Query("select u from UserNotification u where u.user.userId = ?1 and u.notification.projectId=?2  order by u.userNotificationId desc")
	Page<UserNotification> findNotifcationByUserId(Integer userId, Long loggedInUserProjectId, Pageable pageable);

	@Query(value = "SELECT COUNT(1) FROM user_notification un join notification n on(un.notification_id=n.notification_id) where un.user_id = ?1"
			+ " and un.status='"
			+ OnTargetConstant.UserNotificationStatus.NEW
			+ "' and (n.project_id=?2 or n.project_id in("
			+ "select p.project_id from project p where p.project_parent_id=?2))", nativeQuery = true)
	BigInteger countNewNotification(Integer userId, Long loggedInUserProjectId);
}
