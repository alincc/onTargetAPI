package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.ProjectAddressInfo;
import com.ontarget.request.bean.ProjectCompanyRequest;
import com.ontarget.request.bean.ProjectDetailInfo;
import com.ontarget.request.bean.ProjectDetailRequest;
import com.ontarget.request.bean.ProjectRequest;
import com.ontarget.request.bean.ProjectUserRequest;

public class ProjectEndpointTest extends BaseTest {

	@Test
	public void addProject() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectRequest request = new ProjectRequest();
		request.setBaseRequest(baseRequest);
		request.setUserId(1);
		request.setAccountStatus("ACCT_NEW");

		ProjectDetailInfo projectDetailInfo = new ProjectDetailInfo();
		projectDetailInfo.setCompanyId(1);
		projectDetailInfo.setEndDate(new java.sql.Date(new java.util.Date().getTime()));
		projectDetailInfo.setProjectDescription("project desc");
		projectDetailInfo.setProjectName("project name");
		projectDetailInfo.setProjectParentId(0);
		projectDetailInfo.setProjectTypeId(1);
		projectDetailInfo.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
		projectDetailInfo.setStatus("1");
		projectDetailInfo.setUnitOfMeasurement("HOUR");

		ProjectAddressInfo projectAddressInfo = new ProjectAddressInfo();
		projectAddressInfo.setAddress1("address1");
		projectAddressInfo.setAddress2("address2");
		projectAddressInfo.setCity("city");
		projectAddressInfo.setCountry("country");
		projectAddressInfo.setState("state");
		projectAddressInfo.setZip("zip");
		projectDetailInfo.setProjectAddress(projectAddressInfo);

		request.setProject(projectDetailInfo);

		System.out.println("Client request .... addProject\n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/addProject", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void updateProject() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectRequest request = new ProjectRequest();
		request.setBaseRequest(baseRequest);
		request.setUserId(1);
		request.setAccountStatus("ACCT_NEW");

		ProjectDetailInfo projectDetailInfo = new ProjectDetailInfo();
		projectDetailInfo.setProjectId(47);
		projectDetailInfo.setCompanyId(1);
		projectDetailInfo.setEndDate(new java.sql.Date(new java.util.Date().getTime()));
		projectDetailInfo.setProjectDescription("project desc");
		projectDetailInfo.setProjectName("project name2");
		projectDetailInfo.setProjectParentId(0);
		projectDetailInfo.setProjectTypeId(1);
		projectDetailInfo.setStartDate(new java.sql.Date(new java.util.Date().getTime()));
		projectDetailInfo.setStatus("1");
		projectDetailInfo.setUnitOfMeasurement("DOLLAR");

		ProjectAddressInfo projectAddressInfo = new ProjectAddressInfo();
		projectAddressInfo.setAddress1("address1");
		projectAddressInfo.setAddress2("address2");
		projectAddressInfo.setCity("city");
		projectAddressInfo.setCountry("country");
		projectAddressInfo.setState("state");
		projectAddressInfo.setZip("zip");
		projectAddressInfo.setAddressId(39);
		projectDetailInfo.setProjectAddress(projectAddressInfo);

		request.setProject(projectDetailInfo);

		System.out.println("Client request ....updateProject \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/addProject", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void getProjectDetail() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectDetailRequest request = new ProjectDetailRequest();
		request.setBaseRequest(baseRequest);
		request.setProjectId(47);

		System.out.println("Client request ....getProjectDetail \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/getProject", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void getProjectMembers() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectDetailRequest request = new ProjectDetailRequest();
		request.setBaseRequest(baseRequest);
		request.setProjectId(47);

		System.out.println("Client request ....getProjectMembers \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/getProjectMembers", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void getProjectsByCompany() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectCompanyRequest request = new ProjectCompanyRequest();
		request.setBaseRequest(baseRequest);
		request.setCompanyId(1);
		request.setProjectId(47);

		System.out.println("Client request ....getProjectsByCompany \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/getProjectsByCompany", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void getCompanyByProject() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectDetailRequest request = new ProjectDetailRequest();
		request.setBaseRequest(baseRequest);
		request.setProjectId(47);

		System.out.println("Client request ....getCompanyByProject \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/getCompanyByProject", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void getProjectByUser() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectUserRequest request = new ProjectUserRequest();
		request.setUserId(1);

		System.out.println("Client request ....getProjectByUser \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/getProjectsByUser", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void deleteProject() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		ProjectDetailRequest request = new ProjectDetailRequest();
		request.setBaseRequest(baseRequest);
		request.setProjectId(21);

		System.out.println("Client request ....deleteProject \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/project/deleteProject", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
