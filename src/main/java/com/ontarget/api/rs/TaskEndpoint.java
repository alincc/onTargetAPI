package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskListResponse;
import com.ontarget.dto.TaskRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskEndpoint {

    public OnTargetResponse addTask(TaskRequest request);

    public TaskListResponse getTask(int projectId);
}
