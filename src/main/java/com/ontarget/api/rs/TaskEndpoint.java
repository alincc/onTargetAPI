package com.ontarget.api.rs;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.bean.TaskComment;
import com.ontarget.dto.*;

import javax.ws.rs.*;

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

    public OnTargetResponse addTaskMember(TaskMemberRequest taskMemberRequest);

    public InsertResponse saveTaskFile(@QueryParam("taskid") long taskId, @QueryParam("userId") long userId, @QueryParam("fileName") String fileName, @QueryParam("location") String location);
}
