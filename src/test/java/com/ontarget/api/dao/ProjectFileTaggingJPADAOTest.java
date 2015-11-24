package com.ontarget.api.dao;

import static junit.framework.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagComment;
import com.ontarget.entities.ProjectFileTagTaskLink;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectFileTaggingJPADAOTest extends BaseTest {

	private Logger logger = Logger.getLogger(ProjectFileTaggingJPADAOTest.class);

	@Autowired
	private ProjectFileTaggingDAO projectFileTaggingDAO;

	@Test
	public void addTag() {
		try {
			List<ProjectFileTagBean> tags = new ArrayList<ProjectFileTagBean>();
			ProjectFileTagBean tagBean = new ProjectFileTagBean();
			tagBean.setTitle("BIM not correct");
			tagBean.setTagType("BIM not correct");
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

			boolean saved = projectFileTaggingDAO.save(tags, 11);

			Assert.assertTrue(saved);
		} catch (Exception e) {
			logger.error("Error while saving tag", e);
			fail();
		}

	}

	@Test
	public void getProjectFileTags() {
		try {

			List<ProjectFileTag> tags = projectFileTaggingDAO.getProjectFileTags(13);

			Assert.assertTrue(tags != null);
		} catch (Exception e) {
			logger.error("Error while getting project file tags.", e);
			fail();
		}

	}

	@Test
	public void saveComment() {
		try {
			ProjectFileTagComment comment = projectFileTaggingDAO.saveComment(1l, "this is comment", 1l, 11);

			Assert.assertTrue(comment.getProjectFileTagCommentId() > 0);
		} catch (Exception e) {
			logger.error("Error while add/update comment.", e);
			fail();
		}

	}

	@Test
	public void deleteComment() {
		try {
			boolean success = projectFileTaggingDAO.deleteComment(1l, 11);

			Assert.assertTrue(success);
		} catch (Exception e) {
			logger.error("Error while deleting comment.", e);
			fail();
		}

	}

	@Test
	public void getComments() {
		try {
			List<ProjectFileTagComment> comments = projectFileTaggingDAO.getComments(1l);

			Assert.assertTrue(comments != null);
		} catch (Exception e) {
			logger.error("Error while retrieving comments.", e);
			fail();
		}

	}

	@Test
	public void saveTagToTaskLink() {
		try {
			boolean success = projectFileTaggingDAO.saveTagToTaskLink(12l, 50, 11, "ACTIVE");

			Assert.assertTrue(success);
		} catch (Exception e) {
			logger.error("Error while linking tag to task.", e);
			fail();
		}
	}

	@Test
	public void getProjectFileTagTaskLink() {
		try {
			ProjectFileTagTaskLink projectFileTagTaskLink = projectFileTaggingDAO.getProjectFileTagTaskLink(12l, 50);

			Assert.assertTrue(projectFileTagTaskLink != null);
		} catch (Exception e) {
			logger.error("Error while getting project file tag task link info.", e);
			fail();
		}

	}

	@Test
	public void updateTagToTaskLink() {
		try {
			boolean success = projectFileTaggingDAO.updateTagToTaskLink(1l, 11, "ACTIVE");

			Assert.assertTrue(success);
		} catch (Exception e) {
			logger.error("Error while updating tag linking/unlinking.", e);
			fail();
		}
	}

}
