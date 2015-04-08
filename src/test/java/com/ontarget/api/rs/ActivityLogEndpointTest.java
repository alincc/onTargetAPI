package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.ActivityLogRequest;
import com.ontarget.request.bean.BaseRequest;

public class ActivityLogEndpointTest extends BaseTest {

	@Test
	public void fetchLogs() {
		ActivityLogRequest activityLogRequestBean = new ActivityLogRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(1);
		baseRequestBean.setLoggedInUserProjectId(1);

		activityLogRequestBean.setBaseRequest(baseRequestBean);
		activityLogRequestBean.setRecentId(1);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(activityLogRequestBean, true));
		Response response = sendRequest("/activityLog/getLog",
				activityLogRequestBean);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}