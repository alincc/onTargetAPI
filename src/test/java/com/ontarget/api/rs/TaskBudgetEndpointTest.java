package com.ontarget.api.rs;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.TaskBudget;
import com.ontarget.request.bean.TaskBudgetEstimate;
import com.ontarget.request.bean.TaskBudgetEstimationOfProject;
import com.ontarget.request.bean.TaskBudgetOfTask;

public class TaskBudgetEndpointTest extends BaseTest {

	@Test
	public void getTaskBudgetActualsAndEstimated() {

		TaskBudgetEstimationOfProject taskBudgetEstimationOfProject = new TaskBudgetEstimationOfProject();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskBudgetEstimationOfProject.setBaseRequest(baseRequest);
		taskBudgetEstimationOfProject.setProjectId(1);

		System.out
				.println("Client request getTaskBudgetEstimationOfProject.... \n");
		System.out.println(toJsonString(taskBudgetEstimationOfProject, true));
		Response response = sendRequest(
				"/task/budget/getTaskBudgetEstimationOfProject",
				taskBudgetEstimationOfProject);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void addTaskBudget() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		TaskBudget taskBudget = new TaskBudget();
		taskBudget.setBaseRequest(baseRequest);

		List<TaskBudgetEstimate> taskBudgetEstimateList = new ArrayList<>();

		TaskBudgetEstimate taskBudgetEstimate = new TaskBudgetEstimate();
		taskBudgetEstimate.setCost(100.0);
		taskBudgetEstimate.setCostType("P");
		taskBudgetEstimate
				.setFromDate(new Date(new java.util.Date().getTime()));
		taskBudgetEstimate.setToDate(new Date(new java.util.Date().getTime()));
		taskBudgetEstimate.setTaskId(1);

		taskBudgetEstimateList.add(taskBudgetEstimate);

		taskBudget.setTaskBudgetEstimates(taskBudgetEstimateList);

		System.out.println("Client request....addTaskBudget \n");
		System.out.println(toJsonString(taskBudget, true));
		Response response = sendRequest("/task/budget/add", taskBudget);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void updateTaskBudget() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		TaskBudget taskBudget = new TaskBudget();
		taskBudget.setBaseRequest(baseRequest);

		List<TaskBudgetEstimate> taskBudgetEstimateList = new ArrayList<>();

		TaskBudgetEstimate taskBudgetEstimate = new TaskBudgetEstimate();
		taskBudgetEstimate.setCost(100.0);
		taskBudgetEstimate.setCostType("P");
		taskBudgetEstimate
				.setFromDate(new Date(new java.util.Date().getTime()));
		taskBudgetEstimate.setToDate(new Date(new java.util.Date().getTime()));
		taskBudgetEstimate.setTaskId(1);
		taskBudgetEstimate.setTaskId(1);
		taskBudgetEstimate.setId(1);

		taskBudgetEstimateList.add(taskBudgetEstimate);

		taskBudget.setTaskBudgetEstimates(taskBudgetEstimateList);

		System.out.println("Client request....updateTaskBudget \n");
		System.out.println(toJsonString(taskBudget, true));
		Response response = sendRequest("/task/budget/add", taskBudget);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getTaskBudgetByTaskId() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		TaskBudgetOfTask request = new TaskBudgetOfTask();
		request.setBaseRequest(baseRequest);
		request.setTaskId(1);

		System.out.println("Client request....getTaskBudgetByTaskId \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/task/budget/getTaskBudgetByTaskId",
				request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
