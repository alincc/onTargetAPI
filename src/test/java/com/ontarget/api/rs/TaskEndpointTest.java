package com.ontarget.api.rs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DependentTask;
import com.ontarget.request.bean.DependentTaskDetail;
import com.ontarget.request.bean.DependentTaskRequest;
import com.ontarget.request.bean.ProjectTaskFileDeleteRequest;
import com.ontarget.request.bean.ProjectTaskRequest;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskAttachmentRequest;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.request.bean.TaskDetailRequest;
import com.ontarget.request.bean.TaskFieldWorkerRequest;
import com.ontarget.request.bean.TaskFileSaveRequest;
import com.ontarget.request.bean.TaskMemberRequest;
import com.ontarget.request.bean.TaskRequest;
import com.ontarget.request.bean.TaskStatusUpdateRequest;
import com.ontarget.request.bean.UserTask;

public class TaskEndpointTest extends BaseTest {

	// @Test
	// public void addTask() {
	//
	// TaskRequest taskRequest = new TaskRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskRequest.setBaseRequest(baseRequest);
	//
	// Task task = new Task();
	//
	// task.setStartDate(new Date(new java.util.Date().getTime()));
	// task.setEndDate(new Date(new java.util.Date().getTime()));
	// task.setTitle("task1");
	// task.setDescription("task desc");
	// task.setStatus("1");
	// task.setSeverity("1");
	//
	// task.setProjectId(1);
	//
	// taskRequest.setTask(task);
	//
	// taskRequest.setTask(task);
	//
	// taskRequest.setUserId(1);
	//
	// System.out.println("Client request addTask.... \n");
	// System.out.println(toJsonString(taskRequest, true));
	// Response response = sendRequest("/task/addTask", taskRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void updateTask() {
	//
	// TaskRequest taskRequest = new TaskRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskRequest.setBaseRequest(baseRequest);
	//
	// Task task = new Task();
	// task.setProjectTaskId(0);
	//
	// task.setStartDate(new Date(new java.util.Date().getTime()));
	// task.setEndDate(new Date(new java.util.Date().getTime()));
	// task.setTitle("task1");
	// task.setDescription("task desc");
	// task.setStatus("1");
	// task.setSeverity("1");
	// task.setProjectTaskId(1);
	//
	// task.setProjectId(1);
	//
	// taskRequest.setTask(task);
	//
	// taskRequest.setTask(task);
	// taskRequest.setUserId(1);
	//
	// System.out.println("Client request updateTask.... \n");
	// System.out.println(toJsonString(taskRequest, true));
	// Response response = sendRequest("/task/addTask", taskRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void getProjectTask() {
	//
	// ProjectTaskRequest projectTaskRequest = new ProjectTaskRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// projectTaskRequest.setBaseRequest(baseRequest);
	// projectTaskRequest.setProjectId(4);
	//
	// System.out.println("Client request getProjectTask.... \n");
	// System.out.println(toJsonString(projectTaskRequest, true));
	// Response response = sendRequest("/task/getProjectTask",
	// projectTaskRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void getTaskCountsOfProject() {
	//
	// ProjectTaskRequest projectTaskRequest = new ProjectTaskRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// projectTaskRequest.setBaseRequest(baseRequest);
	// projectTaskRequest.setProjectId(1);
	//
	// System.out.println("Client request getTaskCountsOfProject.... \n");
	// System.out.println(toJsonString(projectTaskRequest, true));
	// Response response = sendRequest("/task/getTaskCountsOfProject",
	// projectTaskRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void getTaskDetail() {
	//
	// TaskDetailRequest taskDetailRequest = new TaskDetailRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskDetailRequest.setBaseRequest(baseRequest);
	// taskDetailRequest.setTaskId(1);
	//
	// System.out.println("Client request getTaskDetail.... \n");
	// System.out.println(toJsonString(taskDetailRequest, true));
	// Response response = sendRequest("/task/getTaskDetail",
	// taskDetailRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void updateTaskStatus() {
	//
	// TaskStatusUpdateRequest taskStatusUpdateRequest = new
	// TaskStatusUpdateRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskStatusUpdateRequest.setBaseRequest(baseRequest);
	// taskStatusUpdateRequest.setTaskId(17);
	// taskStatusUpdateRequest.setTaskStatus("1");
	//
	// System.out.println("Client request updateTaskStatus.... \n");
	// System.out.println(toJsonString(taskStatusUpdateRequest, true));
	// Response response = sendRequest("/task/updateTaskStatus",
	// taskStatusUpdateRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void addUpdateCommentToTask() {
	//
	// TaskCommentRequest taskCommentRequest = new TaskCommentRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskCommentRequest.setBaseRequest(baseRequest);
	// taskCommentRequest.setTaskId(17);
	// taskCommentRequest.setComment("this is test comment");
	// taskCommentRequest.setCommentedBy(1);
	// taskCommentRequest.setTaskCommentId(0);
	//
	// System.out.println("Client request addUpdateCommentToTask.... \n");
	// System.out.println(toJsonString(taskCommentRequest, true));
	// Response response = sendRequest("/task/addComment", taskCommentRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void addTaskMember() {
	//
	// TaskMemberRequest taskMemberRequest = new TaskMemberRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskMemberRequest.setBaseRequest(baseRequest);
	// taskMemberRequest.setProjectId(1);
	// taskMemberRequest.setTaskId(1);
	//
	// List<Integer> memberList = new ArrayList<Integer>();
	// memberList.add(1);
	// memberList.add(5);
	//
	// taskMemberRequest.setMembers(memberList);
	//
	// System.out.println("Client request addTaskMember.... \n");
	// System.out.println(toJsonString(taskMemberRequest, true));
	// Response response = sendRequest("/task/addTaskMember",
	// taskMemberRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void saveTaskFile() {
	//
	// TaskFileSaveRequest taskFileSaveRequest = new TaskFileSaveRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskFileSaveRequest.setBaseRequest(baseRequest);
	// taskFileSaveRequest.setFileName("sa.jpg");
	// taskFileSaveRequest.setLocation("D:\test");
	// taskFileSaveRequest.setTaskId(17);
	// taskFileSaveRequest.setUserId(1);
	//
	// System.out.println("Client request saveTaskFile.... \n");
	// System.out.println(toJsonString(taskFileSaveRequest, true));
	// Response response = sendRequest("/task/saveTaskFile",
	// taskFileSaveRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	@Test
	public void getTaskAttachments() {

		TaskAttachmentRequest taskAttachmentRequest = new TaskAttachmentRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskAttachmentRequest.setBaseRequest(baseRequest);
		taskAttachmentRequest.setTaskId(1);

		System.out.println("Client request getTaskAttachments.... \n");
		System.out.println(toJsonString(taskAttachmentRequest, true));
		Response response = sendRequest("/task/getTaskAttachments", taskAttachmentRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

//	@Test
//	public void deleteTaskAttachment() {
//
//		ProjectTaskFileDeleteRequest request = new ProjectTaskFileDeleteRequest();
//
//		BaseRequest baseRequest = new BaseRequest();
//		baseRequest.setLoggedInUserId(1);
//		baseRequest.setLoggedInUserProjectId(1);
//
//		request.setBaseRequest(baseRequest);
//		request.setTaskFileId(12);
//
//		System.out.println("Client request deleteTaskAttachment.... \n");
//		System.out.println(toJsonString(request, true));
//		Response response = sendRequest("/task/deleteTaskAttachment", request);
//		if (response.getStatus() != 200) {
//			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//		}
//		String output = response.readEntity(String.class);
//		System.out.println("Server response .... \n");
//		System.out.println(output);
//
//	}
	//
	// @Test
	// public void assignTaskToUser() {
	//
	// TaskMemberRequest taskMemberRequest = new TaskMemberRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskMemberRequest.setBaseRequest(baseRequest);
	// taskMemberRequest.setTaskId(1);
	// taskMemberRequest.setProjectId(1);
	//
	// ArrayList<Integer> members = new ArrayList<>();
	// //members.add(1);
	//
	// taskMemberRequest.setMembers(members);
	//
	// System.out.println("Client request assignTaskToUser .... \n");
	// System.out.println(toJsonString(taskMemberRequest, true));
	// Response response = sendRequest("/task/assignUserToTask",
	// taskMemberRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void assignFieldworkerToTask() {
	//
	// TaskMemberRequest taskMemberRequest = new TaskMemberRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// taskMemberRequest.setBaseRequest(baseRequest);
	// taskMemberRequest.setTaskId(1);
	// taskMemberRequest.setProjectId(4);
	//
	// ArrayList<Integer> members = new ArrayList<>();
	// members.add(1);
	//
	// taskMemberRequest.setMembers(members);
	//
	// System.out.println("Client request assignFieldworkerToTask .... \n");
	// System.out.println(toJsonString(taskMemberRequest, true));
	// Response response = sendRequest("/task/assignFieldworkerToTask",
	// taskMemberRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void getTaskFieldWorkers() {
	//
	// TaskFieldWorkerRequest request = new TaskFieldWorkerRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// request.setBaseRequest(baseRequest);
	// request.setTaskId(1);
	//
	// System.out.println("Client request getTaskFieldWorkers .... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/task/getTaskFieldWorkers", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void addDependentTask() {
	//
	// DependentTaskRequest dependentTaskRequest = new DependentTaskRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// dependentTaskRequest.setBaseRequest(baseRequest);
	//
	// DependentTask dependentTask = new DependentTask();
	// dependentTask.setCategoryId(1);
	// dependentTask.setDependentTaskId(1);
	// dependentTask.setTaskId(1);
	//
	// dependentTaskRequest.setDependentTask(dependentTask);
	//
	// System.out.println("Client request addDependentTask .... \n");
	// System.out.println(toJsonString(dependentTaskRequest, true));
	// Response response = sendRequest("/task/addDependentTask",
	// dependentTaskRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void getDependentTasks() {
	//
	// DependentTaskDetail dependentTaskDetail = new DependentTaskDetail();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// dependentTaskDetail.setBaseRequest(baseRequest);
	// dependentTaskDetail.setTaskId(1);
	//
	// System.out.println("Client request getDependentTasks .... \n");
	// System.out.println(toJsonString(dependentTaskDetail, true));
	// Response response = sendRequest("/task/getDependentTasks",
	// dependentTaskDetail);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
	//
	// @Test
	// public void getUserTasks() {
	//
	// UserTask userTask = new UserTask();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// userTask.setBaseRequest(baseRequest);
	// userTask.setUserId(1);
	//
	// System.out.println("Client request getUserTasks .... \n");
	// System.out.println(toJsonString(userTask, true));
	// Response response = sendRequest("/task/getUserTasks", userTask);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	// }
	//
	// @Test
	// public void deleteTask() {
	//
	// TaskDetailRequest request = new TaskDetailRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// request.setBaseRequest(baseRequest);
	// request.setTaskId(17);
	//
	// System.out.println("Client request deleteTask.... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/task/deleteTask", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void getProjectTaskList() {
	//
	// ProjectTaskRequest projectTaskRequest = new ProjectTaskRequest();
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// projectTaskRequest.setBaseRequest(baseRequest);
	// projectTaskRequest.setProjectId(4);
	//
	// System.out.println("Client request getProjectTaskList.... \n");
	// System.out.println(toJsonString(projectTaskRequest, true));
	// Response response = sendRequest("/task/getProjectTaskList",
	// projectTaskRequest);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

}
