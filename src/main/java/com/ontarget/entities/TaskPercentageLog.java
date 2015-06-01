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
@Table(name = "task_percentage_log")
public class TaskPercentageLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "task_percentage_log_id", nullable = false)
	private Integer taskPercentageLogId;
	@Column(name = "percentage_type", length = 45)
	private String percentageType;
	@Column(name = "percentage_complete", precision = 22)
	private Double percentageComplete;
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Column(name = "end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User createdBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProjectTask projectTask;

	public TaskPercentageLog() {
	}

	public TaskPercentageLog(Integer taskPercentageLogId) {
		this.taskPercentageLogId = taskPercentageLogId;
	}

	public Integer getTaskPercentageLogId() {
		return taskPercentageLogId;
	}

	public void setTaskPercentageLogId(Integer taskPercentageLogId) {
		this.taskPercentageLogId = taskPercentageLogId;
	}

	public String getPercentageType() {
		return percentageType;
	}

	public void setPercentageType(String percentageType) {
		this.percentageType = percentageType;
	}

	public Double getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(Double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
		hash += (taskPercentageLogId != null ? taskPercentageLogId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TaskPercentageLog)) {
			return false;
		}
		TaskPercentageLog other = (TaskPercentageLog) object;
		if ((this.taskPercentageLogId == null && other.taskPercentageLogId != null)
				|| (this.taskPercentageLogId != null && !this.taskPercentageLogId.equals(other.taskPercentageLogId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.TaskPercentageLog[taskPercentageLogId=" + taskPercentageLogId + "]";
	}

}
