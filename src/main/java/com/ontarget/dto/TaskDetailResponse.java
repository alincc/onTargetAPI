package com.ontarget.dto;

public class TaskDetailResponse extends OnTargetResponse {
	private ProjectTask projectTask;

	public ProjectTask getProjectTask() {
		return projectTask;
	}

	public void setProjectTask(ProjectTask projectTask) {
		this.projectTask = projectTask;
	}

}
