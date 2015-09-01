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
@Table(name = "project_file")
public class ProjectFile implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_file_id", nullable = false)
	private Integer projectFileId;
	@Basic(optional = false)
	@Column(name = "file_name", nullable = false, length = 255)
	private String fileName;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne()
	private User createdBy;
	@Basic(optional = false)
	@Column(name = "file_type", nullable = false, length = 45)
	private String fileType;
	@JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Project project;
	@JoinColumn(name = "project_file_category_id", referencedColumnName = "project_file_category_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectFileCategory projectFileCategory;
	@Basic(optional = false)
	@Column(name = "description", length = 255)
	private String description;

	public ProjectFile() {
	}

	public ProjectFile(Integer projectFileId) {
		this.projectFileId = projectFileId;
	}

	public Integer getProjectFileId() {
		return projectFileId;
	}

	public void setProjectFileId(Integer projectFileId) {
		this.projectFileId = projectFileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public ProjectFileCategory getProjectFileCategory() {
		return projectFileCategory;
	}

	public void setProjectFileCategory(ProjectFileCategory projectFileCategory) {
		this.projectFileCategory = projectFileCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectFileId != null ? projectFileId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectFile)) {
			return false;
		}
		ProjectFile other = (ProjectFile) object;
		if ((this.projectFileId == null && other.projectFileId != null)
				|| (this.projectFileId != null && !this.projectFileId.equals(other.projectFileId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectFile[projectFileId=" + projectFileId + "]";
	}

}