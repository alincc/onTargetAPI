package com.ontarget.dto;

import com.ontarget.bean.ProjectDTO;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectResponse extends UserResponse {

	private ProjectDTO project;

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}
}
