package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.DocumentFileTaggingDAO;
import com.ontarget.api.dao.ProjectFileTaggingDAO;
import com.ontarget.api.service.DocumentFileTaggingService;
import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.Contact;
import com.ontarget.bean.DocumentFileTagAttributeBean;
import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.DocumentLink;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagAttribute;
import com.ontarget.entities.ProjectFileTagComment;
import com.ontarget.entities.ProjectFileTagTaskLink;
import com.ontarget.enums.TagType;
import com.ontarget.request.bean.GetDocumentFileTagRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.response.bean.DocumentFileTagResponse;
import com.ontarget.util.DocumentFileTagUtil;

@Service
public class DocumentFileTaggingServiceImpl implements DocumentFileTaggingService {
	private Logger logger = Logger.getLogger(DocumentFileTaggingServiceImpl.class);
	@Autowired
	private DocumentFileTaggingDAO documentFileTaggingDAO;
	@Autowired
	private ProjectFileTaggingDAO projectFileTaggingDAO;
	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public DocumentFileTagResponse save(List<DocumentFileTagBean> tags, int userId) throws Exception {
		logger.debug("Saving document file tags: " + tags);

		DocumentFileTagResponse response = new DocumentFileTagResponse();

		for (DocumentFileTagBean tagBean : tags) {
			String tagType = tagBean.getTagType();
			logger.debug("tag type " + tagType);
			if (TagType.getType(tagType) == null) {
				logger.error("tag type " + tagType + " is invalid for tag " + tagBean.getTitle());
				response.setReturnMessage("Tag type is invalid for tag " + tagBean.getTitle());
				response.setReturnVal(OnTargetConstant.ERROR);
				return response;
			}
		}

		boolean success = documentFileTaggingDAO.save(tags, userId);
		logger.debug("success " + success);

		if (success) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully added tagging for a document");
		} else {
			response.setReturnMessage("Sorry!, Could not add document file tagging.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	public List<DocumentFileTagBean> getDocumentFileTags(GetDocumentFileTagRequest request) throws Exception {
		logger.debug("Getting document file tags for file id: " + request.getDocumentFileId());
		List<ProjectFileTag> projectFileTags = documentFileTaggingDAO.getProjectFileTags(request.getDocumentFileId());
		logger.debug("project file tags: " + projectFileTags);

		List<DocumentFileTagBean> projectFileTagBeans = new ArrayList<DocumentFileTagBean>();

		if (projectFileTags != null && projectFileTags.size() > 0) {

			for (ProjectFileTag projectFileTag : projectFileTags) {
				DocumentFileTagBean tagBean = DocumentFileTagUtil.getDocumentFileTagBeanFromEntity(projectFileTag);

				Contact contact = contactDAO.getContact(projectFileTag.getCreatedBy().getUserId());
				tagBean.setAddedBy(contact);

				logger.debug("tag bean: " + tagBean);

				List<DocumentFileTagAttributeBean> attributes = new ArrayList<DocumentFileTagAttributeBean>();

				List<ProjectFileTagAttribute> projectFileTagAttributes = projectFileTag.getProjectFileTagAttributes();

				if (projectFileTagAttributes != null && !projectFileTagAttributes.isEmpty()) {
					for (ProjectFileTagAttribute projectFileTagAttribute : projectFileTagAttributes) {
						attributes.add(DocumentFileTagUtil.getDocumentFileTagAttributeBeanFromEntity(projectFileTagAttribute));
					}
				}
				tagBean.setAttributes(attributes);

				// get the tag comments.
				List<CommentDTO> commentDTOs = this.getComments(projectFileTag.getProjectFileTagId());
				tagBean.setComment(commentDTOs);

				projectFileTagBeans.add(tagBean);
			}
		}
		return projectFileTagBeans;
	}

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
}
