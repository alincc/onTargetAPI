package com.ontarget.dto;

import com.ontarget.bean.ProjectDTO;

import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectListResponse extends OnTargetResponse {

	private List<ProjectDTO> projects;

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
}
