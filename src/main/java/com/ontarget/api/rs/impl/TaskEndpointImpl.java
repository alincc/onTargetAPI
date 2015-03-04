package com.ontarget.api.rs.impl;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.api.rs.TaskEndpoint;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDependentRequest;
import com.ontarget.dto.GetTaskAttachmentResponse;
import com.ontarget.dto.InsertResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectTaskResponse;
import com.ontarget.dto.TaskDetailResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.exception.DateAfterException;
import com.ontarget.exception.DateBeforeException;
import com.ontarget.request.bean.DependentTaskDetail;
import com.ontarget.request.bean.DependentTaskRequest;
import com.ontarget.request.bean.ProjectTaskRequest;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskAttachmentRequest;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.request.bean.TaskDetailRequest;
import com.ontarget.request.bean.TaskFileSaveRequest;
import com.ontarget.request.bean.TaskMemberRequest;
import com.ontarget.request.bean.TaskRequest;
import com.ontarget.request.bean.TaskStatusUpdateRequest;
import com.ontarget.request.bean.UserTask;
import com.ontarget.util.ConvertPOJOUtils;

/**
 * Created by Owner on 11/6/14.
 */
@Component
@Path("/task")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskEndpointImpl implements TaskEndpoint {

	private Logger logger = Logger.getLogger(TaskEndpointImpl.class);

	@Autowired
	private TaskService taskService;

	@Override
	@Path("/addTask")
	@POST
	public OnTargetResponse addTask(TaskRequest taskRequest) {
		OnTargetResponse response = new OnTargetResponse();
		Task task = taskRequest.getTask();
		try {
			if (taskService.addTaskService(task, taskRequest.getUserId())) {
				if (taskService.isTaskAdd(task)) {
					response.setReturnMessage("Successfully added task");
				} else {
					response.setReturnMessage("Successfully updated task");
				}
				response.setReturnVal(OnTargetConstant.SUCCESS);
			}
		} catch (DateAfterException e) {
			response.setReturnMessage(e.getMessage());
			response.setReturnVal(OnTargetConstant.ERROR);
		} catch (DateBeforeException e) {
			response.setReturnMessage(e.getMessage());
			response.setReturnVal(OnTargetConstant.ERROR);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Add task failed." + e);
			if (taskService.isTaskAdd(task)) {
				response.setReturnMessage("Add task failed");
			} else {
				response.setReturnMessage("Update task failed");
			}

			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/getProjectTask")
	public ProjectTaskResponse getTask(ProjectTaskRequest projectTaskRequest) {
		ProjectTaskResponse response = new ProjectTaskResponse();
		try {

			response.setTasks(taskService.getTasksByProject(projectTaskRequest
					.getProjectId()));
			response.setReturnMessage("Successfully retrieved tasks");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Add task failed." + e);
			response.setReturnMessage("Add task failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/getTaskCountsOfProject")
	public TaskListCountResponse getTaskCountByStatus(
			ProjectTaskRequest projectTaskRequest) {
		TaskListCountResponse response = new TaskListCountResponse();
		logger.info("Getting all tasks count for project: "
				+ projectTaskRequest.getProjectId());
		try {
			response.setTaskCountByStatus(taskService
					.getTaskCountByStatus(projectTaskRequest.getProjectId()));
			response.setReturnMessage("Successfully retrieved tasks and counts");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			logger.error("Get task count failed." + e);
			response.setReturnMessage("Get task count failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/addComment")
	public UserResponse addUpdateCommentToTask(TaskCommentRequest comment) {
		UserResponse response = new UserResponse();
		try {
			Contact contact = taskService.addTaskComment(comment);
			if (contact == null) {
				response.setReturnMessage("Add task comment failed");
				response.setReturnVal(OnTargetConstant.ERROR);
			} else {
				UserDTO user = new UserDTO();
				user.setContact(contact);
				response.setUser(user);
				response.setReturnMessage("Successfully added Comment");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			}
		} catch (Exception e) {
			logger.error("Add task failed." + e);
			response.setReturnMessage("Add task comment failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/getTaskDetail")
	public TaskDetailResponse getTaskDetail(TaskDetailRequest taskDetailRequest) {
		TaskDetailResponse taskResponse = new TaskDetailResponse();
		try {
			taskResponse.setProjectTask(taskService
					.getTaskDetail(taskDetailRequest.getTaskId()));
			taskResponse.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			taskResponse.setReturnMessage("Add task comment failed");
			taskResponse.setReturnVal(OnTargetConstant.ERROR);
		}
		return taskResponse;
	}

	@Override
	@POST
	@Path("/updateTaskStatus")
	public OnTargetResponse updateTaskStatus(
			TaskStatusUpdateRequest taskStatusUpdateRequest) {
		int taskId = taskStatusUpdateRequest.getTaskId();
		String taskStatus = taskStatusUpdateRequest.getTaskStatus();
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (taskService.updateTaskStatus(taskId, taskStatus,
					taskStatusUpdateRequest.getBaseRequest()
							.getLoggedInUserId())) {
				response.setReturnMessage("Successfully updated task status");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				response.setReturnMessage("update task status failed");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			response.setReturnMessage("update task status failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/addTaskMember")
	public OnTargetResponse addTaskMember(TaskMemberRequest taskMemberRequest) {
		OnTargetResponse response = new OnTargetResponse();
		int taskId = taskMemberRequest.getTaskId();
		int projectId = taskMemberRequest.getProjectId();
		if (taskId == 0) {
			response.setReturnMessage("validation error");
			response.setReturnVal(OnTargetConstant.ERROR);
		} else {
			try {
				Set<Integer> members = taskService.getTaskMembers(taskId);

				List<Integer> taskMemberRequestMembers = taskMemberRequest
						.getMembers();
				int count = 0;
				for (Integer member : taskMemberRequestMembers) {
					if (!members.contains(member)) {
						if (taskService
								.addTaskMember(projectId, taskId, member)) {
							count++;
							logger.info("member with id:: " + member
									+ " inserted successfully");
						}
					}
				}
				if (count < taskMemberRequestMembers.size()) {
					response.setReturnMessage("Out of "
							+ taskMemberRequestMembers.size() + " only "
							+ count + " were written");
					response.setReturnVal(OnTargetConstant.SUCCESS);
				} else {
					response.setReturnMessage("Successfully written");
					response.setReturnVal(OnTargetConstant.SUCCESS);
				}
			} catch (Exception e) {
				e.printStackTrace();
				response.setReturnMessage("error while reading task members");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		}

		return response;
	}

	@Override
	@POST
	@Path("/saveTaskFile")
	public InsertResponse saveTaskFile(TaskFileSaveRequest request) {
		int taskId = request.getTaskId();
		int userId = request.getUserId();
		String fileName = request.getFileName();
		String location = request.getLocation();
		InsertResponse response = new InsertResponse();
		try {
			long id = taskService.saveTaskFile(taskId, userId, fileName,
					location);
			if (id > 0) {
				response.setReturnMessage("Successfully written");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				response.setReturnMessage("error while reading task members");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			logger.error("Error while saving task file", e);
			response.setReturnMessage("error saving task file");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@POST
	@Path("/getTaskAttachments")
	public GetTaskAttachmentResponse getTaskAttachments(
			TaskAttachmentRequest taskAttachmentRequest) {
		GetTaskAttachmentResponse response = new GetTaskAttachmentResponse();
		try {
			response.setTaskAttachments(taskService
					.getTaskAttachments(taskAttachmentRequest.getTaskId()));
			response.setTaskId(taskAttachmentRequest.getTaskId());
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnMessage("error getting task file");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@Path("/assignUserToTask")
	@POST
	public OnTargetResponse assignTaskToUser(TaskMemberRequest taskMemberRequest) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			List<Integer> members = taskMemberRequest.getMembers();
			int userId = taskMemberRequest.getBaseRequest().getLoggedInUserId();
			int taskId = taskMemberRequest.getTaskId();
			taskService.assignTaskToUser(taskId, members, userId);
			response.setReturnMessage("Successfully assigned task");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error while assigning task", e);
			response.setReturnMessage("Error while assigning task members");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Path("/addDependentTask")
	@POST
	public InsertResponse addDependentTask(
			DependentTaskRequest dependentTaskRequest) {
		InsertResponse response = new InsertResponse();
		try {
			AddDependentRequest addDependentRequest = ConvertPOJOUtils
					.convertToAddDependentRequest(dependentTaskRequest);
			response.setId(taskService.addDependentTask(addDependentRequest
					.getDependentTask()));
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnMessage("Error while adding dependent task");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@POST
	@Path("/getDependentTasks")
	public ProjectTaskResponse getDependentTasks(
			DependentTaskDetail dependentTaskDetail) {
		ProjectTaskResponse response = new ProjectTaskResponse();
		try {
			response.setTasks(taskService.getDependentTasks(dependentTaskDetail
					.getTaskId()));
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnMessage("Error while getting dependent task");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@POST
	@Path("/getUserTasks")
	public ProjectTaskResponse getUserTask(UserTask userTask) {
		ProjectTaskResponse response = new ProjectTaskResponse();
		try {
			response.setTasks(taskService.getUserTasks(userTask.getUserId()));
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			response.setReturnMessage("Error while getting dependent task");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}
}
