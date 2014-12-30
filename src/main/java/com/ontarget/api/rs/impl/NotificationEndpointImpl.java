package com.ontarget.api.rs.impl;

import com.ontarget.api.service.NotificationService;
import com.ontarget.bean.Notification;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.NotificationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sumit on 12/26/14.
 */
@Component
@Path("/notification")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NotificationEndpointImpl implements com.ontarget.api.rs.NotificationEndpoint {

    @Autowired
    private NotificationService notificationService;

    @Override
    @GET
    @Path("/getNotifications")
    public NotificationResponse getNotifications(@QueryParam("recentId") long recentId, @QueryParam("userId") int userId) {
        NotificationResponse response = new NotificationResponse();
        try {
            List<Notification> notifications = notificationService.getNotifications(recentId, userId);
            if (notifications == null || notifications.isEmpty()) {
//                System.out.println("empty result returned");
                response.setNotificationList(new LinkedList<>());
                response.setRecentNotificationId(recentId);
            } else {
//                System.out.println("non empty result returned");
                response.setNotificationList(notifications);
                response.setRecentNotificationId(notifications.get(notifications.size() - 1).getId());
            }
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("notification read");
        } catch (Exception e) {
            e.printStackTrace();
            response.setReturnMessage(e.getMessage());
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }
}
