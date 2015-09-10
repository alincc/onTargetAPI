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
@Table(name = "project_task_files")
public class ProjectTaskFiles implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "task_file_id", nullable = false)
	private Integer taskFileId;
	@Basic(optional = false)
	@Column(name = "file_name", nullable = false, length = 255)
	private String fileName;
	@Basic(optional = false)
	@Column(name = "location", nullable = false, length = 255)
	private String location;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false)
	private int createdBy;
	@JoinColumn(name = "project_task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectTask projectTask;
	@Basic(optional = false)
	@Column(name = "status", nullable = false, length = 10)
	private String status;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;

	public ProjectTaskFiles() {
	}

	public ProjectTaskFiles(Integer taskFileId) {
		this.taskFileId = taskFileId;
	}

	public ProjectTaskFiles(Integer taskFileId, String fileName, String location, Date createdDate, int createdBy) {
		this.taskFileId = taskFileId;
		this.fileName = fileName;
		this.location = location;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
	}

	public Integer getTaskFileId() {
		return taskFileId;
	}

	public void setTaskFileId(Integer taskFileId) {
		this.taskFileId = taskFileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (taskFileId != null ? taskFileId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectTaskFiles)) {
			return false;
		}
		ProjectTaskFiles other = (ProjectTaskFiles) object;
		if ((this.taskFileId == null && other.taskFileId != null) || (this.taskFileId != null && !this.taskFileId.equals(other.taskFileId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectTaskFiles[taskFileId=" + taskFileId + "]";
	}

}
