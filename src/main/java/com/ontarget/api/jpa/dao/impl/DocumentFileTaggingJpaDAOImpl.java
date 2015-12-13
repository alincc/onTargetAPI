package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentFileTaggingDAO;
import com.ontarget.api.repository.ProjectFileTagAttributeRepository;
import com.ontarget.api.repository.ProjectFileTagCommentRepository;
import com.ontarget.api.repository.ProjectFileTagRepository;
import com.ontarget.api.repository.ProjectFileTagTaskLinkRepository;
import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.DocumentFileTagAttributeBean;
import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;
import com.ontarget.entities.ProjectFileTagComment;
import com.ontarget.entities.User;

@Repository
public class DocumentFileTaggingJpaDAOImpl implements DocumentFileTaggingDAO {
	private Logger logger = Logger.getLogger(DocumentFileTaggingJpaDAOImpl.class);

	@Autowired
	private ProjectFileTagRepository projectFileTagRepository;
	@Autowired
	private ProjectFileTagAttributeRepository projectFileTagAttributeRepository;
	@Autowired
	private ProjectFileTagCommentRepository projectFileTagCommentRepository;
	@Autowired
	private ProjectFileTagTaskLinkRepository projectFileTagTaskLinkRepository;

	@Override
	public boolean save(List<DocumentFileTagBean> tags, int userId) throws Exception {
		logger.debug("Saving tag information: " + tags);

		for (DocumentFileTagBean tagBean : tags) {
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
			projectFileTag.setFileId(tagBean.getDocumentId());
			List<ProjectFileTag> recentTag = projectFileTagRepository.findRecentByProjectFileId(tagBean.getDocumentId(), new PageRequest(0,
					1));
			logger.debug("recent tag: " + recentTag);
			if (recentTag != null && recentTag.size() > 0) {
				projectFileTag.setVersionNo(recentTag.get(0).getVersionNo() + 1);
			} else {
				projectFileTag.setVersionNo(1);
			}
			projectFileTagRepository.save(projectFileTag);

			List<DocumentFileTagAttributeBean> attributes = tagBean.getAttributes();
			if (attributes != null && !attributes.isEmpty()) {
				for (DocumentFileTagAttributeBean attributeBean : attributes) {
					ProjectFileTagAttribute projectFileTagAttribute = new ProjectFileTagAttribute();
					String key = attributeBean.getKey();
					projectFileTagAttribute.setAttributeKey(key);
					projectFileTagAttribute.setAttributeValue(attributeBean.getValue());
					projectFileTagAttribute.setCreatedBy(new User(userId));
					projectFileTagAttribute.setCreatedDate(new Date());
					projectFileTagAttribute.setProjectFileTag(projectFileTag);
					projectFileTagAttributeRepository.save(projectFileTagAttribute);
				}
			}

			// save the comment as well. markup will not have comments.
			List<CommentDTO> comments = tagBean.getComment();
			if (comments != null && comments.size() > 0) {
				for (CommentDTO comment : comments) {
					ProjectFileTagComment tagComment = this.saveComment(projectFileTag.getProjectFileTagId(), comment.getComment(), 0L,
							userId);
				}
			}
			// end.
		}
		return true;
	}

	public ProjectFileTagComment saveComment(Long projectFileTagId, String comment, Long commentId, int userId) throws Exception {
		ProjectFileTagComment projectFileTagComment;
		if (commentId != null && commentId > 0) {
			projectFileTagComment = projectFileTagCommentRepository.findById(commentId);
			projectFileTagComment.setModifiedBy(new User(userId));
			projectFileTagComment.setModifiedDate(new Date());
		} else {
			projectFileTagComment = new ProjectFileTagComment();
			projectFileTagComment.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
			projectFileTagComment.setCreatedBy(new User(userId));
			projectFileTagComment.setProjectFileTag(new ProjectFileTag(projectFileTagId));
			projectFileTagComment.setCreatedDate(new Date());
		}
		projectFileTagComment.setComment(comment);
		return projectFileTagCommentRepository.save(projectFileTagComment);
	}

	@Override
	public List<ProjectFileTag> getProjectFileTags(int projectFileId) throws Exception {
		logger.debug("Getting tags for project file id: " + projectFileId);
		return projectFileTagRepository.findRecentByProjectFileId(projectFileId, new PageRequest(0, 100));
	}

}
