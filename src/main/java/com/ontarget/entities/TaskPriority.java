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
@Table(name = "task_priority")
public class TaskPriority implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "task_priority_id", nullable = false)
	private Integer taskPriorityId;
	@Column(name = "priority", length = 20, nullable = false)
	private String priority;
	@Column(name = "code", length = 20, nullable = false)
	private String code;

	public TaskPriority() {
	}

	public Integer getTaskPriorityId() {
		return taskPriorityId;
	}

	public void setTaskPriorityId(Integer taskPriorityId) {
		this.taskPriorityId = taskPriorityId;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taskPriorityId != null ? taskPriorityId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TaskPriority)) {
			return false;
		}
		TaskPriority other = (TaskPriority) object;
		if ((this.taskPriorityId == null && other.taskPriorityId != null)
				|| (this.taskPriorityId != null && !this.taskPriorityId.equals(other.taskPriorityId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.TaskPriority[taskPriorityId=" + taskPriorityId + "]";
	}

}
