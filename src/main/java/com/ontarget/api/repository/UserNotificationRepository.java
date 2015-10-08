package com.ontarget.api.repository;

import com.ontarget.entities.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
	@Query("select u from UserNotification u where u.userNotificationId = ?")
	UserNotification findById(Long id);
}
