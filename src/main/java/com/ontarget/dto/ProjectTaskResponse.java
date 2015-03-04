package com.ontarget.dto;

import java.util.List;

public class ProjectTaskResponse extends OnTargetResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ProjectTask> tasks;

	public List<ProjectTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<ProjectTask> tasks) {
		this.tasks = tasks;
	}

}
