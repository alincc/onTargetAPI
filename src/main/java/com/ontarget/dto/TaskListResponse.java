package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.TaskInfo;

/**
 * Created by Owner on 11/7/14.
 */
public class TaskListResponse extends OnTargetResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3090534415304868537L;
	private List<TaskInfo> tasks;

	public List<TaskInfo> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskInfo> tasks) {
		this.tasks = tasks;
	}
}
