package com.ontarget.api.service;

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
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;

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
			tagBean.setTag("BIM not correct");
			tagBean.setTitle("BIM not correct");
			tagBean.setTagType("BIM not correct");
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

			boolean success = projectFileTaggingService.addTag(tags, 11);

			Assert.assertTrue(success);
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

			Assert.assertTrue(tags.size() >= 0);
		} catch (Exception e) {
			logger.error("Error while getting project file tags.", e);
			fail();
		}

	}

}
