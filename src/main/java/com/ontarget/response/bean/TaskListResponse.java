package com.ontarget.response.bean;

import java.util.List;

import com.ontarget.dto.OnTargetResponse;

public class TaskListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
