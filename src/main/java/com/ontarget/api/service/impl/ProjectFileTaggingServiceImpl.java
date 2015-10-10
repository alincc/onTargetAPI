package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.ProjectFileTaggingDAO;
import com.ontarget.api.service.ProjectFileTaggingService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;
import com.ontarget.request.bean.GetProjectFileTagRequest;

@Service
public class ProjectFileTaggingServiceImpl implements ProjectFileTaggingService {
	private Logger logger = Logger.getLogger(ProjectFileTaggingServiceImpl.class);
	@Autowired
	private ProjectFileTaggingDAO projectFileTaggingDAO;
	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addTag(List<ProjectFileTagBean> tags, int userId) throws Exception {
		return projectFileTaggingDAO.addTag(tags, userId);
	}

	@Override
	public List<ProjectFileTagBean> getProjectFileTags(GetProjectFileTagRequest request) throws Exception {
		List<ProjectFileTag> projectFileTags = projectFileTaggingDAO.getProjectFileTags(request.getProjectFileId());
		logger.debug("project file tags: " + projectFileTags);

		List<ProjectFileTagBean> projectFileTagBeans = new ArrayList<ProjectFileTagBean>();

		if (projectFileTags != null && projectFileTags.size() > 0) {

			for (ProjectFileTag projectFileTag : projectFileTags) {
				ProjectFileTagBean tagBean = new ProjectFileTagBean();
				tagBean.setProjectFileTagId(projectFileTag.getProjectFileTagId());
				tagBean.setTag(projectFileTag.getTag());
				tagBean.setTagType(projectFileTag.getTagType());
				tagBean.setTitle(projectFileTag.getTagTitle());
				tagBean.setLattitude(projectFileTag.getLattitude());
				tagBean.setLongitude(projectFileTag.getLongitude());
				tagBean.setStatus(projectFileTag.getStatus());
				tagBean.setParentFileTagId(projectFileTag.getParentFileTagId());

				Contact contact = contactDAO.getContact(projectFileTag.getCreatedBy().getUserId());
				tagBean.setAddedBy(contact);
				tagBean.setAddedDate(projectFileTag.getCreatedDate());

				logger.debug("tag bean: " + tagBean);

				List<ProjectFileTagAttributeBean> attributes = new ArrayList<ProjectFileTagAttributeBean>();

				List<ProjectFileTagAttribute> projectFileTagAttributes = projectFileTag.getProjectFileTagAttributes();

				if (projectFileTagAttributes != null && !projectFileTagAttributes.isEmpty()) {
					for (ProjectFileTagAttribute projectFileTagAttribute : projectFileTagAttributes) {
						ProjectFileTagAttributeBean projectFileTagAttributeBean = new ProjectFileTagAttributeBean();
						projectFileTagAttributeBean.setProjectFileTagAttributeId(projectFileTagAttribute.getProjectFileTagAttributeId());
						projectFileTagAttributeBean.setKey(projectFileTagAttribute.getAttributeKey());
						projectFileTagAttributeBean.setValue(projectFileTagAttribute.getAttributeValue());
						attributes.add(projectFileTagAttributeBean);
					}
				}

				tagBean.setAttributes(attributes);
				projectFileTagBeans.add(tagBean);
			}
		}
		return projectFileTagBeans;
	}
}
