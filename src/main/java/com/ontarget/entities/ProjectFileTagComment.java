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
@Table(name = "project_file_tag_comment")
public class ProjectFileTagComment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_file_tag_comment_id", nullable = false)
	private Long projectFileTagCommentId;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id", nullable = false)
	@ManyToOne()
	private User createdBy;
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User modifiedBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "status", length = 10, nullable = false)
	private String status;
	@Column(name = "comment", columnDefinition = "TEXT")
	private String comment;
	@JoinColumn(name = "project_file_tag_id", referencedColumnName = "project_file_tag_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectFileTag projectFileTag;

	public ProjectFileTagComment() {
	}

	public ProjectFileTagComment(Long projectFileTagCommentId) {
		super();
		this.projectFileTagCommentId = projectFileTagCommentId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectFileTagCommentId != null ? projectFileTagCommentId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectFileTagComment)) {
			return false;
		}
		ProjectFileTagComment other = (ProjectFileTagComment) object;
		if ((this.projectFileTagCommentId == null && other.projectFileTagCommentId != null)
				|| (this.projectFileTagCommentId != null && !this.projectFileTagCommentId.equals(other.projectFileTagCommentId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectFileTagComment[projectFileTagCommentId=" + projectFileTagCommentId + "]";
	}

}
