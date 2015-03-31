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
	private long taskAssignee;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false)
	private int modifiedBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "project_task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProjectTask projectTask;

	public TaskAssignee() {
	}

	public TaskAssignee(Integer taskAssigneeId) {
		this.taskAssigneeId = taskAssigneeId;
	}

	public TaskAssignee(Integer taskAssigneeId, long taskAssignee,
			int createdBy, Date createdDate, int modifiedBy, Date modifiedDate) {
		this.taskAssigneeId = taskAssigneeId;
		this.taskAssignee = taskAssignee;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public Integer getTaskAssigneeId() {
		return taskAssigneeId;
	}

	public void setTaskAssigneeId(Integer taskAssigneeId) {
		this.taskAssigneeId = taskAssigneeId;
	}

	public long getTaskAssignee() {
		return taskAssignee;
	}

	public void setTaskAssignee(long taskAssignee) {
		this.taskAssignee = taskAssignee;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
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
				|| (this.taskAssigneeId != null && !this.taskAssigneeId
						.equals(other.taskAssigneeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.TaskAssignee[taskAssigneeId="
				+ taskAssigneeId + "]";
	}

}
