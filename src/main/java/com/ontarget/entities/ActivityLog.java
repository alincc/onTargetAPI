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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 *
 * @author santosh
 */
@Data
@Entity
@Table(name = "activity_log")
public class ActivityLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "activity_log_id", nullable = false)
	private Long activityLogId;
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@ManyToOne()
	private User user;
	@Column(name = "activity_type", length = 20, nullable = false)
	private String activityType;
	@Basic(optional = false)
	@Column(name = "ts_insert", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date tsInsert;
	@Column(name = "project_id", nullable = true)
	private Integer projectId;
	@Column(name = "action", length = 10, nullable = false)
	private String action;
	@OneToMany(mappedBy = "activityLog", fetch = FetchType.EAGER)
	private List<ActivityLogAttribute> activityLogAttributeList;

	public ActivityLog() {
	}

	public ActivityLog(Long activityLogId) {
		super();
		this.activityLogId = activityLogId;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ActivityLog)) {
			return false;
		}
		ActivityLog other = (ActivityLog) object;
		if ((this.activityLogId == null && other.activityLogId != null)
				|| (this.activityLogId != null && !this.activityLogId.equals(other.activityLogId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ActivityLog[activityLogId=" + activityLogId + "]";
	}

}
