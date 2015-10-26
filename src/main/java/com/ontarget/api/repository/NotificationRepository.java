package com.ontarget.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ontarget.entities.Notification;
import com.ontarget.entities.UserNotification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

	@Query("select u from UserNotification u where u.user.userId = ? order by u.userNotificationId desc")
	Page<UserNotification> findUserNotificationByUserId(Integer userId, Pageable pageable);

	@Query("select u from UserNotification u where u.user.userId = ?1 and (u.notification.projectId=?2 or u.notification.projectId in (select projectId from Project p where p.projectParentId=?2)) order by u.userNotificationId desc")
	Page<UserNotification> findNotifcationByUserId(Integer userId, Long loggedInUserProjectId, Pageable pageable);
}
