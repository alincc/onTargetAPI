package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private Integer projectTypeId;
	private String parentType;
	private String type;
	private Integer projectOwnerId;
	private String status;
	private Integer companyId;
	private Company company;
	private Integer projectParentId;
	private AddressDTO projectAddress;
	private List<TaskInfo> taskList;
	private List<TaskObj> taskObjList;
	private List<ProjectDTO> projects;
	private Date startDate;
	private Date endDate;
	private String projectImagePath;
	private String unitOfMeasurement;
	private List<ProjectConfigDTO> projectConfiguration;
	private Integer percentageComplete;
    private String projectAssetFolderName;

    public String getProjectAssetFolderName() {
        return projectAssetFolderName;
    }

    public void setProjectAssetFolderName(String projectAssetFolderName) {
        this.projectAssetFolderName = projectAssetFolderName;
    }

	public ProjectDTO() {
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

	public AddressDTO getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(AddressDTO projectAddress) {
		this.projectAddress = projectAddress;
	}

	public List<TaskInfo> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskInfo> taskList) {
		this.taskList = taskList;
	}

	public List<TaskObj> getTaskObjList() {
		return taskObjList;
	}

	public void setTaskObjList(List<TaskObj> taskObjList) {
		this.taskObjList = taskObjList;
	}

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
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

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public List<ProjectConfigDTO> getProjectConfiguration() {
		return projectConfiguration;
	}

	public void setProjectConfiguration(List<ProjectConfigDTO> projectConfiguration) {
		this.projectConfiguration = projectConfiguration;
	}

	public Integer getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(Integer percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Project{");
		sb.append(",projectName: " + projectName);
		sb.append(",projectDescription: " + projectDescription);
		sb.append(",projectTypeId=" + projectTypeId);
		sb.append(",projectOwnerId=" + projectOwnerId);
		sb.append(",status=" + status);
		sb.append(",companyId=" + companyId);
		sb.append(",parentType=" + parentType);
		sb.append(",company=" + companyId);
		sb.append(",parentProjectId=" + projectTypeId);
		sb.append(",projectAddress=" + projectAddress);
		sb.append(",taskList=" + taskList);
		sb.append(",projects=" + projects);
		sb.append(",startDate=" + startDate);
		sb.append(",endDate=" + endDate);
		sb.append(",unitOfMeasurement=" + unitOfMeasurement);
		sb.append("}");
		return sb.toString();
	}

}
