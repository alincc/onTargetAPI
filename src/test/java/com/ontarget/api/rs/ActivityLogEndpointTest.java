package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.ActivityLogRequest;
import com.ontarget.request.bean.BaseRequest;

public class ActivityLogEndpointTest extends BaseTest {

	@Test
	public void fetchLogs() {
		ActivityLogRequest request = new ActivityLogRequest();
		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(10);
		baseRequestBean.setLoggedInUserProjectId(24);

		request.setBaseRequest(baseRequestBean);
		request.setPageNumber(1);
		request.setPerPageLimit(10);
		request.setProjectId(2);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/activityLog/getLog", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
