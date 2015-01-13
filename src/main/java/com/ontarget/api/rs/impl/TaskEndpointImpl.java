package com.ontarget.api.rs.impl;

import com.ontarget.api.response.TaskListCountResponse;
import com.ontarget.api.rs.TaskEndpoint;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.TaskComment;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.*;
import com.ontarget.exception.DateAfterException;
import com.ontarget.exception.DateBeforeException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

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
    public OnTargetResponse addTask(TaskRequest request) {
        OnTargetResponse response = new OnTargetResponse();
        try {
            if (taskService.addTaskService(request.getTask(), request.getUser().getUserId())) {
                response.setReturnMessage("Successfully added task");
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
            response.setReturnMessage("Add task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/project/{projectId}")
    public TaskListResponse getTask(@PathParam("projectId") int projectId) {
        logger.info("Getting all tasks for project: " + projectId);
        TaskListResponse response = new TaskListResponse();
        try {
            response.setTasks(taskService.getTask(projectId));
            response.setReturnMessage("Successfully retrieved tasks");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Add task failed." + e);
            response.setReturnMessage("Add task failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/getTaskCount/project/{projectId}")
    public TaskListCountResponse getTaskCountByStatus(@PathParam("projectId") int projectId) {
        TaskListCountResponse response = new TaskListCountResponse();
        logger.info("Getting all tasks count for project: " + projectId);
        try {
            response.setTaskCountByStatus(taskService.getTaskCountByStatus(projectId));
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
    public OnTargetResponse addUpdateCommentToTask(TaskComment comment) {
        OnTargetResponse response = new OnTargetResponse();
        try {
            if (taskService.addTaskComment(comment)) {
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
    @GET
    @Path("/{taskId}")
    public TaskResponse getTaskDetail(@PathParam("taskId") int taskId) {
        TaskResponse taskResponse = new TaskResponse();
        try {
            taskResponse.setTask(taskService.getTaskDetail(taskId));
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
    public OnTargetResponse updateTaskStatus(TaskStatusUpdateRequest request) {
        long taskId = request.getTaskId();
        String taskStatus = request.getTaskStatus();
//        System.out.println("these are the requests " + taskId + " and " + taskStatus);
        OnTargetResponse response = new OnTargetResponse();
        try {
            if (taskService.updateTaskStatus(taskId, taskStatus, request.getUser().getUserId())) {
//                System.out.println("succesfully updated");
                response.setReturnMessage("Successfully updated task status");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            } else {
//                System.out.println("failed...");
            }
        } catch (Exception e) {
            // logger.error("update task failed." + e);
//            e.printStackTrace();
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
        long taskId = taskMemberRequest.getTaskId();
        long projectId = taskMemberRequest.getProjectId();
        if (taskId == 0) {
            response.setReturnMessage("validation error");
            response.setReturnVal(OnTargetConstant.ERROR);
        } else {
            try {
                Set<Long> members = taskService.getTaskMembers(taskId);
                List<Long> taskMemberRequestMembers = taskMemberRequest.getMembers();
                int count = 0;
                for (long member : taskMemberRequestMembers) {
                    if (!members.contains(member)) {
                        if (taskService.addTaskMember(projectId, taskId, member))
                            count++;
                    }
                }
                if (count < taskMemberRequestMembers.size()) {
                    response.setReturnMessage("Out of " + taskMemberRequestMembers.size() + " only " + count + " were written");
                    response.setReturnVal(OnTargetConstant.SUCCESS);
                } else {
                    response.setReturnMessage("Successfully written");
                    response.setReturnVal(OnTargetConstant.SUCCESS);
                }
            } catch (Exception e) {
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
        long taskId = request.getTaskId();
        long userId = request.getUserId();
        String fileName = request.getFileName();
        String location = request.getLocation();
        InsertResponse response = new InsertResponse();
        try {
            long id = taskService.saveTaskFile(taskId, userId, fileName, location);
            if (id > 0) {
                response.setReturnMessage("Successfully written");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            } else {
                response.setReturnMessage("error while reading task members");
                response.setReturnVal(OnTargetConstant.ERROR);
            }
        } catch (Exception e) {
//            e.printStackTrace();
            logger.error("Error while saving task file", e);
            response.setReturnMessage("error saving task file");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @GET
    @Path("/getTaskAttachments")
    public GetTaskAttachmentResponse getTaskAttachments(@QueryParam("taskId") long taskId) {
        GetTaskAttachmentResponse response = new GetTaskAttachmentResponse();
        try {
            response.setTaskAttachments(taskService.getTaskAttachments(taskId));
            response.setTaskId(taskId);
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
            if (taskService.assignTaskToUser(taskMemberRequest.getTaskId(), taskMemberRequest.getMembers().get(0).longValue())) {
                response.setReturnMessage("Successfully assigned task");
                response.setReturnVal(OnTargetConstant.SUCCESS);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("Error while assigning task", e);
            response.setReturnMessage("Error while assigning task members");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    // dependent task section
    @Path("/addDependentTask")
    @POST
    public InsertResponse addDependentTask(AddDependentRequest addDependentRequest) {
        InsertResponse response = new InsertResponse();
        try {
            addDependentRequest.getDependentTask().setCreatedBy(addDependentRequest.getUser().getUserId());
            response.setId(taskService.addDependentTask(addDependentRequest.getDependentTask()));
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setReturnMessage("Error while adding dependent task");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @GET
    @Path("/getDependentTasks")
    public TaskListResponse getDependentTasks(@QueryParam("taskId") long taskId) {
        TaskListResponse response = new TaskListResponse();
        try {
            response.setTasks(taskService.getDependentTasks(taskId));
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setReturnMessage("Error while getting dependent task");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }
}
