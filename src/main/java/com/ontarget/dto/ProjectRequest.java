package com.ontarget.dto;

import com.ontarget.bean.Project;

import java.io.Serializable;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectRequest implements Serializable{

    public ProjectRequest() {
    }

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
