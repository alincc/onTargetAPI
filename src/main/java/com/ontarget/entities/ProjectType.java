package com.ontarget.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "project_type")
public class ProjectType implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_type_id", nullable = false)
	private Integer projectTypeId;
	@Basic(optional = false)
	@Column(name = "project_type_name", nullable = false, length = 255)
	private String projectTypeName;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false, length = 20)
	private String createdBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false, length = 20)
	private String modifiedBy;
	@Column(name = "delete_flag", columnDefinition = "TINYINT")
	private Short deleteFlag;
	@Column(name = "deleted_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;
	@Column(name = "deleted_by", length = 20)
	private String deletedBy;
	@Basic(optional = false)
	@Column(name = "status", nullable = false, length = 10)
	private String status;
	@OneToMany(mappedBy = "projectType", fetch = FetchType.LAZY)
	private List<Project> projectList;

	public ProjectType() {
	}

	public ProjectType(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public ProjectType(Integer projectTypeId, String projectTypeName, Date createdDate, String createdBy, Date modifiedDate,
			String modifiedBy, String status) {
		this.projectTypeId = projectTypeId;
		this.projectTypeName = projectTypeName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.status = status;
	}

	public Integer getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
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

	public Short getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectTypeId != null ? projectTypeId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectType)) {
			return false;
		}
		ProjectType other = (ProjectType) object;
		if ((this.projectTypeId == null && other.projectTypeId != null)
				|| (this.projectTypeId != null && !this.projectTypeId.equals(other.projectTypeId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectType[projectTypeId=" + projectTypeId + "]";
	}

}
