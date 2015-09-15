package com.ontarget.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.UserNotification;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {

	@Query("select u from UserNotification u where u.user.userId = ?1 and u.id > ?2 order by u.id")
	List<UserNotification> findByUserIdAndIdGreater(Integer userId, Long id);

	@Query("select u from UserNotification u where u.user.userId = ? order by u.id desc")
	Page<UserNotification> findNotifcationByUserId(Integer userId, Pageable pageable);

	UserNotification findById(Long id);

	@Modifying
	@Transactional
	@Query("update UserNotification u set u.status = ?1,u.lastSeenAt = ?2" + " where u.status = '"
			+ OnTargetConstant.UserNotificationStatus.NEW + "' and u.user.userId = ?3")
	int setAllNotificationAsSeen(String status, Date seenAt, Integer userId);

	@Query("select u from UserNotification u where u.user.userId = ?1 and (u.projectId=?2 or u.projectId in (select projectId from Project p where p.projectParentId=?2)) order by u.id desc")
	Page<UserNotification> findNotifcationByUserId(Integer userId, Long loggedInUserProjectId, Pageable pageable);


    @Query("select u from UserNotification u where u.status ='"+ OnTargetConstant.UserNotificationStatus.NEW+"' and u.user.userId = ?1 and (u.projectId=?2 or u.projectId in (select projectId from Project p where p.projectParentId=?2)) order by u.id desc")
    Page<UserNotification> countSeenNotificationById(Integer userId, Long loggedInUserProjectId, Pageable pageable);
}
