package com.ontarget.api.response;

import java.util.List;

import com.ontarget.bean.TaskStatusCount;
import com.ontarget.dto.OnTargetResponse;

/**
 * Created by Owner on 11/12/14.
 */
public class TaskListCountResponse extends OnTargetResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskListCountResponse() {
	}

	List<TaskStatusCount> taskCountByStatus;

	public List<TaskStatusCount> getTaskCountByStatus() {
		return taskCountByStatus;
	}

	public void setTaskCountByStatus(List<TaskStatusCount> taskCountByStatus) {
		this.taskCountByStatus = taskCountByStatus;
	}
}
