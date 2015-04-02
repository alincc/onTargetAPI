package com.ontarget.dto;

import com.ontarget.bean.ProjectInfo;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectResponse extends OnTargetResponse {

	private ProjectInfo project;

	public ProjectInfo getProject() {
		return project;
	}

	public void setProject(ProjectInfo project) {
		this.project = project;
	}
}
