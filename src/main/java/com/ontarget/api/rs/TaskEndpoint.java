package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.dto.GetTaskAttachmentResponse;
import com.ontarget.dto.InsertResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectTaskResponse;
import com.ontarget.dto.TaskDetailResponse;
import com.ontarget.dto.TaskListResponse;
import com.ontarget.dto.TaskResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.request.bean.DependentTaskDetail;
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

	public OnTargetResponse addTask(@Valid TaskRequest request);

	public ProjectTaskResponse getTask(
			@Valid ProjectTaskRequest projectTaskRequest);

	public TaskListCountResponse getTaskCountByStatus(
			@Valid ProjectTaskRequest projectTaskRequest);

	public UserResponse addUpdateCommentToTask(@Valid TaskCommentRequest comment);

	public OnTargetResponse updateTaskStatus(
			@Valid TaskStatusUpdateRequest request);

	public OnTargetResponse addTaskMember(
			@Valid TaskMemberRequest taskMemberRequest);

	public InsertResponse saveTaskFile(@Valid TaskFileSaveRequest request);

	public OnTargetResponse assignTaskToUser(
			@Valid TaskMemberRequest taskMemberRequest);

	public InsertResponse addDependentTask(
			@Valid DependentTaskRequest dependentTaskRequest);

	public ProjectTaskResponse getDependentTasks(
			@Valid DependentTaskDetail dependentTaskDetail);

	public GetTaskAttachmentResponse getTaskAttachments(
			@Valid TaskAttachmentRequest taskAttachmentRequest);

	public TaskDetailResponse getTaskDetail(
			@Valid TaskDetailRequest taskDetailRequest);

	public ProjectTaskResponse getUserTask(@Valid UserTask userTask);
}
