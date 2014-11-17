package com.ontarget.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Owner on 10/29/14.
 */
public class Project implements Serializable{

    private int projectId;
    private String projectName;
    private String projectDescription;
    private int projectTypeId;
    private String status;
    private int companyId;//TODO: add company object instead of companyId
    private int projectParentId;
    private Address projectAddress;
    private List<Task> taskList;
    private List<Project> projects;

    public Project() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Address getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(Address projectAddress) {
        this.projectAddress = projectAddress;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
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
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectTypeId='" + projectTypeId + '\'' +
                ", status='" + status + '\'' +
                ", companyId=" + companyId +
                ", projectParentId=" + projectParentId +
                ", projectAddress=" + projectAddress +
                ", taskList=" + taskList +
                '}';
    }


    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
