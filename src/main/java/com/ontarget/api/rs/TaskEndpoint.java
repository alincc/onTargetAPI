package com.ontarget.api.rs;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.bean.TaskComment;
import com.ontarget.dto.*;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskEndpoint {

    public OnTargetResponse addTask(TaskRequest request);

    public TaskListResponse getTask(int projectId);

    public TaskListCountResponse getTaskCountByStatus(int projectId);

    public UserResponse addUpdateCommentToTask(TaskComment comment);

    public OnTargetResponse updateTaskStatus(TaskStatusUpdateRequest request);

    public OnTargetResponse addTaskMember(TaskMemberRequest taskMemberRequest);

    public InsertResponse saveTaskFile(TaskFileSaveRequest request);

    public OnTargetResponse assignTaskToUser(TaskMemberRequest taskMemberRequest);

    public InsertResponse addDependentTask(AddDependentRequest addDependentRequest);

    public GetTaskAttachmentResponse getTaskAttachments(long taskId);

    public TaskResponse getTaskDetail(int taskId);
}
