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

import lombok.Data;

/**
 *
 * @author santosh
 */
@Data
@Entity
@Table(name = "project_bim_file_comment")
public class ProjectBimFileComment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_bim_file_comment_id", nullable = false)
	private Integer projectBimFileCommentId;
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
	@JoinColumn(name = "project_bim_file_id", referencedColumnName = "project_bim_file_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectBimFile projectBimFile;

	public ProjectBimFileComment() {
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectBimFileCommentId != null ? projectBimFileCommentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectBimFileComment)) {
			return false;
		}
		ProjectBimFileComment other = (ProjectBimFileComment) object;
		if ((this.projectBimFileCommentId == null && other.projectBimFileCommentId != null)
				|| (this.projectBimFileCommentId != null && !this.projectBimFileCommentId.equals(other.projectBimFileCommentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectBimFileComment[projectBimFileCommentId=" + projectBimFileCommentId + "]";
	}

}
