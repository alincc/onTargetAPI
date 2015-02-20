package com.ontarget.api.rs;

import com.ontarget.api.response.TaskPercentageListResponse;
import com.ontarget.api.response.TaskPercentageResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddTaskProgress;
import com.ontarget.request.bean.TaskPercentageOfProject;
import com.ontarget.request.bean.TaskPercentageOfTask;
import com.ontarget.request.bean.UpdateTaskProgress;

/**
 * Created by Owner on 11/25/14.
 */
public interface TaskPercentageEndpoint {

	public OnTargetResponse addTaskPercentageComplete(
			AddTaskProgress addTaskProgress);

	public OnTargetResponse updateTaskPercentageComplete(
			UpdateTaskProgress request);

	public TaskPercentageListResponse getTaskPercentagesByTask(
			TaskPercentageOfTask taskPercentageOfTask);

	public TaskPercentageResponse getTaskPercentageByProject(
			TaskPercentageOfProject taskPercentageOfProject);
}
