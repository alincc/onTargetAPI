package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Created by sumit on 12/26/14.
 */
@Data
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	private long userNotificationId;
	private String text;
	private String notificationType;
	private String action;
	private Date tsInsert;
	private int userId;
	private String status;
	private Date lastSeenAt;
	private List<NotificationAttribute> notificationAttributes;

}
