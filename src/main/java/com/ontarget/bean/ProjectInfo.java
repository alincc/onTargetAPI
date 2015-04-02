package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectInfo implements Serializable {
	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private Integer projectTypeId;
	private Integer projectOwnerId;
	private String status;
	private Integer companyId;
	private Company company;
	private Integer projectParentId;
	private AddressDTO projectAddress;
	private Date startDate;
	private Date endDate;
	private String projectImagePath;
	private List<TaskObj> taskList;
	private List<ProjectInfo> projects;

	public List<ProjectInfo> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectInfo> projects) {
		this.projects = projects;
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

	public List<TaskObj> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskObj> taskList) {
		this.taskList = taskList;
	}

}
