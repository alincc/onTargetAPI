package com.ontarget.api.rs;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.bean.TaskComment;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.TaskListResponse;
import com.ontarget.dto.TaskRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskEndpoint {

    public OnTargetResponse addTask(TaskRequest request);

    public TaskListResponse getTask(int projectId);

    @GET
    @Path("/getTaskCount/project/{projectId}")
    TaskListCountResponse getTaskCountByStatus(@PathParam("projectId") int projectId);

    @POST
    @Path("/addComment")
    OnTargetResponse addUpdateCommentToTask(TaskComment comment);

    public OnTargetResponse updateTaskStatus(long taskId, String taskStatus);
}
