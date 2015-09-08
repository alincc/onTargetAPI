package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.ontarget.dto.NotificationResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.NotificationRequest;
import com.ontarget.request.bean.NotificationStatusUpdateRequest;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationEndpoint {
	NotificationResponse getNotifications(@Valid NotificationRequest notificationRequest);

    NotificationResponse getNotificationsByUserByProject(@Valid NotificationRequest notificationRequest);

    OnTargetResponse markNotificationAsSeen(@Valid NotificationStatusUpdateRequest notificationStatusUpdateRequest);
}
