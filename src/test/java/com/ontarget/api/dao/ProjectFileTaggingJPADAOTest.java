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

}
