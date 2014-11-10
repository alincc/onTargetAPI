package com.ontarget.dto;

import com.ontarget.bean.Project;

import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectListResponse extends OnTargetResponse {

    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
