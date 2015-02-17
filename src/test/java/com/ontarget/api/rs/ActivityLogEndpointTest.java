package com.ontarget.api.rs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.ontarget.request.bean.ActivityLogRequestBean;
import com.ontarget.request.bean.BaseRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class ActivityLogEndpointTest extends BaseTest {

	public ActivityLogEndpointTest() throws TestContainerException {
		super("com.ontarget.api.rs");
	}

	@Test
	public void fetchLogs() {
		ActivityLogRequestBean activityLogRequestBean = new ActivityLogRequestBean();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(1);
		baseRequestBean.setLoggedInUserProjectId(1);

		activityLogRequestBean.setBaseRequest(baseRequestBean);
		activityLogRequestBean.setRecentId(1);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(activityLogRequestBean, true));
		ClientResponse response = sendRequest("/activityLog/getLog",
				activityLogRequestBean);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
