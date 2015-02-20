package com.ontarget.api.rs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ontarget.request.bean.AddTaskProgress;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.TaskPercentageOfProject;
import com.ontarget.request.bean.TaskPercentageOfTask;
import com.ontarget.request.bean.TaskProgress;
import com.ontarget.request.bean.TaskProgressInfo;
import com.ontarget.request.bean.UpdateTaskProgress;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class TaskPercentageEndpointTest extends BaseTest {

	public TaskPercentageEndpointTest() throws TestContainerException {
		super("com.ontarget.api.rs");
	}

	@Test
	public void addTaskPercentageComplete() throws JsonGenerationException,
			JsonMappingException, IOException {

		AddTaskProgress updateTaskProgress = new AddTaskProgress();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);
		updateTaskProgress.setBaseRequest(baseRequest);

		List<TaskProgress> taskProgressList = new ArrayList<>();

		TaskProgress taskProgress = new TaskProgress();
		taskProgress.setPercentageType("PERCENTAGE");
		taskProgress.setPercentageComplete(10D);
		taskProgress.setTaskId(6);
		taskProgressList.add(taskProgress);

		updateTaskProgress.setTaskProgressList(taskProgressList);

		System.out.println("Client request add.... \n");
		System.out.println(toJsonString(updateTaskProgress, true));
		ClientResponse response = sendRequest("/task/percentage/add",
				updateTaskProgress);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void updateTaskPercentageComplete() throws JsonGenerationException,
			JsonMappingException, IOException {

		UpdateTaskProgress updateTaskProgress = new UpdateTaskProgress();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);
		updateTaskProgress.setBaseRequest(baseRequest);

		List<TaskProgressInfo> taskProgressList = new ArrayList<>();

		TaskProgressInfo taskProgress = new TaskProgressInfo();
		taskProgress.setPercentageComplete(20D);
		taskProgress.setTaskPercentageLogId(10);
		taskProgressList.add(taskProgress);

		updateTaskProgress.setTaskProgressList(taskProgressList);

		System.out.println("Client request update.... \n");
		System.out.println(toJsonString(updateTaskProgress, true));
		ClientResponse response = sendRequest("/task/percentage/update",
				updateTaskProgress);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTaskPercentagesByTask() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskPercentageOfTask taskPercentageOfTask = new TaskPercentageOfTask();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);
		taskPercentageOfTask.setBaseRequest(baseRequest);

		taskPercentageOfTask.setTaskId(1);

		System.out
				.println("Client request update....getPercentageCompleteOfTask \n");
		System.out.println(toJsonString(taskPercentageOfTask, true));
		ClientResponse response = sendRequest(
				"/task/percentage/getPercentageCompleteOfTask",
				taskPercentageOfTask);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTaskPercentageByProject() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskPercentageOfProject taskPercentageOfProject = new TaskPercentageOfProject();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);
		taskPercentageOfProject.setBaseRequest(baseRequest);

		taskPercentageOfProject.setProjectId(1);

		System.out
				.println("Client request update....getTaskPercentageByProject \n");
		System.out.println(toJsonString(taskPercentageOfProject, true));
		ClientResponse response = sendRequest(
				"/task/percentage/getPercentageCompleteOfTask",
				taskPercentageOfProject);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
