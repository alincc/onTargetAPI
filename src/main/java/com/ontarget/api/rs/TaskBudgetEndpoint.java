package com.ontarget.api.rs;

import com.ontarget.api.response.TaskBudgetListResponse;
import com.ontarget.api.response.TaskBudgetResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.TaskBudget;
import com.ontarget.request.bean.TaskBudgetEstimationOfProject;
import com.ontarget.request.bean.TaskBudgetOfTask;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetEndpoint {

	public TaskBudgetResponse getTaskBudgetActualsAndEstimated(
			TaskBudgetEstimationOfProject taskBudgetEstimationOfProject);

	public OnTargetResponse addTaskBudget(TaskBudget taskBudget);

	public OnTargetResponse updateTaskBudget(TaskBudget taskBudget);

	public TaskBudgetListResponse getTaskBudgetByTaskId(
			TaskBudgetOfTask taskBudgetOfTask);
}
