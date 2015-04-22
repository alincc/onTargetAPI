package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.CompanyInfoRequest;
import com.ontarget.request.bean.CompanyList;

public class CompanyEndpointTest extends BaseTest {

	@Test
	public void getCompanyList() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		CompanyList companyList = new CompanyList();
		companyList.setBaseRequest(baseRequest);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(companyList, true));
		Response response = sendRequest("/company/getCompanyList", companyList);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getCompanyInfo() {

		CompanyInfoRequest request = new CompanyInfoRequest();
		request.setCompanyId(1);

		System.out.println("Client request ....getCompanyInfo \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/company/getCompanyInfo", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
