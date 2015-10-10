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
			tagBean.setTag("BIM not correct");
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

			Assert.assertTrue(tags.size() >= 0);
		} catch (Exception e) {
			logger.error("Error while getting project file tags.", e);
			fail();
		}

	}

}
