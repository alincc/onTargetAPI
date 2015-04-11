package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.UserNotification;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {

	@Query("select u from UserNotification u where u.user.userId = ?1 and u.id > ?2 order by u.id")
	List<UserNotification> findByUserIdAndIdGreater(Integer userId, Long id);

	@Query("select u from UserNotification u where u.user.userId = ? order by u.id desc")
	Page<UserNotification> findNotifcationByUserId(Integer userId, Pageable pageable);

	UserNotification findById(Long id);

}
