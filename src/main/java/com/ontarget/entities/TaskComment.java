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
@Table(name = "task_comment")
public class TaskComment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "task_comment_id", nullable = false)
	private Integer taskCommentId;
	@Column(name = "comment", columnDefinition = "TEXT")
	private String comment;
	@Column(name = "commented_by")
	private Integer commentedBy;
	@Column(name = "commented_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentedDate;
	@Column(name = "comment_status", length = 15)
	private String commentStatus;
	@JoinColumn(name = "task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectTask projectTask;

	public TaskComment() {
	}

	public TaskComment(Integer taskCommentId) {
		this.taskCommentId = taskCommentId;
	}

	public Integer getTaskCommentId() {
		return taskCommentId;
	}

	public void setTaskCommentId(Integer taskCommentId) {
		this.taskCommentId = taskCommentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(Integer commentedBy) {
		this.commentedBy = commentedBy;
	}

	public Date getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Date commentedDate) {
		this.commentedDate = commentedDate;
	}

	public String getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
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
		hash += (taskCommentId != null ? taskCommentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof TaskComment)) {
			return false;
		}
		TaskComment other = (TaskComment) object;
		if ((this.taskCommentId == null && other.taskCommentId != null)
				|| (this.taskCommentId != null && !this.taskCommentId.equals(other.taskCommentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.TaskComment[taskCommentId=" + taskCommentId + "]";
	}

}
