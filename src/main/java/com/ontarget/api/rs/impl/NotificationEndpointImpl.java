package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ontarget.request.bean.NotificationAllSeenRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.service.NotificationService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.NotificationResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserNotificationDTO;
import com.ontarget.request.bean.NotificationRequest;
import com.ontarget.request.bean.NotificationStatusUpdateRequest;

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
	private Logger logger = Logger.getLogger(NotificationEndpointImpl.class);

	@Override
	@POST
	@Path("/getNotifications")
	public NotificationResponse getNotifications(NotificationRequest notificationRequest) {
		NotificationResponse response = new NotificationResponse();
		try {
			UserNotificationDTO userNotificationDTO = notificationService.getNotifications(notificationRequest.getPageNumber(),
					notificationRequest.getPerPageLimit(), notificationRequest.getUserId());
			response.setNotificationList(userNotificationDTO.getUserNotificationList());
			response.setTotalNotification(userNotificationDTO.getTotalNotification());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("notification read");
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnMessage(e.getMessage());
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/getNotificationsByUserByProject")
	public NotificationResponse getNotificationsByUserByProject(NotificationRequest notificationRequest) {
		NotificationResponse response = new NotificationResponse();
		try {
			UserNotificationDTO userNotificationDTO = notificationService.getNotifications(notificationRequest.getPageNumber(),
					notificationRequest.getPerPageLimit(), notificationRequest.getUserId(), notificationRequest.getBaseRequest()
							.getLoggedInUserProjectId().longValue());
			response.setNotificationList(userNotificationDTO.getUserNotificationList());
			response.setTotalNotification(userNotificationDTO.getTotalNotification());
			response.setTotalUnreadNotification(userNotificationDTO.getTotalUnReadNotification());
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("notification read");
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnMessage(e.getMessage());
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/markAsSeen")
	public OnTargetResponse markNotificationAsSeen(NotificationStatusUpdateRequest notificationStatusUpdateRequest) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean updated = notificationService.updateStatusToSeen(notificationStatusUpdateRequest.getId());
			if (updated) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("notification status set as seen");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Notification status update failed");
			}
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Notification status update failed");
		}

		return response;
	}

	@Override
	@POST
	@Path("/markAllAsSeen")
	public OnTargetResponse markAllNotificationAsSeen(NotificationAllSeenRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean updated = notificationService.updateAllStatusToSeen(request.getBaseRequest().getLoggedInUserId(), request
					.getBaseRequest().getLoggedInUserProjectId());
			if (updated) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("All notification status set as seen");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("All Notification status update failed");
			}
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Mark all notification status as seen request failed");
		}
		return response;
	}
}
