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
@Table(name = "project_activities")
public class ProjectActivities implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_activity_id", nullable = false)
	private Integer projectActivityId;
	@Basic(optional = false)
	@Column(name = "user_id", nullable = false)
	private int userId;
	@Basic(optional = false)
	@Column(name = "action", nullable = false, length = 100)
	private String action;
	@Basic(optional = false)
	@Column(name = "action_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date actionDate;
	@JoinColumn(name = "project_task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false,fetch=FetchType.LAZY)
	private ProjectTask projectTask;

	public ProjectActivities() {
	}

	public ProjectActivities(Integer projectActivityId) {
		this.projectActivityId = projectActivityId;
	}

	public ProjectActivities(Integer projectActivityId, int userId,
			String action, Date actionDate) {
		this.projectActivityId = projectActivityId;
		this.userId = userId;
		this.action = action;
		this.actionDate = actionDate;
	}

	public Integer getProjectActivityId() {
		return projectActivityId;
	}

	public void setProjectActivityId(Integer projectActivityId) {
		this.projectActivityId = projectActivityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectActivityId != null ? projectActivityId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectActivities)) {
			return false;
		}
		ProjectActivities other = (ProjectActivities) object;
		if ((this.projectActivityId == null && other.projectActivityId != null)
				|| (this.projectActivityId != null && !this.projectActivityId
						.equals(other.projectActivityId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectActivities[projectActivityId="
				+ projectActivityId + "]";
	}

}
