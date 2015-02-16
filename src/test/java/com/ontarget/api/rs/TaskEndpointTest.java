package com.ontarget.api.rs;

import java.io.IOException;
import java.util.Date;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.Task;
import com.ontarget.bean.User;
import com.ontarget.dto.TaskRequest;
import com.sun.jersey.api.client.ClientResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class TaskEndpointTest extends BaseTest {

	public TaskEndpointTest() {
		super("com.ontarget.api.rs");
	}

	@Test
	public void testAddTask() throws JsonGenerationException,
			JsonMappingException, IOException {

		TaskRequest taskRequest = new TaskRequest();
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

		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectId(1);
		projectDTO.setStartDate(new Date());
		projectDTO.setEndDate(new Date());

		task.setProject(projectDTO);

		Task parentTask = new Task();
		parentTask.setStartDateText("2014-01-01 15:00:00");
		parentTask.setEndDateText("2015-01-01 13:00:00");
		parentTask.setProjectTaskId(1);
		parentTask.setStartDate(new Date());
		parentTask.setEndDate(new Date());

		task.setParentTask(parentTask);

		taskRequest.setTask(task);

		User user = new User();
		user.setUserId(1);
		taskRequest.setUser(user);

		System.out.println("Client request .... \n");
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

}
