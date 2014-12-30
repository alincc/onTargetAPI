package com.ontarget.api.rs;

import com.ontarget.dto.NotificationResponse;

/**
 * Created by sumit on 12/26/14.
 */
public interface NotificationEndpoint {
    NotificationResponse getNotifications(long recentId, int userId);
}
