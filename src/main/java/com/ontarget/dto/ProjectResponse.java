package com.ontarget.dto;

import com.ontarget.bean.Project;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectResponse extends UserResponse {

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
