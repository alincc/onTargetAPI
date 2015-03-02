package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.request.bean.UploadedFileDetail;

public class UploadDocumentEndpointTest extends BaseTest {

	@Test
	public void saveUploadedDocsInfo() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		UploadDocumentRequest request = new UploadDocumentRequest();
		request.setBaseRequest(baseRequest);

		request.setCreatedBy(1);
		request.setModifiedBy(1);
		request.setName("Details 3.pdf");
		request.setProjectId(42);
		request.setFileType("application/pdf");

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/upload/saveUploadedDocsInfo", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getUploadedFile() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		UploadedFileDetail request = new UploadedFileDetail();
		request.setBaseRequest(baseRequest);

		request.setProjectId(42);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/upload", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
