package com.ontarget.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

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
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name = "notification_type", length = 20, nullable = false)
	private String notificationType;
	@Column(name = "text", columnDefinition = "TEXT")
	private String text;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	@ManyToOne(optional = false)
	private User user;
	@Basic(optional = false)
	@Column(name = "ts_insert", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tsInsert;
	@Column(name = "status", length = 4)
	private String status;
	@Column(name = "last_seen_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastSeenAt;
	@OneToMany(mappedBy = "userNotification", fetch = FetchType.EAGER)
	private List<UserNotificationAttribute> userNotificationAttributeList;
    @Column(name = "project_id", nullable = false)
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public UserNotification() {
	}

	public UserNotification(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTsInsert() {
		return tsInsert;
	}

	public void setTsInsert(Date tsInsert) {
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

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public List<UserNotificationAttribute> getUserNotificationAttributeList() {
		return userNotificationAttributeList;
	}

	public void setUserNotificationAttributeList(List<UserNotificationAttribute> userNotificationAttributeList) {
		this.userNotificationAttributeList = userNotificationAttributeList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
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
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.UserNotification[id=" + id + "]";
	}

}
