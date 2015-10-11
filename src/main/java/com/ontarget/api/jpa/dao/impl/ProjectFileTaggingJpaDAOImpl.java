package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ProjectFileTaggingDAO;
import com.ontarget.api.repository.ProjectFileTagAttributeRepository;
import com.ontarget.api.repository.ProjectFileTagRepository;
import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;
import com.ontarget.entities.User;

@Repository
public class ProjectFileTaggingJpaDAOImpl implements ProjectFileTaggingDAO {
	private Logger logger = Logger.getLogger(ProjectFileTaggingJpaDAOImpl.class);

	@Autowired
	private ProjectFileTagRepository projectFileTagRepository;
	@Autowired
	private ProjectFileTagAttributeRepository projectFileTagAttributeRepository;

	@Override
	public boolean save(List<ProjectFileTagBean> tags, int userId) throws Exception {
		logger.debug("Saving tag information: " + tags);

		for (ProjectFileTagBean tagBean : tags) {
			ProjectFileTag projectFileTag = new ProjectFileTag();
			projectFileTag.setLongitude(tagBean.getLongitude());
			projectFileTag.setLattitude(tagBean.getLattitude());
			projectFileTag.setTagTitle(tagBean.getTitle());
			projectFileTag.setTagType(tagBean.getTagType());
			if (tagBean.getTagFilePath() == null) {
				projectFileTag.setTagFilePath("");
			} else {
				projectFileTag.setTagFilePath(tagBean.getTagFilePath());
			}
			projectFileTag.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
			projectFileTag.setCreatedBy(new User(userId));
			projectFileTag.setCreatedDate(new Date());
			projectFileTag.setParentFileTagId(tagBean.getParentFileTagId());
			projectFileTag.setProjectFile(new ProjectFile(tagBean.getProjectFileId()));
			List<ProjectFileTag> recentTag = projectFileTagRepository.findRecentByProjectFileId(tagBean.getProjectFileId(),
					new PageRequest(0, 1));
			logger.debug("recent tag: " + recentTag);
			if (recentTag != null && recentTag.size() > 0) {
				projectFileTag.setVersionNo(recentTag.get(0).getVersionNo() + 1);
			} else {
				projectFileTag.setVersionNo(1);
			}
			projectFileTagRepository.save(projectFileTag);

			List<ProjectFileTagAttributeBean> attributes = tagBean.getAttributes();
			if (attributes != null && !attributes.isEmpty()) {
				for (ProjectFileTagAttributeBean attributeBean : attributes) {
					ProjectFileTagAttribute projectFileTagAttribute = new ProjectFileTagAttribute();
					projectFileTagAttribute.setAttributeKey(attributeBean.getKey());
					projectFileTagAttribute.setAttributeValue(attributeBean.getValue());
					projectFileTagAttribute.setCreatedBy(new User(userId));
					projectFileTagAttribute.setCreatedDate(new Date());
					projectFileTagAttribute.setProjectFileTag(projectFileTag);
					projectFileTagAttributeRepository.save(projectFileTagAttribute);
				}
			}
		}
		return true;
	}

	@Override
	public List<ProjectFileTag> getProjectFileTags(int projectFileId) throws Exception {
		logger.debug("Getting tags for project file id: " + projectFileId);
		return projectFileTagRepository.findRecentByProjectFileId(projectFileId, new PageRequest(0, 1));
	}

}
