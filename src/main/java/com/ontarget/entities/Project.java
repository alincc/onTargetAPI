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
	private Integer projectParentId;
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
	@Column(name = "project_status", length = 1)
	private Integer projectStatus;
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@JoinColumn(name = "created_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdBy;
	@Column(name = "modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@JoinColumn(name = "modified_by", referencedColumnName = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private User modifiedBy;
	@Column(name = "project_image_path", length = 255)
	private String projectImagePath;
	@Column(name = "type", length = 15)
	private String type;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectMember> projectMemberList;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectWallPost> projectWallPostList;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectTask> projectTaskList;
	@JoinColumn(name = "project_type_id", referencedColumnName = "project_type_id", nullable = false)
	@ManyToOne(optional = false)
	private ProjectType projectType;
	@JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = true)
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private CompanyInfo companyInfo;
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	@ManyToOne()
	private Address address;
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<ProjectFile> projectFileList;
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
	private List<ProjectConfiguration> projectConfigurationList;

	@Column(name = "project_asset_folder_name", length = 30)
	private String projectAssetFolderName;

    @Column(name = "project_topic_arn", length = 255)
    private String projectTopicArn;


    public String getProjectAssetFolderName() {
		return projectAssetFolderName;
	}

	public void setProjectAssetFolderName(String projectAssetFolderName) {
		this.projectAssetFolderName = projectAssetFolderName;
	}

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

	public Integer getProjectParentId() {
		return projectParentId;
	}

	public void setProjectParentId(Integer projectParentId) {
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

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getProjectImagePath() {
		return projectImagePath;
	}

	public void setProjectImagePath(String projectImagePath) {
		this.projectImagePath = projectImagePath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<ProjectConfiguration> getProjectConfigurationList() {
		return projectConfigurationList;
	}

	public void setProjectConfigurationList(List<ProjectConfiguration> projectConfigurationList) {
		this.projectConfigurationList = projectConfigurationList;
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
		if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ontarget.entities.Project[projectId=" + projectId + "]";
	}

    public String getProjectTopicArn() {
        return projectTopicArn;
    }

    public void setProjectTopicArn(String projectTopicArn) {
        this.projectTopicArn = projectTopicArn;
    }
}
