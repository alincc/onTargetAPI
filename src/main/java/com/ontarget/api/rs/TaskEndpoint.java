package com.ontarget.api.rs;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.bean.TaskComment;
import com.ontarget.dto.*;
import com.ontarget.request.bean.DependentTaskRequest;
import com.ontarget.request.bean.ProjectTaskRequest;
import com.ontarget.request.bean.TaskAttachmentRequest;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.request.bean.TaskDetailRequest;
import com.ontarget.request.bean.TaskFileSaveRequest;
import com.ontarget.request.bean.TaskMemberRequest;
import com.ontarget.request.bean.TaskRequest;
import com.ontarget.request.bean.TaskStatusUpdateRequest;
import com.ontarget.request.bean.UserTask;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskEndpoint {

	public OnTargetResponse addTask(TaskRequest request);

	public TaskListResponse getTask(ProjectTaskRequest projectTaskRequest);

	public TaskListCountResponse getTaskCountByStatus(
			ProjectTaskRequest projectTaskRequest);

	public UserResponse addUpdateCommentToTask(TaskCommentRequest comment);

	public OnTargetResponse updateTaskStatus(TaskStatusUpdateRequest request);

	public OnTargetResponse addTaskMember(TaskMemberRequest taskMemberRequest);

	public InsertResponse saveTaskFile(TaskFileSaveRequest request);

	public OnTargetResponse assignTaskToUser(TaskMemberRequest taskMemberRequest);

	public InsertResponse addDependentTask(
			DependentTaskRequest dependentTaskRequest);

	public GetTaskAttachmentResponse getTaskAttachments(
			TaskAttachmentRequest taskAttachmentRequest);

	public TaskResponse getTaskDetail(TaskDetailRequest taskDetailRequest);
	
	public TaskListResponse getUserTask(UserTask userTask);
}
