package com.ontarget.entities;

import java.io.Serializable;

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

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "notification_attribute")
public class NotificationAttribute implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "notification_attribute_id", nullable = false)
	private Long notificationAttributeId;
	@Column(name = "attribute_key", length = 20, nullable = false)
	private String attributeKey;
	@Column(name = "attribute_value", length = 20, nullable = false)
	private String attributeValue;
	@JoinColumn(name = "notification_id", referencedColumnName = "notification_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Notification notification;

	public NotificationAttribute() {
	}

	public NotificationAttribute(Long notificationAttributeId) {
		super();
		this.notificationAttributeId = notificationAttributeId;
	}

	public Long getNotificationAttributeId() {
		return notificationAttributeId;
	}

	public void setNotificationAttributeId(Long notificationAttributeId) {
		this.notificationAttributeId = notificationAttributeId;
	}

	public String getAttributeKey() {
		return attributeKey;
	}

	public void setAttributeKey(String attributeKey) {
		this.attributeKey = attributeKey;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
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
		hash += (notificationAttributeId != null ? notificationAttributeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof NotificationAttribute)) {
			return false;
		}
		NotificationAttribute other = (NotificationAttribute) object;
		if ((this.notificationAttributeId == null && other.notificationAttributeId != null)
				|| (this.notificationAttributeId != null && !this.notificationAttributeId.equals(other.notificationAttributeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.NotificationAttribute[notificationAttributeId=" + notificationAttributeId + "]";
	}

}
