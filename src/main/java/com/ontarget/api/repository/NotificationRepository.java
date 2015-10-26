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

	@Query("select un from notification u, user_notification un where u.notification_id=un.notification_id and (u.project_id=?2 or u.project_id in (select project_Id from project p where p.project_parent_Id=?2)) and un.user_id=?1 order by u.notification_id desc")
	Page<UserNotification> findNotifcationByUserId(Integer userId, Long loggedInUserProjectId, Pageable pageable);
}
