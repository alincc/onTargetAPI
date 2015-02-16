package com.ontarget.api.rs;

import com.ontarget.dto.NotificationResponse;
import com.ontarget.request.bean.NotificationRequestBean;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationEndpoint {
	NotificationResponse getNotifications(
			NotificationRequestBean notificationRequest);
}
