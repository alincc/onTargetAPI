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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "project_task_comments")
public class ProjectTaskComments implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "task_comment_id", nullable = false)
	private Integer taskCommentId;
	@Column(name = "comment", nullable = false, length = 65535, columnDefinition = "TEXT")
	private String comment;
	@Basic(optional = false)
	@Column(name = "comment_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentDate;
	@JoinColumn(name = "comment_by", referencedColumnName = "user_id", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY)
	private User commentBy;
	@Basic(optional = false)
	@Column(name = "reply_to", nullable = false)
	private int replyTo;
	@JoinColumn(name = "project_task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProjectTask projectTask;

	public ProjectTaskComments() {
	}

	public ProjectTaskComments(Integer taskCommentId) {
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

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public User getCommentBy() {
		return commentBy;
	}

	public void setCommentBy(User commentBy) {
		this.commentBy = commentBy;
	}

	public int getReplyTo() {
		return replyTo;
	}

	public void setReplyTo(int replyTo) {
		this.replyTo = replyTo;
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
		if (!(object instanceof ProjectTaskComments)) {
			return false;
		}
		ProjectTaskComments other = (ProjectTaskComments) object;
		if ((this.taskCommentId == null && other.taskCommentId != null)
				|| (this.taskCommentId != null && !this.taskCommentId.equals(other.taskCommentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectTaskComments[taskCommentId=" + taskCommentId + "]";
	}

}
