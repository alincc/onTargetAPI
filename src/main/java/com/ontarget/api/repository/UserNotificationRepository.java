package com.ontarget.api.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.UserNotification;

public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {
	public static final String UPDATE_ALL_NOTIFICATION_TO_SEEN_QUERY = "UPDATE user_notification un"
			+ " JOIN notification n ON(un.notification_id=n.notification_id) SET un.status=?1,un.last_seen_at=?2 " + " WHERE un.status='"
			+ OnTargetConstant.UserNotificationStatus.NEW + "' "
			+ "AND un.user_id= ?3 AND (n.project_id=?4 OR n.project_id IN(SELECT project_id FROM project WHERE project_parent_id=?4))";

	@Query("select u from UserNotification u where u.userNotificationId = ?")
	UserNotification findById(Long id);

	@Modifying
	@Transactional
	@Query(value = UPDATE_ALL_NOTIFICATION_TO_SEEN_QUERY, nativeQuery = true)
	int setAllNotificationAsSeen(String status, Date seenAt, Integer userId, Long projectId);
}
