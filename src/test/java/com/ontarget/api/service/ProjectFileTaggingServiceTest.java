package com.ontarget.api.service;

import static junit.framework.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.request.bean.UpdateProjectFileTagToTaskLink;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectFileTaggingServiceTest extends BaseTest {

	private Logger logger = Logger.getLogger(ProjectFileTaggingServiceTest.class);

	@Autowired
	private ProjectFileTaggingService projectFileTaggingService;

	@Test
	public void addTag() {
		try {
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

			OnTargetResponse onTargetResponse = projectFileTaggingService.save(tags, 11);

			Assert.assertTrue(onTargetResponse != null);
		} catch (Exception e) {
			logger.error("Error while adding tag.", e);
			fail();
		}

	}

	@Test
	public void getProjectFileTags() {
		try {
			GetProjectFileTagRequest request = new GetProjectFileTagRequest();

			BaseRequest baseRequestBean = new BaseRequest();
			baseRequestBean.setLoggedInUserId(11);
			baseRequestBean.setLoggedInUserProjectId(44);

			request.setBaseRequest(baseRequestBean);
			request.setProjectFileId(13);

			List<ProjectFileTagBean> tags = projectFileTaggingService.getProjectFileTags(request);

			Assert.assertTrue(tags != null);
		} catch (Exception e) {
			logger.error("Error while getting project file tags.", e);
			fail();
		}

	}

	@Test
	public void addUpdateComment() {
		try {
			OnTargetResponse respone = projectFileTaggingService.addUpdateComment(1l, "this is test comment", 1l, 11);

			Assert.assertTrue(respone != null);
		} catch (Exception e) {
			logger.error("Error while add/update comment.", e);
			fail();
		}

	}

	@Test
	public void deleteComment() {
		try {
			boolean success = projectFileTaggingService.deleteComment(1l, 11);

			Assert.assertTrue(success);
		} catch (Exception e) {
			logger.error("Error while deleting comment.", e);
			fail();
		}

	}

	@Test
	public void getComments() {
		try {
			List<CommentDTO> comments = projectFileTaggingService.getComments(1l);

			Assert.assertTrue(comments != null);
		} catch (Exception e) {
			logger.error("Error while retrieving comments.", e);
			fail();
		}

	}

	@Test
	public void addUpdateTagToTaskLink() {
		try {
			UpdateProjectFileTagToTaskLink request = new UpdateProjectFileTagToTaskLink();

			BaseRequest baseRequestBean = new BaseRequest();
			baseRequestBean.setLoggedInUserId(11);
			baseRequestBean.setLoggedInUserProjectId(44);

			request.setBaseRequest(baseRequestBean);
			request.setProjectFileTagId(12l);
			request.setProjectTaskId(50);

			boolean success = projectFileTaggingService.addUpdateTagToTaskLink(request, true);

			Assert.assertTrue(success);
		} catch (Exception e) {
			logger.error("Error while deleting comment.", e);
			fail();
		}

	}

}
