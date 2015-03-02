package com.ontarget.api.rs;

import java.sql.Date;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.AccidentReportRequest;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.ProjectAddressInfo;
import com.ontarget.request.bean.ProjectDetailInfo;
import com.ontarget.request.bean.ProjectRequest;

public class ProjectEndpointTest extends BaseTest {

	@Test
	public void addProject() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectRequest request = new ProjectRequest();
		request.setBaseRequest(baseRequest);
		request.setUserId(1);

		ProjectDetailInfo projectDetailInfo = new ProjectDetailInfo();
		projectDetailInfo.setCompanyId(1);
		projectDetailInfo.setEndDate(new java.sql.Date(new java.util.Date()
				.getTime()));
		projectDetailInfo.setProjectDescription("project desc");
		projectDetailInfo.setProjectName("project name");
		projectDetailInfo.setProjectParentId(0);
		projectDetailInfo.setProjectTypeId(1);
		projectDetailInfo.setStartDate(new java.sql.Date(new java.util.Date()
				.getTime()));
		projectDetailInfo.setStatus("NEW");

		ProjectAddressInfo projectAddressInfo = new ProjectAddressInfo();
		projectAddressInfo.setAddress1("address1");
		projectAddressInfo.setAddress2("address2");
		projectAddressInfo.setAddressType("addressType");
		projectAddressInfo.setCity("city");
		projectAddressInfo.setCountry("country");
		projectAddressInfo.setState("state");
		projectAddressInfo.setZip("zip");
		projectAddressInfo.setAddressId(1);
		projectDetailInfo.setProjectAddress(projectAddressInfo);

		request.setProject(projectDetailInfo);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/addProject", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
