package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.AddTaskProgress;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.TaskPercentageOfProject;
import com.ontarget.request.bean.TaskPercentageOfTask;
import com.ontarget.request.bean.TaskProgress;
import com.ontarget.request.bean.TaskProgressInfo;
import com.ontarget.request.bean.UpdateTaskProgress;

public class TaskPercentageEndpointTest extends BaseTest {

	@Test
	public void addTaskPercentageComplete() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		AddTaskProgress request = new AddTaskProgress();
		request.setBaseRequest(baseRequest);

		List<TaskProgress> taskProgressList = new ArrayList<>();
		TaskProgress taskProgress = new TaskProgress();
		taskProgress.setPercentageComplete(10.0);
		taskProgress.setPercentageType("PERCENTAGE");
		taskProgress.setTaskId(50);

		taskProgressList.add(taskProgress);

		request.setTaskProgressList(taskProgressList);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/task/percentage/add", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}
	//
	// @Test
	// public void updateTaskPercentageComplete() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// UpdateTaskProgress request = new UpdateTaskProgress();
	// request.setBaseRequest(baseRequest);
	//
	// List<TaskProgressInfo> taskProgressList = new ArrayList<>();
	// TaskProgressInfo taskProgress = new TaskProgressInfo();
	// taskProgress.setPercentageComplete(10.0);
	// taskProgress.setTaskPercentageLogId(15);
	//
	// taskProgressList.add(taskProgress);
	//
	// request.setTaskProgressList(taskProgressList);
	//
	// System.out.println("Client request.... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/task/percentage/update", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : "
	// + response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void getTaskPercentagesByTask() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// TaskPercentageOfTask request = new TaskPercentageOfTask();
	// request.setBaseRequest(baseRequest);
	// request.setTaskId(1);
	//
	// System.out.println("Client request.... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest(
	// "/task/percentage/getPercentageCompleteOfTask", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : "
	// + response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void getTaskPercentageByProject() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// TaskPercentageOfProject request = new TaskPercentageOfProject();
	// request.setBaseRequest(baseRequest);
	// request.setProjectId(1);
	//
	// System.out.println("Client request.... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest(
	// "/task/percentage/getTaskPercentageByProject", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : "
	// + response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }
}
