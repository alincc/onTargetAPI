package com.ontarget.api.rs;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.TaskBudgetEstimationOfProject;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class TaskBudgetEndpointTest extends BaseTest {

	public TaskBudgetEndpointTest() throws TestContainerException {
		super("com.ontarget.api.rs");
	}

	@Test
	public void getTaskBudgetActualsAndEstimated()
			throws JsonGenerationException, JsonMappingException, IOException {

		TaskBudgetEstimationOfProject taskBudgetEstimationOfProject = new TaskBudgetEstimationOfProject();

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		taskBudgetEstimationOfProject.setBaseRequest(baseRequest);
		taskBudgetEstimationOfProject.setProjectId(1);

		System.out
				.println("Client request getTaskBudgetEstimationOfProject.... \n");
		System.out.println(toJsonString(taskBudgetEstimationOfProject, true));
		ClientResponse response = sendRequest(
				"/task/budget/getTaskBudgetEstimationOfProject",
				taskBudgetEstimationOfProject);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
