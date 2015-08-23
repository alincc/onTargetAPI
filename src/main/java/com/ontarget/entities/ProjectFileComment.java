package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "project_file_comment")
public class ProjectFileComment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_file_comment_id", nullable = false)
	private Integer projectFileCommentId;
	@Column(name = "comment", columnDefinition = "TEXT")
	private String comment;
	@JoinColumn(name = "commented_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User commentedBy;
	@Column(name = "commented_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date commentedDate;
	@Column(name = "comment_status", length = 15)
	private String commentStatus;
	@JoinColumn(name = "project_file_id", referencedColumnName = "project_file_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectFile projectFile;

	public ProjectFileComment() {
	}

	public ProjectFileComment(Integer projectFileCommentId) {
		this.projectFileCommentId = projectFileCommentId;
	}

	public Integer getProjectFileCommentId() {
		return projectFileCommentId;
	}

	public void setProjectFileCommentId(Integer projectFileCommentId) {
		this.projectFileCommentId = projectFileCommentId;
	}

	public ProjectFile getProjectFile() {
		return projectFile;
	}

	public void setProjectFile(ProjectFile projectFile) {
		this.projectFile = projectFile;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(User commentedBy) {
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

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectFileCommentId != null ? projectFileCommentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectFileComment)) {
			return false;
		}
		ProjectFileComment other = (ProjectFileComment) object;
		if ((this.projectFileCommentId == null && other.projectFileCommentId != null)
				|| (this.projectFileCommentId != null && !this.projectFileCommentId.equals(other.projectFileCommentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectFileComment[projectFileCommentId=" + projectFileCommentId + "]";
	}

}
