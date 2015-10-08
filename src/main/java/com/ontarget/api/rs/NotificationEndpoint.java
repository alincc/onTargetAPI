package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.NotificationResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.NotificationAllSeenRequest;
import com.ontarget.request.bean.NotificationRequest;
import com.ontarget.request.bean.NotificationStatusUpdateRequest;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationEndpoint {
	NotificationResponse getNotifications(@Valid NotificationRequest notificationRequest);

	NotificationResponse getNotificationsByUserByProject(@Valid NotificationRequest notificationRequest);

	OnTargetResponse markNotificationAsSeen(@Valid NotificationStatusUpdateRequest notificationStatusUpdateRequest);


    public OnTargetResponse markAllNotificationAsSeen(NotificationAllSeenRequest request);
}
