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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author santosh
 */
@Entity
@Table(name = "project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "project_id", nullable = false)
	private Integer projectId;
	@Column(name = "project_code", length = 50)
	private String projectCode;
	@Column(name = "project_name", length = 300)
	private String projectName;
	@Column(name = "project_owner_id")
	private Integer projectOwnerId;
	@Basic(optional = false)
	@Column(name = "project_parent_id", nullable = false)
	private int projectParentId;
	@Column(name = "project_assignee", length = 45)
	private String projectAssignee;
	@Column(name = "project_description", columnDefinition = "TEXT")
	private String projectDescription;
	@Column(name = "project_image", length = 255)
	private String projectImage;
	@Column(name = "project_start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date projectStartDate;
	@Column(name = "project_end_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date projectEndDate;
	@Column(name = "project_status", length = 10)
	private String projectStatus;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "created_by", length = 20)
	private String createdBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "modified_by", length = 20)
	private String modifiedBy;
	@Column(name = "delete_flag", columnDefinition = "TINYINT")
	private Short deleteFlag;
	@Column(name = "deleted_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deletedDate;
	@Column(name = "deleted_by", length = 20)
	private String deletedBy;
	@Column(name = "project_image_path", length = 255)
	private String projectImagePath;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectMember> projectMemberList;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectWallPost> projectWallPostList;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectTask> projectTaskList;
	@JoinColumn(name = "project_type_id", referencedColumnName = "project_type_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectType projectType;
	@JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
	@ManyToOne(optional = false)
	private CompanyInfo companyInfo;
	@JoinColumn(name = "project_category_id", referencedColumnName = "project_category_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private ProjectCategory projectCategory;
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Address address;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectFile> projectFileList;

	public Project() {
	}

	public Project(Integer projectId) {
		this.projectId = projectId;
	}

	public Project(Integer projectId, int projectParentId) {
		this.projectId = projectId;
		this.projectParentId = projectParentId;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getProjectOwnerId() {
		return projectOwnerId;
	}

	public void setProjectOwnerId(Integer projectOwnerId) {
		this.projectOwnerId = projectOwnerId;
	}

	public int getProjectParentId() {
		return projectParentId;
	}

	public void setProjectParentId(int projectParentId) {
		this.projectParentId = projectParentId;
	}

	public String getProjectAssignee() {
		return projectAssignee;
	}

	public void setProjectAssignee(String projectAssignee) {
		this.projectAssignee = projectAssignee;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectImage() {
		return projectImage;
	}

	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
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

	public String getProjectImagePath() {
		return projectImagePath;
	}

	public void setProjectImagePath(String projectImagePath) {
		this.projectImagePath = projectImagePath;
	}

	public List<ProjectMember> getProjectMemberList() {
		return projectMemberList;
	}

	public void setProjectMemberList(List<ProjectMember> projectMemberList) {
		this.projectMemberList = projectMemberList;
	}

	public List<ProjectWallPost> getProjectWallPostList() {
		return projectWallPostList;
	}

	public void setProjectWallPostList(List<ProjectWallPost> projectWallPostList) {
		this.projectWallPostList = projectWallPostList;
	}

	public List<ProjectTask> getProjectTaskList() {
		return projectTaskList;
	}

	public void setProjectTaskList(List<ProjectTask> projectTaskList) {
		this.projectTaskList = projectTaskList;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<ProjectFile> getProjectFileList() {
		return projectFileList;
	}

	public void setProjectFileList(List<ProjectFile> projectFileList) {
		this.projectFileList = projectFileList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projectId != null ? projectId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Project)) {
			return false;
		}
		Project other = (Project) object;
		if ((this.projectId == null && other.projectId != null)
				|| (this.projectId != null && !this.projectId.equals(other.projectId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.Project[projectId=" + projectId + "]";
	}

}
