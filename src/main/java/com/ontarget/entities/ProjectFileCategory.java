package com.ontarget.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "project_file_category")
public class ProjectFileCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_file_category_id", nullable = false)
	private Integer projectFileCategoryId;
	@Basic(optional = false)
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	@Basic(optional = false)
	@Column(name = "active", nullable = false, length = 1)
	private String active;

	public ProjectFileCategory() {
	}

	public ProjectFileCategory(Integer projectFileCategoryId) {
		this.projectFileCategoryId = projectFileCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Integer getProjectFileCategoryId() {
		return projectFileCategoryId;
	}

	public void setProjectFileCategoryId(Integer projectFileCategoryId) {
		this.projectFileCategoryId = projectFileCategoryId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectFileCategoryId != null ? projectFileCategoryId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof ProjectFileCategory)) {
			return false;
		}
		ProjectFileCategory other = (ProjectFileCategory) object;
		if ((this.projectFileCategoryId == null && other.projectFileCategoryId != null)
				|| (this.projectFileCategoryId != null && !this.projectFileCategoryId.equals(other.projectFileCategoryId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.ProjectFileCategory[projectFileId=" + projectFileCategoryId + "]";
	}

}
