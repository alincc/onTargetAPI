package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;

public class ProjectResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
