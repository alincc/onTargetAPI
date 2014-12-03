package com.ontarget.api.rs;

import com.ontarget.api.response.TaskBudgetResponse;
import com.ontarget.api.response.TaskPercentageListResponse;
import com.ontarget.api.response.TaskPercentageResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskPercentageRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Owner on 11/25/14.
 */
public interface TaskPercentageEndpoint {

    public OnTargetResponse addTaskPercentageComplete(TaskPercentageRequest request);

    public OnTargetResponse updateTaskPercentageComplete(TaskPercentageRequest request);

    public TaskPercentageListResponse getTaskPercentagesByTask(@PathParam("taskId") int taskId);

    public TaskPercentageResponse getTaskPercentageByProject(@PathParam("projectId") int projectId);
}
