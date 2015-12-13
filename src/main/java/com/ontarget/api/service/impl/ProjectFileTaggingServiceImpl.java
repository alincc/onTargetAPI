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
import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.TaskLink;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;
import com.ontarget.entities.ProjectFileTagComment;
import com.ontarget.entities.ProjectFileTagTaskLink;
import com.ontarget.enums.TagType;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.request.bean.UpdateProjectFileTagToTaskLink;
import com.ontarget.response.bean.AddUpdateTagCommentResponse;
import com.ontarget.response.bean.ProjectFileTagResponse;
import com.ontarget.util.ProjectFileTagUtil;

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
	public ProjectFileTagResponse save(List<ProjectFileTagBean> tags, int userId) throws Exception {
		logger.debug("Saving project file tags: " + tags);

		ProjectFileTagResponse response = new ProjectFileTagResponse();

		for (ProjectFileTagBean tagBean : tags) {
			String tagType = tagBean.getTagType();
			logger.debug("tag type " + tagType);
			if (TagType.getType(tagType) == null) {
				logger.error("tag type " + tagType + " is invalid for tag " + tagBean.getTitle());
				response.setReturnMessage("Tag type is invalid for tag " + tagBean.getTitle());
				response.setReturnVal(OnTargetConstant.ERROR);
				return response;
			}
		}
		boolean success = projectFileTaggingDAO.save(tags, userId);
		logger.debug("success " + success);

		if (success) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully added tagging for a document");
		} else {
			response.setReturnMessage("Sorry!, Could not add project file tagging.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	public List<ProjectFileTagBean> getProjectFileTags(GetProjectFileTagRequest request) throws Exception {
		logger.debug("Getting project file tags for file id: " + request.getProjectFileId());
		List<ProjectFileTag> projectFileTags = projectFileTaggingDAO.getProjectFileTags(request.getProjectFileId());
		logger.debug("project file tags: " + projectFileTags);

		List<ProjectFileTagBean> projectFileTagBeans = new ArrayList<ProjectFileTagBean>();

		if (projectFileTags != null && projectFileTags.size() > 0) {

			for (ProjectFileTag projectFileTag : projectFileTags) {
				ProjectFileTagBean tagBean = ProjectFileTagUtil.getProjectFileTagBeanFromEntity(projectFileTag);

				Contact contact = contactDAO.getContact(projectFileTag.getCreatedBy().getUserId());
				tagBean.setAddedBy(contact);

				logger.debug("tag bean: " + tagBean);

				List<ProjectFileTagAttributeBean> attributes = new ArrayList<ProjectFileTagAttributeBean>();

				List<ProjectFileTagAttribute> projectFileTagAttributes = projectFileTag.getProjectFileTagAttributes();

				if (projectFileTagAttributes != null && !projectFileTagAttributes.isEmpty()) {
					for (ProjectFileTagAttribute projectFileTagAttribute : projectFileTagAttributes) {
						attributes.add(ProjectFileTagUtil.getProjectFileTagAttributeBeanFromEntity(projectFileTagAttribute));
					}
				}
				tagBean.setAttributes(attributes);

				// get the tag comments.
				List<CommentDTO> commentDTOs = this.getComments(projectFileTag.getProjectFileTagId());
				tagBean.setComment(commentDTOs);

				List<ProjectFileTagTaskLink> projectFileTagTaskLinkList = projectFileTag.getProjectFileTagTaskLinkList();
				logger.debug("tag task link list:" + projectFileTagTaskLinkList);

				List<TaskLink> taskLinks = new ArrayList<TaskLink>();
				if (projectFileTagTaskLinkList != null && !projectFileTagTaskLinkList.isEmpty()) {
					for (ProjectFileTagTaskLink projectFileTagTaskLink : projectFileTagTaskLinkList) {
						TaskLink taskLink = new TaskLink();
						taskLink.setTaskId(projectFileTagTaskLink.getProjectTask().getProjectTaskId());
						Contact creator = contactDAO.getContact(projectFileTagTaskLink.getCreatedBy().getUserId());
						taskLink.setAdddedBy(creator);
						taskLinks.add(taskLink);
					}
				}
				tagBean.setTaskLinks(taskLinks);

				projectFileTagBeans.add(tagBean);
			}
		}
		return projectFileTagBeans;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public AddUpdateTagCommentResponse addUpdateComment(Long projectFileTagId, String comment, Long commentId, int userId) throws Exception {
		logger.debug("Add/Update project file comment for project file tag id : " + projectFileTagId);

		ProjectFileTagComment projectFileTagComment = projectFileTaggingDAO
				.saveComment(projectFileTagId, comment.trim(), commentId, userId);
		logger.debug("Project File tag comment id:  " + projectFileTagComment.getProjectFileTagCommentId());

		AddUpdateTagCommentResponse response = new AddUpdateTagCommentResponse();
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setCommentId(projectFileTagComment.getProjectFileTagCommentId());
		commentDTO.setComment(projectFileTagComment.getComment());
		commentDTO.setCommentedBy(projectFileTagComment.getCreatedBy().getUserId());
		Contact contact = contactDAO.getContact(projectFileTagComment.getCreatedBy().getUserId());
		commentDTO.setCommenterContact(contact);
		commentDTO.setCommentedDate(projectFileTagComment.getCreatedDate());
		response.setCommentDTO(commentDTO);

		if (commentId != null && commentId > 0) {

			if (projectFileTagComment != null && projectFileTagComment.getProjectFileTagCommentId() > 0) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Successfully updated comment.");
			} else {
				response.setReturnMessage("Sorry!, Could not update comment.");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} else {
			if (projectFileTagComment != null && projectFileTagComment.getProjectFileTagCommentId() > 0) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Successfully added comment.");
			} else {
				response.setReturnMessage("Sorry!, Could not add comment.");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean deleteComment(Long commentId, int userId) throws Exception {
		logger.debug("Delete project file comment for id : " + commentId);
		return projectFileTaggingDAO.deleteComment(commentId, userId);
	}

	@Override
	public List<CommentDTO> getComments(Long projectFileTagId) throws Exception {
		logger.debug("Getting project file tag coments for file tag id: " + projectFileTagId);

		List<ProjectFileTagComment> commentList = projectFileTaggingDAO.getComments(projectFileTagId);

		List<CommentDTO> comments = new ArrayList<CommentDTO>();

		if (commentList != null && !commentList.isEmpty()) {
			for (ProjectFileTagComment projectFileTagComment : commentList) {
				CommentDTO comment = new CommentDTO();
				comment.setCommentId(projectFileTagComment.getProjectFileTagCommentId());
				comment.setComment(projectFileTagComment.getComment());
				comment.setCommentedBy(projectFileTagComment.getCreatedBy().getUserId());
				Contact contact = contactDAO.getContact(projectFileTagComment.getCreatedBy().getUserId());
				comment.setCommenterContact(contact);
				comment.setCommentedDate(projectFileTagComment.getCreatedDate());
				comments.add(comment);
			}
		}
		return comments;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addUpdateTagToTaskLink(UpdateProjectFileTagToTaskLink request, boolean toLink) throws Exception {
		logger.debug("Link to task for project file tag id : " + request.getProjectFileTagId());

		ProjectFileTagTaskLink projectFileTagTaskLink = projectFileTaggingDAO.getProjectFileTagTaskLink(request.getProjectFileTagId(),
				request.getProjectTaskId());

		logger.debug("TagTaskLink object: " + projectFileTagTaskLink);

		boolean success;
		if (projectFileTagTaskLink != null) {
			String status = toLink ? OnTargetConstant.GenericStatus.ACTIVE : OnTargetConstant.GenericStatus.DELETED;
			success = projectFileTaggingDAO.updateTagToTaskLink(projectFileTagTaskLink.getProjectFileTagTaskLinkId(), request
					.getBaseRequest().getLoggedInUserId(), status);
		} else {
			success = projectFileTaggingDAO.saveTagToTaskLink(request.getProjectFileTagId(), request.getProjectTaskId(), request
					.getBaseRequest().getLoggedInUserId(), OnTargetConstant.GenericStatus.ACTIVE);
		}

		logger.debug("success: " + success);

		return success;
	}

}
