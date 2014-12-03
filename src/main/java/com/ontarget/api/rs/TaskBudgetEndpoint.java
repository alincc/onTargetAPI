package com.ontarget.api.rs;

import com.ontarget.api.response.TaskBudgetListResponse;
import com.ontarget.api.response.TaskBudgetResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskBudgetRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetEndpoint {

    public TaskBudgetResponse getTaskBudgetActualsAndEstimated(@PathParam("projectId") int projectId);

    public OnTargetResponse addTaskBudget(TaskBudgetRequest request);

    public OnTargetResponse updateTaskBudget(TaskBudgetRequest request);

    public TaskBudgetListResponse getTaskBudgetByTaskId(@PathParam("taskId") int taskId);
}
