package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.ProjectDTO;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectListResponse extends OnTargetResponse {

	private static final long serialVersionUID = 1L;
	private List<ProjectDTO> projects;

	public List<ProjectDTO> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}

}