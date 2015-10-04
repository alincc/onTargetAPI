package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "user_notification")
public class UserNotification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "user_notification_id", nullable = false)
	private Long userNotificationId;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@ManyToOne(optional = false)
	private User user;
	@Column(name = "status", length = 4)
	private String status;
	@Column(name = "last_seen_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastSeenAt;
	@JoinColumn(name = "notification_id", referencedColumnName = "notification_id", nullable = false)
	@ManyToOne(optional = false)
	private Notification notification;

	public UserNotification() {
	}

	public UserNotification(Long userNotificationId) {
		super();
		this.userNotificationId = userNotificationId;
	}

	public Long getUserNotificationId() {
		return userNotificationId;
	}

	public void setUserNotificationId(Long userNotificationId) {
		this.userNotificationId = userNotificationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (userNotificationId != null ? userNotificationId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UserNotification)) {
			return false;
		}
		UserNotification other = (UserNotification) object;
		if ((this.userNotificationId == null && other.userNotificationId != null)
				|| (this.userNotificationId != null && !this.userNotificationId.equals(other.userNotificationId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserNotification[userNotificationId=" + userNotificationId + "]";
	}

}
