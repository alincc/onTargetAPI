package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.NotificationRequest;

public class NotificationEndpointTest extends BaseTest {

	@Test
	public void getNotifications() {
		NotificationRequest request = new NotificationRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(1);
		baseRequestBean.setLoggedInUserProjectId(1);

		request.setBaseRequest(baseRequestBean);
		request.setPageNumber(1);
		request.setPerPageLimit(10);
		request.setUserId(1);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/notification/getNotifications", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
