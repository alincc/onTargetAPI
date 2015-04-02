package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.NotificationResponse;
import com.ontarget.request.bean.NotificationRequest;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationEndpoint {
	NotificationResponse getNotifications(
			@Valid NotificationRequest notificationRequest);
}
