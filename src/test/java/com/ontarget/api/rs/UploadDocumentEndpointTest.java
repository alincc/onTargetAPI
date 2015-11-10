package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.ProjectFileCategoryRequest;
import com.ontarget.request.bean.ProjectFileCommentDeleteRequest;
import com.ontarget.request.bean.ProjectFileCommentListRequest;
import com.ontarget.request.bean.ProjectFileCommentRequest;
import com.ontarget.request.bean.ProjectFileDeleteRequest;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.request.bean.UploadedFileDetail;

import static junit.framework.Assert.fail;

public class UploadDocumentEndpointTest extends BaseTest {

	@Test
	public void saveUploadedDocsInfo() {

	BaseRequest baseRequest = new BaseRequest();
	baseRequest.setLoggedInUserId(11);
	baseRequest.setLoggedInUserProjectId(45);

	UploadDocumentRequest request = new UploadDocumentRequest();
	request.setBaseRequest(baseRequest);


	request.setCreatedBy(11);
	request.setModifiedBy(11);
	request.setName("assets/projects/TBAeXqI4822DWZ4fQFcI/onsite/testpdf-1-updated.pdf");
	request.setProjectId(45);
	request.setFileType("application/pdf");
	request.setCategoryId(1);
	request.setDescription("Project image update");
    request.setProjectFileId(0);
    request.setParentProjectFileId(104);
    request.setThumbnailImageName("/assets/projects/TBAeXqI4822DWZ4fQFcI/abcdef.thumb.jpg");
    request.setIsConversionComplete(false);

	System.out.println("Client request.... \n");
	System.out.println(toJsonString(request, true));
    Response response=null;

            response = sendRequest("/upload/saveUploadedDocsInfo", request);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " +
                        response.getStatus());

            }

	String output = response.readEntity(String.class);
	System.out.println("Server response .... \n");
	System.out.println(output);

	}

	// @Test
	// public void getUploadedFile() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// UploadedFileDetail request = new UploadedFileDetail();
	// request.setBaseRequest(baseRequest);
	//
	// request.setProjectId(2);
	//
	// System.out.println("Client request.... \n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/upload", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response .... \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void deleteProjectFile() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// ProjectFileDeleteRequest request = new ProjectFileDeleteRequest();
	// request.setBaseRequest(baseRequest);
	// request.setProjectFileId(9);
	//
	// System.out.println("Client request.... delete\n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/upload/delete", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response ....delete \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void getProjectFileCategoryList() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// ProjectFileCategoryRequest request = new ProjectFileCategoryRequest();
	// request.setBaseRequest(baseRequest);
	//
	// System.out.println("Client request.... projectFileCategoryList\n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/upload/projectFileCategoryList",
	// request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response ....projectFileCategoryList \n");
	// System.out.println(output);
	//
	// }

	@Test
	public void addComment() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(10);
		baseRequest.setLoggedInUserProjectId(42);

		ProjectFileCommentRequest request = new ProjectFileCommentRequest();
		request.setBaseRequest(baseRequest);
		request.setProjectFileId(14);
		request.setComment("This is comment2");
		request.setCommentId(null);

		System.out.println("Client request.... addComment\n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/upload/addComment", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....addComment \n");
		System.out.println(output);

	}

	// @Test
	// public void deleteComment() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// ProjectFileCommentDeleteRequest request = new
	// ProjectFileCommentDeleteRequest();
	// request.setBaseRequest(baseRequest);
	// request.setCommentId(1);
	//
	// System.out.println("Client request.... deleteComment\n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/upload/deleteComment", request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response ....deleteComment \n");
	// System.out.println(output);
	//
	// }

	// @Test
	// public void projectFileCommentList() {
	//
	// BaseRequest baseRequest = new BaseRequest();
	// baseRequest.setLoggedInUserId(1);
	// baseRequest.setLoggedInUserProjectId(1);
	//
	// ProjectFileCommentListRequest request = new
	// ProjectFileCommentListRequest();
	// request.setBaseRequest(baseRequest);
	// request.setProjectFileId(1);
	//
	// System.out.println("Client request.... projectFileCommentList\n");
	// System.out.println(toJsonString(request, true));
	// Response response = sendRequest("/upload/projectFileCommentList",
	// request);
	// if (response.getStatus() != 200) {
	// throw new RuntimeException("Failed : HTTP error code : " +
	// response.getStatus());
	// }
	// String output = response.readEntity(String.class);
	// System.out.println("Server response ....projectFileCommentList \n");
	// System.out.println(output);
	//
	// }

}
