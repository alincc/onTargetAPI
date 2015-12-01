package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import com.ontarget.bean.CommentDTO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ProjectFileTaggingDAO;
import com.ontarget.api.repository.ProjectFileTagAttributeRepository;
import com.ontarget.api.repository.ProjectFileTagCommentRepository;
import com.ontarget.api.repository.ProjectFileTagRepository;
import com.ontarget.api.repository.ProjectFileTagTaskLinkRepository;
import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;
import com.ontarget.entities.ProjectFileTagComment;
import com.ontarget.entities.ProjectFileTagTaskLink;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.User;

@Repository
public class ProjectFileTaggingJpaDAOImpl implements ProjectFileTaggingDAO {
	private Logger logger = Logger.getLogger(ProjectFileTaggingJpaDAOImpl.class);

	@Autowired
	private ProjectFileTagRepository projectFileTagRepository;
	@Autowired
	private ProjectFileTagAttributeRepository projectFileTagAttributeRepository;
	@Autowired
	private ProjectFileTagCommentRepository projectFileTagCommentRepository;
	@Autowired
	private ProjectFileTagTaskLinkRepository projectFileTagTaskLinkRepository;

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
                    String key=attributeBean.getKey();
                    projectFileTagAttribute.setAttributeKey(key);
					projectFileTagAttribute.setAttributeValue(attributeBean.getValue());
					projectFileTagAttribute.setCreatedBy(new User(userId));
					projectFileTagAttribute.setCreatedDate(new Date());
					projectFileTagAttribute.setProjectFileTag(projectFileTag);
					projectFileTagAttributeRepository.save(projectFileTagAttribute);

                    // link the linkTaskId to task in table. t his is for new versions
                    if(key.equals("linkTaskId")){
                        String taskId=attributeBean.getValue();
                        if(Integer.parseInt(taskId)!=0) {
                            boolean created = this.saveTagToTaskLink(projectFileTag.getProjectFileTagId(), Integer.parseInt(taskId), userId, "ACTIVE");
                            if(!created){
                                logger.error("Error while saving task and link");
                            }
                        }
                    }


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

	@Override
	public List<ProjectFileTag> getProjectFileTags(int projectFileId) throws Exception {
		logger.debug("Getting tags for project file id: " + projectFileId);
		return projectFileTagRepository.findRecentByProjectFileId(projectFileId, new PageRequest(0, 100));
	}

	@Override
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
	public boolean deleteComment(Long commentId, int userId) throws Exception {
		ProjectFileTagComment projectFileTagComment = projectFileTagCommentRepository.findById(commentId);
		projectFileTagComment.setModifiedBy(new User(userId));
		projectFileTagComment.setModifiedDate(new Date());
		projectFileTagComment.setStatus(OnTargetConstant.GenericStatus.DELETED);
		projectFileTagCommentRepository.save(projectFileTagComment);
		return true;
	}

	@Override
	public List<ProjectFileTagComment> getComments(Long projectFileTagId) throws Exception {
		return projectFileTagCommentRepository.findCommentsByFileTag(projectFileTagId);
	}

	@Override
	public boolean saveTagToTaskLink(Long projectFileTagId, int taskId, int userId, String status) throws Exception {
		ProjectFileTagTaskLink projectFileTagTaskLink = new ProjectFileTagTaskLink();
		projectFileTagTaskLink.setProjectFileTag(new ProjectFileTag(projectFileTagId));
		projectFileTagTaskLink.setProjectTask(new ProjectTask(taskId));
		projectFileTagTaskLink.setCreatedBy(new User(userId));
		projectFileTagTaskLink.setCreatedDate(new Date());
		projectFileTagTaskLink.setStatus(status);
		projectFileTagTaskLinkRepository.save(projectFileTagTaskLink);
		return true;
	}

	@Override
	public ProjectFileTagTaskLink getProjectFileTagTaskLink(Long projectFileTagId, int taskId) {
		return projectFileTagTaskLinkRepository.findByTagIdAndTaskId(projectFileTagId, taskId);
	}

	@Override
	public boolean updateTagToTaskLink(Long projectFileTagTaskLinkId, int userId, String status) throws Exception {
		ProjectFileTagTaskLink projectFileTagTaskLink = projectFileTagTaskLinkRepository.findOne(projectFileTagTaskLinkId);
		projectFileTagTaskLink.setModifiedBy(new User(userId));
		projectFileTagTaskLink.setModifiedDate(new Date());
		projectFileTagTaskLink.setStatus(status);
		projectFileTagTaskLinkRepository.save(projectFileTagTaskLink);
		return true;
	}
}
