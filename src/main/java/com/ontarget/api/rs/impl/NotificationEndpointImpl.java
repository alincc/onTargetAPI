package com.ontarget.api.rs.impl;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.service.NotificationService;
import com.ontarget.bean.Notification;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.NotificationResponse;
import com.ontarget.request.bean.NotificationRequestBean;

/**
 * Created by sumit on 12/26/14.
 */
@Component
@Path("/notification")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NotificationEndpointImpl implements
		com.ontarget.api.rs.NotificationEndpoint {

	@Autowired
	private NotificationService notificationService;

	@Override
	@POST
	@Path("/getNotifications")
	public NotificationResponse getNotifications(
			NotificationRequestBean notificationRequest) {
		NotificationResponse response = new NotificationResponse();
		try {
			List<Notification> notifications = notificationService
					.getNotifications(notificationRequest.getRecentId(),
							notificationRequest.getUserId());
			if (notifications == null || notifications.isEmpty()) {
				response.setNotificationList(new LinkedList<>());
				response.setRecentNotificationId(notificationRequest
						.getRecentId());
			} else {
				response.setNotificationList(notifications);
				response.setRecentNotificationId(notifications.get(
						notifications.size() - 1).getId());
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
