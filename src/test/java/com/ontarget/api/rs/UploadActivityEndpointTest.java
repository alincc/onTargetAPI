package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.ActivityTaskRecord;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.UploadActivityRequest;

public class UploadActivityEndpointTest extends BaseTest {

	@Test
	public void createActivity() {
		UploadActivityRequest request = new UploadActivityRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(1);
		baseRequestBean.setLoggedInUserProjectId(1);

		request.setBaseRequest(baseRequestBean);
		request.setProjectId(2);
		request.setFilename("Onfile.xls");

		List<ActivityTaskRecord> activityTaskRecords = new ArrayList<>();

		// for (int i = 1; i < 5; i++) {
		// ActivityTaskRecord activityTaskRecord = new ActivityTaskRecord();
		// activityTaskRecord.setIndex(i);
		// activityTaskRecord.setActivityCode("ACT-00" + i);
		// activityTaskRecord.setActivityName("activity" + i);
		// activityTaskRecord.setTaskCode("TASK-00" + i);
		// activityTaskRecord.setTaskName("task" + i);
		// activityTaskRecord.setStartDate("17/04/2015");
		// activityTaskRecord.setEndDate("17/06/2015");
		// activityTaskRecords.add(activityTaskRecord);
		// }

		for (int i = 1; i <= 1; i++) {
			ActivityTaskRecord activityTaskRecord = new ActivityTaskRecord();
			activityTaskRecord.setIndex(String.valueOf(i));
			int index = i;
			if (i < 3) {
				index = 1;
			}
			activityTaskRecord.setActivityCode("ACT-00" + index);
			activityTaskRecord.setActivityName("activity" + index);
			activityTaskRecord.setActivityStartDate("17/06/2015");
			activityTaskRecord.setActivityEndDate("22/06/2015");

			activityTaskRecord.setTaskCode("TASK-00" + i);
			activityTaskRecord.setTaskName("task" + i);
			activityTaskRecord.setTaskDescription("");
			activityTaskRecord.setTaskStartDate("17/06/2015");
			activityTaskRecord.setTaskEndDate("22/06/2015");
			activityTaskRecord.setActualCost("500");
			activityTaskRecord.setEstimatedCost("200");
			activityTaskRecord.setPercentageComplete("20");
			activityTaskRecord.setPriority("HIGH");
			activityTaskRecords.add(activityTaskRecord);
		}

		request.setActivityTaskRecords(activityTaskRecords);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/uploadActivity", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}
}
