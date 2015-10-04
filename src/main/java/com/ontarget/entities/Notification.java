package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "notification")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "notification_id", nullable = false)
	private Long notificationId;
	@Column(name = "notification_type", length = 20, nullable = false)
	private String notificationType;
	@Basic(optional = false)
	@Column(name = "ts_insert", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tsInsert;
	@OneToMany(mappedBy = "notification", fetch = FetchType.EAGER)
	private List<NotificationAttribute> notificationAttributeList;
	@Column(name = "project_id", nullable = false)
	private Long projectId;
	@Column(name = "action", length = 10, nullable = false)
	private String action;

	public Notification() {
	}

	public Notification(Long notificationId) {
		super();
		this.notificationId = notificationId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public Date getTsInsert() {
		return tsInsert;
	}

	public void setTsInsert(Date tsInsert) {
		this.tsInsert = tsInsert;
	}

	public List<NotificationAttribute> getNotificationAttributeList() {
		return notificationAttributeList;
	}

	public void setNotificationAttributeList(List<NotificationAttribute> notificationAttributeList) {
		this.notificationAttributeList = notificationAttributeList;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (notificationId != null ? notificationId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Notification)) {
			return false;
		}
		Notification other = (Notification) object;
		if ((this.notificationId == null && other.notificationId != null)
				|| (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserNotification[notificationId=" + notificationId + "]";
	}

}
