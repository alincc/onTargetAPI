package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjectDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8528631105379784034L;
	private Integer projectId;
	private String projectName;
	private String projectDescription;
	private int projectTypeId;
	private long projectOwnerId;
	private String status;
	private int companyId;// TODO: add company object instead of companyId
	private Company company;
	private int projectParentId;
	private AddressDTO projectAddress;
	private List<TaskDTO> taskList;
	private List<ProjectDTO> projects;
	private Date startDate;
	private Date endDate;
	private String projectImagePath;

	public ProjectDTO() {
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public long getProjectOwnerId() {
		return projectOwnerId;
	}

	public void setProjectOwnerId(long projectOwnerId) {
		this.projectOwnerId = projectOwnerId;
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

	public AddressDTO getProjectAddress() {
		return projectAddress;
	}

	public void setProjectAddress(AddressDTO projectAddress) {
		this.projectAddress = projectAddress;
	}

	public List<TaskDTO> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskDTO> taskList) {
		this.taskList = taskList;
	}

	public int getProjectParentId() {
		return projectParentId;
	}

	public void setProjectParentId(int projectParentId) {
		this.projectParentId = projectParentId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(int projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Override
	public String toString() {
		return "Project{" + "projectId=" + projectId + ", projectName='"
				+ projectName + '\'' + ", projectDescription='"
				+ projectDescription + '\'' + ", projectTypeId="
				+ projectTypeId + ", projectOwnerId=" + projectOwnerId
				+ ", status='" + status + '\'' + ", companyId=" + companyId
				+ ", company=" + company + ", projectParentId="
				+ projectParentId + ", projectAddress=" + projectAddress
				+ ", taskList=" + taskList + ", projects=" + projects
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", projectImagePath='" + projectImagePath + '\'' + '}';
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

}
