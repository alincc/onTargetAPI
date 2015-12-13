package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.DocumentFileTagAttributeBean;
import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.request.bean.AddDocumentFileTagRequest;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DeleteProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetDocumentFileTagRequest;
import com.ontarget.request.bean.GetProjectFileTagCommentRequest;
import com.ontarget.request.bean.ProjectFileTagCommentRequest;

public class DocumentFileTaggingEndpointTest extends BaseTest {
	private Logger logger = Logger.getLogger(DocumentFileTaggingEndpointTest.class);

	@Test
	public void addTag() {
		AddDocumentFileTagRequest request = new AddDocumentFileTagRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(45);
		request.setBaseRequest(baseRequestBean);

		List<DocumentFileTagBean> tags = new ArrayList<DocumentFileTagBean>();
		DocumentFileTagBean tagBean = new DocumentFileTagBean();
		tagBean.setTitle("Doc1 sample tag");
		tagBean.setTagType("TAG");
		tagBean.setTagFilePath("/home/ontarget/doc1_tag.pdf");
		tagBean.setLattitude(10.01f);
		tagBean.setLongitude(10.00f);
		tagBean.setDocumentId(1);

		List<DocumentFileTagAttributeBean> attributes = new ArrayList<DocumentFileTagAttributeBean>();
		DocumentFileTagAttributeBean attribute = new DocumentFileTagAttributeBean();
		attribute.setKey("key1");
		attribute.setValue("value1");
		attributes.add(attribute);

		tagBean.setAttributes(attributes);

		List<CommentDTO> commentDTOs = new ArrayList<>();
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setComment("This is test comment");
		commentDTOs.add(commentDTO);
		tagBean.setComment(commentDTOs);

		tags.add(tagBean);

		request.setTags(tags);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/document/file/tag/save", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		logger.info("Server response .... \n");
		logger.info(output);
	}

	@Test
	public void getDocumentFileTags() {
		GetDocumentFileTagRequest request = new GetDocumentFileTagRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(45);

		request.setBaseRequest(baseRequestBean);
		request.setDocumentFileId(1);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/document/file/tag/get", request);
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
		baseRequestBean.setLoggedInUserProjectId(45);

		request.setBaseRequest(baseRequestBean);
		request.setProjectFileTagId(30l);
		request.setComment("this is test comment1");
		// request.setCommentId(1l);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/document/file/tag/comment/add", request);
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
		baseRequestBean.setLoggedInUserProjectId(45);

		request.setBaseRequest(baseRequestBean);
		request.setProjectFileTagId(30l);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/document/file/tag/comment/list", request);
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
		baseRequestBean.setLoggedInUserProjectId(45);

		request.setBaseRequest(baseRequestBean);
		request.setCommentId(1l);

		logger.info("Client request .... \n");
		logger.info(toJsonString(request, true));
		Response response = sendRequest("/document/file/tag/comment/delete", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		logger.info("Server response .... \n");
		logger.info(output);
	}
}
