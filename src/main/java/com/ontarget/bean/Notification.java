package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by sumit on 12/26/14.
 */
public class Notification implements Serializable {
	private long id;
	private String text;
	private String notificationType;
	private int notificationId;
	private long tsInsert;
	private int userId;
	private String status;
	private Date lastSeenAt;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public long getTsInsert() {
		return tsInsert;
	}

	public void setTsInsert(long tsInsert) {
		this.tsInsert = tsInsert;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getLastSeenAt() {
		return lastSeenAt;
	}

	public void setLastSeenAt(Date lastSeenAt) {
		this.lastSeenAt = lastSeenAt;
	}
}
