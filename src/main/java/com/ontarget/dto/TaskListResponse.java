package com.ontarget.dto;

import com.ontarget.bean.TaskDTO;

import java.util.List;

/**
 * Created by Owner on 11/7/14.
 */
public class TaskListResponse extends OnTargetResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3090534415304868537L;
	private List<TaskDTO> tasks;

	public List<TaskDTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDTO> tasks) {
		this.tasks = tasks;
	}
}
