package com.ontarget.response.bean;

import java.util.List;

import com.ontarget.dto.OnTargetResponse;

public class ProjectListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}
