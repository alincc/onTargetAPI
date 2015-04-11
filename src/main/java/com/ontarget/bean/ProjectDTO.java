package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectDTO implements Serializable {
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

	@Override
	public String toString() {
		return "Project{" + "projectId=" + projectId + ", projectName='" + projectName + '\'' + ", projectDescription='"
				+ projectDescription + '\'' + ", projectTypeId=" + projectTypeId + ", projectOwnerId=" + projectOwnerId
				+ ", status='" + status + '\'' + ", companyId=" + companyId + ", parentType" + parentType + ", company="
				+ company + ", projectParentId=" + projectParentId + ", projectAddress=" + projectAddress + ", taskList="
				+ taskList + ", projects=" + projects + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", projectImagePath='" + projectImagePath + '\'' + '}';
	}

}
