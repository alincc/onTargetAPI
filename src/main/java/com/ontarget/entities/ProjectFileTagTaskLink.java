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

import lombok.Data;

/**
 *
 * @author santosh
 */
@Data
@Entity
@Table(name = "project_file_tag_task_link")
public class ProjectFileTagTaskLink implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_file_tag_task_link_id", nullable = false)
	private Long projectFileTagTaskLinkId;
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
	@JoinColumn(name = "project_file_tag_id", referencedColumnName = "project_file_tag_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProjectFileTag projectFileTag;
	@JoinColumn(name = "project_task_id", referencedColumnName = "project_task_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private ProjectTask projectTask;

	public ProjectFileTagTaskLink() {
	}

	public ProjectFileTagTaskLink(Long projectFileTagTaskLinkId) {
		super();
		this.projectFileTagTaskLinkId = projectFileTagTaskLinkId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectFileTagTaskLinkId != null ? projectFileTagTaskLinkId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectFileTagTaskLink)) {
			return false;
		}
		ProjectFileTagTaskLink other = (ProjectFileTagTaskLink) object;
		if ((this.projectFileTagTaskLinkId == null && other.projectFileTagTaskLinkId != null)
				|| (this.projectFileTagTaskLinkId != null && !this.projectFileTagTaskLinkId.equals(other.projectFileTagTaskLinkId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectFileTagTaskLink[projectFileTagTaskLinkId=" + projectFileTagTaskLinkId + "]";
	}
}
