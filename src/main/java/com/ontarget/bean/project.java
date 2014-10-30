package com.ontarget.bean;

import java.util.List;

/**
 * Created by Owner on 10/29/14.
 */
public class project {

    private String projectId;
    private String projectName;
    private String projectDescriptioin;
    private String projectType;

    private List<Task> taskList;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescriptioin() {
        return projectDescriptioin;
    }

    public void setProjectDescriptioin(String projectDescriptioin) {
        this.projectDescriptioin = projectDescriptioin;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @Override
    public String toString() {
        return "project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectDescriptioin='" + projectDescriptioin + '\'' +
                ", projectType='" + projectType + '\'' +
                '}';
    }
}
