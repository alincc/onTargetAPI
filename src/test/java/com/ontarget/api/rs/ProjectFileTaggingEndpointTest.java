package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.junit.Test;
import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.request.bean.AddProjectFileTagRequest;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DeleteProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.request.bean.ProjectFileTagCommentRequest;

public class ProjectFileTaggingEndpointTest extends BaseTest {
	private Logger logger = Logger.getLogger(ProjectFileTaggingEndpointTest.class);

	@Test
	public void addTag() {
		AddProjectFileTagRequest request = new AddProjectFileTagRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(44);

		request.setBaseRequest(baseRequestBean);

		List<ProjectFileTagBean> tags = new ArrayList<ProjectFileTagBean>();
		ProjectFileTagBean tagBean = new ProjectFileTagBean();
		tagBean.setTitle("BIM not correct");
		tagBean.setTagType("TAG");
		tagBean.setTagFilePath("/home/santosh/test.pdf");
		tagBean.setLattitude(10.01f);
		tagBean.setLongitude(10.00f);
		tagBean.setProjectFileId(13);

		List<ProjectFileTagAttributeBean> attributes = new ArrayList<ProjectFileTagAttributeBean>();
		ProjectFileTagAttributeBean attribute = new ProjectFileTagAttributeBean();
		attribute.setKey("key1");
		attribute.setValue("value1");
		attributes.add(attribute);

		tagBean.setAttributes(attributes);
		tags.add(tagBean);

		request.setTags(tags);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/project/file/tag/save", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		logger.info("Server response .... \n");
		logger.info(output);
	}

	@Test
	public void getProjectFileTags() {
		GetProjectFileTagRequest request = new GetProjectFileTagRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(44);

		request.setBaseRequest(baseRequestBean);
		request.setProjectFileId(13);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/project/file/tag/get", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		logger.info("Server response .... \n");
		logger.info(output);
	}

	@Test
	public void addUpdateComment() {
		ProjectFileTagCommentRequest request = new ProjectFileTagCommentRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(44);

		request.setBaseRequest(baseRequestBean);
		request.setProjectFileTagId(12l);
		request.setComment("this is test comment1");
		request.setCommentId(1l);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/project/file/tag/comment/add", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		logger.info("Server response .... \n");
		logger.info(output);
	}

	@Test
	public void getComments() {
		GetProjectFileTagCommentRequest request = new GetProjectFileTagCommentRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(44);

		request.setBaseRequest(baseRequestBean);
		request.setProjectFileTagId(12l);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/project/file/tag/comment/list", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		logger.info("Server response .... \n");
		logger.info(output);
	}

	@Test
	public void deleteComment() {
		DeleteProjectFileTagCommentRequest request = new DeleteProjectFileTagCommentRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(44);

		request.setBaseRequest(baseRequestBean);
		request.setCommentId(1l);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/project/file/tag/comment/delete", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		logger.info("Server response .... \n");
		logger.info(output);
	}

}
