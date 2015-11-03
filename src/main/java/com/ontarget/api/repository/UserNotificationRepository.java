package com.ontarget.api.repository;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.UserNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
	@Query("select u from UserNotification u where u.userNotificationId = ?1")
	UserNotification findById(Long id);


    @Query("select u from UserNotification u where u.user.userId = ?1 and (u.notification.projectId=?2 or u.notification.projectId in (select projectId from Project p where p.projectParentId=?2)) order by u.userNotificationId desc")
    List<UserNotification> findNotifcationByUserId(Integer userId, Long loggedInUserProjectId);



    @Modifying
    @Transactional
    @Query("update UserNotification u set u.status = ?1,u.lastSeenAt = ?2" + " where u.status = '"
            + OnTargetConstant.UserNotificationStatus.NEW + "' and u.user.userId = ?3 and (u.notification.projectId=?4 or u.notification.projectId in (select p.projectId from Project p where p.projectParentId=?4))")
    int setAllNotificationAsSeen(String status, Date seenAt, Integer userId, Long projectId);
}
