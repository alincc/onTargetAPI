package com.ontarget.api.rs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DependentTask;
import com.ontarget.request.bean.DependentTaskDetail;
import com.ontarget.request.bean.DependentTaskRequest;
import com.ontarget.request.bean.ParentTask;
import com.ontarget.request.bean.Project;
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
import com.sun.jersey.api.client.ClientResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class TaskEndpointTest extends BaseTest {

	public TaskEndpointTest() {
		super("com.ontarget.api.rs");
	}

	@Test
	public void addTask() throws JsonGenerationException, JsonMappingException,
			IOException {

		TaskRequest taskRequest = new TaskRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskRequest.setBaseRequest(baseRequest);

		Task task = new Task();
		task.setStartDateText("2014-01-01 15:00:00");
		task.setEndDateText("2015-01-01 13:00:00");
		// update
		// task.setProjectTaskId(1);
		task.setPercentageComplete(10);
		// add
		task.setProjectTaskId(0);

		task.setStartDate(new Date());
		task.setEndDate(new Date());
		task.setTitle("task1");
		task.setDescription("task desc");
		task.setStatus("1");
		task.setSeverity("1");

		Project project = new Project();
		project.setProjectId(1);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		task.setProject(project);

		taskRequest.setTask(task);

		ParentTask parentTask = new ParentTask();
		parentTask.setStartDateText("2014-01-01 15:00:00");
		parentTask.setEndDateText("2015-01-01 13:00:00");
		parentTask.setProjectTaskId(1);
		parentTask.setStartDate(new Date());
		parentTask.setEndDate(new Date());
		task.setParentTask(parentTask);

		taskRequest.setTask(task);
		taskRequest.setUserId(1);

		System.out.println("Client request addTask.... \n");
		System.out.println(toJsonString(taskRequest, true));
		ClientResponse response = sendRequest("/task/addTask", taskRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTask() throws JsonGenerationException, JsonMappingException,
			IOException {

		ProjectTaskRequest projectTaskRequest = new ProjectTaskRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		projectTaskRequest.setBaseRequest(baseRequest);
		projectTaskRequest.setProjectId(1);

		System.out.println("Client request getTask.... \n");
		System.out.println(toJsonString(projectTaskRequest, true));
		ClientResponse response = sendRequest("/task/getProjectTask",
				projectTaskRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTaskCountsOfProject() throws JsonGenerationException,
			JsonMappingException, IOException {

		ProjectTaskRequest projectTaskRequest = new ProjectTaskRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		projectTaskRequest.setBaseRequest(baseRequest);
		projectTaskRequest.setProjectId(1);

		System.out.println("Client request getTaskCountsOfProject.... \n");
		System.out.println(toJsonString(projectTaskRequest, true));
		ClientResponse response = sendRequest("/task/getTaskCountsOfProject",
				projectTaskRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTaskDetail() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskDetailRequest taskDetailRequest = new TaskDetailRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskDetailRequest.setBaseRequest(baseRequest);
		taskDetailRequest.setTaskId(17);

		System.out.println("Client request getTaskDetail.... \n");
		System.out.println(toJsonString(taskDetailRequest, true));
		ClientResponse response = sendRequest("/task/getTaskDetail",
				taskDetailRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void updateTaskStatus() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskStatusUpdateRequest taskStatusUpdateRequest = new TaskStatusUpdateRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskStatusUpdateRequest.setBaseRequest(baseRequest);
		taskStatusUpdateRequest.setTaskId(17);
		taskStatusUpdateRequest.setTaskStatus("1");

		System.out.println("Client request updateTaskStatus.... \n");
		System.out.println(toJsonString(taskStatusUpdateRequest, true));
		ClientResponse response = sendRequest("/task/updateTaskStatus",
				taskStatusUpdateRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void addUpdateCommentToTask() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskCommentRequest taskCommentRequest = new TaskCommentRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskCommentRequest.setBaseRequest(baseRequest);
		taskCommentRequest.setTaskId(17);
		taskCommentRequest.setComment("this is test comment");
		taskCommentRequest.setCommentedBy(1);
		taskCommentRequest.setTaskCommentId(0);

		System.out.println("Client request addUpdateCommentToTask.... \n");
		System.out.println(toJsonString(taskCommentRequest, true));
		ClientResponse response = sendRequest("/task/addComment",
				taskCommentRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void addTaskMember() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskMemberRequest taskMemberRequest = new TaskMemberRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskMemberRequest.setBaseRequest(baseRequest);
		taskMemberRequest.setProjectId(1);
		taskMemberRequest.setTaskId(1);

		List<Integer> memberList = new ArrayList<Integer>();
		memberList.add(1);
		memberList.add(5);

		taskMemberRequest.setMembers(memberList);

		System.out.println("Client request addTaskMember.... \n");
		System.out.println(toJsonString(taskMemberRequest, true));
		ClientResponse response = sendRequest("/task/addTaskMember",
				taskMemberRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void saveTaskFile() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskFileSaveRequest taskFileSaveRequest = new TaskFileSaveRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskFileSaveRequest.setBaseRequest(baseRequest);
		taskFileSaveRequest.setFileName("sa.jpg");
		taskFileSaveRequest.setLocation("D:\test");
		taskFileSaveRequest.setTaskId(17);
		taskFileSaveRequest.setUserId(1);

		System.out.println("Client request saveTaskFile.... \n");
		System.out.println(toJsonString(taskFileSaveRequest, true));
		ClientResponse response = sendRequest("/task/saveTaskFile",
				taskFileSaveRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTaskAttachments() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskAttachmentRequest taskAttachmentRequest = new TaskAttachmentRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskAttachmentRequest.setBaseRequest(baseRequest);
		taskAttachmentRequest.setTaskId(17);

		System.out.println("Client request getTaskAttachments.... \n");
		System.out.println(toJsonString(taskAttachmentRequest, true));
		ClientResponse response = sendRequest("/task/getTaskAttachments",
				taskAttachmentRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void assignTaskToUser() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskMemberRequest taskMemberRequest = new TaskMemberRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskMemberRequest.setBaseRequest(baseRequest);
		taskMemberRequest.setTaskId(17);

		ArrayList<Integer> members = new ArrayList<>();
		members.add(1);

		taskMemberRequest.setMembers(members);

		System.out.println("Client request assignTaskToUser .... \n");
		System.out.println(toJsonString(taskMemberRequest, true));
		ClientResponse response = sendRequest("/task/assignUserToTask",
				taskMemberRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void addDependentTask() throws JsonGenerationException,
			JsonMappingException, IOException {

		DependentTaskRequest dependentTaskRequest = new DependentTaskRequest();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		dependentTaskRequest.setBaseRequest(baseRequest);

		DependentTask dependentTask = new DependentTask();
		dependentTask.setCategoryId(1);
		dependentTask.setDependentTaskId(1);
		dependentTask.setTaskId(1);

		dependentTaskRequest.setDependentTask(dependentTask);

		System.out.println("Client request addDependentTask .... \n");
		System.out.println(toJsonString(dependentTaskRequest, true));
		ClientResponse response = sendRequest("/task/addDependentTask",
				dependentTaskRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getDependentTasks() throws JsonGenerationException,
			JsonMappingException, IOException {

		DependentTaskDetail dependentTaskDetail = new DependentTaskDetail();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		dependentTaskDetail.setBaseRequest(baseRequest);
		dependentTaskDetail.setTaskId(1);

		System.out.println("Client request getDependentTasks .... \n");
		System.out.println(toJsonString(dependentTaskDetail, true));
		ClientResponse response = sendRequest("/task/getDependentTasks",
				dependentTaskDetail);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getUserTasks() throws JsonGenerationException,
			JsonMappingException, IOException {

		UserTask userTask = new UserTask();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		userTask.setBaseRequest(baseRequest);
		userTask.setUserId(1);

		System.out.println("Client request getUserTasks .... \n");
		System.out.println(toJsonString(userTask, true));
		ClientResponse response = sendRequest("/task/getUserTasks", userTask);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}
}
