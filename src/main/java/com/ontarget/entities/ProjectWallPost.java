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
@Table(name = "project_wall_post")
public class ProjectWallPost implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_wall_post_id", nullable = false)
	private Integer projectWallPostId;
	@Column(name = "project_wall_post", length = 45)
	private String projectWallPost;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false, length = 45)
	private String createdBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false, length = 45)
	private String modifiedBy;
	@JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
	@ManyToOne(optional = false,fetch=FetchType.LAZY)
	private Project project;

	public ProjectWallPost() {
	}

	public ProjectWallPost(Integer projectWallPostId) {
		this.projectWallPostId = projectWallPostId;
	}

	public ProjectWallPost(Integer projectWallPostId, Date createdDate,
			String createdBy, Date modifiedDate, String modifiedBy) {
		this.projectWallPostId = projectWallPostId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}

	public Integer getProjectWallPostId() {
		return projectWallPostId;
	}

	public void setProjectWallPostId(Integer projectWallPostId) {
		this.projectWallPostId = projectWallPostId;
	}

	public String getProjectWallPost() {
		return projectWallPost;
	}

	public void setProjectWallPost(String projectWallPost) {
		this.projectWallPost = projectWallPost;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectWallPostId != null ? projectWallPostId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectWallPost)) {
			return false;
		}
		ProjectWallPost other = (ProjectWallPost) object;
		if ((this.projectWallPostId == null && other.projectWallPostId != null)
				|| (this.projectWallPostId != null && !this.projectWallPostId
						.equals(other.projectWallPostId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectWallPost[projectWallPostId="
				+ projectWallPostId + "]";
	}

}
