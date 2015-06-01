package com.ontarget.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "task_status")
public class TaskStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "task_status_id", nullable = false)
	private Integer taskStatusId;
	@Column(name = "status_code", length = 15)
	private String statusCode;
	@Column(name = "status_name", length = 15)
	private String statusName;
	@Column(name = "status_description", length = 45)
	private String statusDescription;

	public TaskStatus() {
	}

	public TaskStatus(Integer taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public Integer getTaskStatusId() {
		return taskStatusId;
	}

	public void setTaskStatusId(Integer taskStatusId) {
		this.taskStatusId = taskStatusId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taskStatusId != null ? taskStatusId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TaskStatus)) {
			return false;
		}
		TaskStatus other = (TaskStatus) object;
		if ((this.taskStatusId == null && other.taskStatusId != null)
				|| (this.taskStatusId != null && !this.taskStatusId
						.equals(other.taskStatusId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.TaskStatus[taskStatusId=" + taskStatusId
				+ "]";
	}

}
