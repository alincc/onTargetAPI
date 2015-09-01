package com.ontarget.response.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ontarget.bean.Company;

public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private Integer projectTypeId;
	private String type;
	private Integer projectOwnerId;
	private String status;
	private Integer companyId;
	private Company company;
	private Integer projectParentId;
	private Address projectAddress;
	private Date startDate;
	private Date endDate;
	private int percentageComplete;
	private String projectImagePath;
	private List<ProjectConfig> projectConfiguration;
    private String projectAssetFolderName;

    public String getProjectAssetFolderName() {
        return projectAssetFolderName;
    }

    public void setProjectAssetFolderName(String projectAssetFolderName) {
        this.projectAssetFolderName = projectAssetFolderName;
    }

    public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Integer getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getProjectOwnerId() {
		return projectOwnerId;
	}

	public void setProjectOwnerId(Integer projectOwnerId) {
		this.projectOwnerId = projectOwnerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getProjectParentId() {
		return projectParentId;
	}

	public void setProjectParentId(Integer projectParentId) {
		this.projectParentId = projectParentId;
	}

	public Address getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(Address projectAddress) {
		this.projectAddress = projectAddress;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getProjectImagePath() {
		return projectImagePath;
	}

	public void setProjectImagePath(String projectImagePath) {
		this.projectImagePath = projectImagePath;
	}

	public List<ProjectConfig> getProjectConfiguration() {
		return projectConfiguration;
	}

	public void setProjectConfiguration(List<ProjectConfig> projectConfiguration) {
		this.projectConfiguration = projectConfiguration;
	}

	public int getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(int percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

}
