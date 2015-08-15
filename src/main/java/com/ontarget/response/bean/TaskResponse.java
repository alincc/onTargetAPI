package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;

public class TaskResponse extends OnTargetResponse {

	private static final long serialVersionUID = 1L;
	private Task task;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
