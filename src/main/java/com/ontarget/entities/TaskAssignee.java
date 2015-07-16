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
@Table(name = "task_assignee")
public class TaskAssignee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "task_assignee_id", nullable = false)
	private Integer taskAssigneeId;
	@Basic(optional = false)
	@Column(name = "task_assignee", nullable = false)
	private Integer taskAssignee;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdBy;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "project_task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProjectTask projectTask;
	@Column(name = "status", length = 1, nullable = false)
	private Integer status;

	public TaskAssignee() {
	}

	public TaskAssignee(Integer taskAssigneeId) {
		this.taskAssigneeId = taskAssigneeId;
	}

	public Integer getTaskAssigneeId() {
		return taskAssigneeId;
	}

	public void setTaskAssigneeId(Integer taskAssigneeId) {
		this.taskAssigneeId = taskAssigneeId;
	}

	public Integer getTaskAssignee() {
		return taskAssignee;
	}

	public void setTaskAssignee(Integer taskAssignee) {
		this.taskAssignee = taskAssignee;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taskAssigneeId != null ? taskAssigneeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TaskAssignee)) {
			return false;
		}
		TaskAssignee other = (TaskAssignee) object;
		if ((this.taskAssigneeId == null && other.taskAssigneeId != null)
				|| (this.taskAssigneeId != null && !this.taskAssigneeId.equals(other.taskAssigneeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.TaskAssignee[taskAssigneeId=" + taskAssigneeId + "]";
	}

}
