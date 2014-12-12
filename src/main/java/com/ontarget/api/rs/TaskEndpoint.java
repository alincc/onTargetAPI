package com.ontarget.api.rs;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.bean.TaskComment;
import com.ontarget.dto.*;

import javax.ws.rs.QueryParam;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskEndpoint {

    public OnTargetResponse addTask(TaskRequest request);

    public TaskListResponse getTask(int projectId);

    public TaskListCountResponse getTaskCountByStatus(int projectId);

    public OnTargetResponse addUpdateCommentToTask(TaskComment comment);

    public OnTargetResponse updateTaskStatus(long taskId, String taskStatus);

    public OnTargetResponse addTaskMember(TaskMemberRequest taskMemberRequest);

    public InsertResponse saveTaskFile(@QueryParam("taskid") long taskId, @QueryParam("userId") long userId, @QueryParam("fileName") String fileName, @QueryParam("location") String location);

    public OnTargetResponse assignTaskToUser(TaskMemberRequest taskMemberRequest);
}
