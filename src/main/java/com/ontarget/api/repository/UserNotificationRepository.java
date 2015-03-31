package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.UserNotification;

public interface UserNotificationRepository extends
		JpaRepository<UserNotification, Long> {

	@Query("select u from UserNotification u where u.userId = ?1 and u.id > ?2 order by u.id")
	List<UserNotification> findByUserIdAndIdGreater(Integer userId, Long id);

}
