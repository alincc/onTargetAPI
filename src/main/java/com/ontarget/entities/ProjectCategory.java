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
@Table(name = "project_category")
public class ProjectCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_category_id", nullable = false)
	private Integer projectCategoryId;
	@Basic(optional = false)
	@Column(name = "category_name", nullable = false, length = 255)
	private String categoryName;
	@Basic(optional = false)
	@Column(name = "parent_id", nullable = false)
	private int parentId;
	@Basic(optional = false)
	@Column(name = "created_by", nullable = false, length = 20)
	private String createdBy;
	@Basic(optional = false)
	@Column(name = "created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Basic(optional = false)
	@Column(name = "modified_by", nullable = false, length = 20)
	private String modifiedBy;
	@Basic(optional = false)
	@Column(name = "modified_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "delete_flag", columnDefinition = "TINYINT")
	private Short deleteFlag;
	@Column(name = "deleted_by", length = 20)
	private String deletedBy;
	@Column(name = "deleted_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;
	@OneToMany(mappedBy = "projectCategory", fetch = FetchType.LAZY)
	private List<Project> projectList;

	public ProjectCategory() {
	}

	public ProjectCategory(Integer projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	public ProjectCategory(Integer projectCategoryId, String categoryName, int parentId, String createdBy, Date createdDate,
			String modifiedBy, Date modifiedDate) {
		this.projectCategoryId = projectCategoryId;
		this.categoryName = categoryName;
		this.parentId = parentId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public Integer getProjectCategoryId() {
		return projectCategoryId;
	}

	public void setProjectCategoryId(Integer projectCategoryId) {
		this.projectCategoryId = projectCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Short getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Short deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public Date getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
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
		hash += (projectCategoryId != null ? projectCategoryId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectCategory)) {
			return false;
		}
		ProjectCategory other = (ProjectCategory) object;
		if ((this.projectCategoryId == null && other.projectCategoryId != null)
				|| (this.projectCategoryId != null && !this.projectCategoryId.equals(other.projectCategoryId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectCategory[projectCategoryId=" + projectCategoryId + "]";
	}

}
