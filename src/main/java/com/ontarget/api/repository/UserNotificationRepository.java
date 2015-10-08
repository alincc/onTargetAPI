package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.UserNotification;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
	@Query("select u from UserNotification u where u.userNotificationId = ?")
	UserNotification findById(Long id);
<<<<<<< HEAD
=======

	@Modifying
	@Transactional
	@Query("update UserNotification u set u.status = ?1,u.lastSeenAt = ?2" + " where u.status = '"
			+ OnTargetConstant.UserNotificationStatus.NEW + "' and u.user.userId = ?3 and (u.projectId=?4 or u.projectId in (select p.projectId from Project p where p.projectParentId=?4))")
	int setAllNotificationAsSeen(String status, Date seenAt, Integer userId, Long projectId);

	@Query("select u from UserNotification u where u.user.userId = ?1 and (u.projectId=?2 or u.projectId in (select projectId from Project p where p.projectParentId=?2)) order by u.id desc")
	Page<UserNotification> findNotifcationByUserId(Integer userId, Long loggedInUserProjectId, Pageable pageable);


    @Query("select u from UserNotification u where u.status ='"+ OnTargetConstant.UserNotificationStatus.NEW+"' and u.user.userId = ?1 and (u.projectId=?2 or u.projectId in (select projectId from Project p where p.projectParentId=?2)) order by u.id desc")
    Page<UserNotification> countSeenNotificationById(Integer userId, Long loggedInUserProjectId, Pageable pageable);
>>>>>>> ontarget.phase4
}
