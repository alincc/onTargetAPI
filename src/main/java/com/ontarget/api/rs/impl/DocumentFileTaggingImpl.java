package com.ontarget.api.rs.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.DocumentFileTagging;
import com.ontarget.api.service.DocumentFileTaggingService;
import com.ontarget.api.service.ProjectFileTaggingService;
import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddDocumentFileTagRequest;
import com.ontarget.request.bean.DeleteProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetDocumentFileTagRequest;
import com.ontarget.request.bean.GetProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.request.bean.ProjectFileTagCommentRequest;
import com.ontarget.response.bean.AddUpdateTagCommentResponse;
import com.ontarget.response.bean.DocumentFileTagResponse;
import com.ontarget.response.bean.ProjectFileTagCommentResponse;

@Component
@Path("/document/file/tag")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentFileTaggingImpl implements DocumentFileTagging {
	private Logger logger = Logger.getLogger(DocumentFileTaggingImpl.class);
	@Autowired
	private DocumentFileTaggingService documentFileTaggingService;
	@Autowired
	private ProjectFileTaggingService projectFileTaggingService;

	@Override
	@POST
	@Path("/save")
	public DocumentFileTagResponse save(AddDocumentFileTagRequest request) {
		logger.debug("Saving project file tags: " + request.getTags());
		DocumentFileTagResponse response = new DocumentFileTagResponse();
		try {
			return documentFileTaggingService.save(request.getTags(), request.getBaseRequest().getLoggedInUserId());
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);
		}
		return response;
	}

	@Override
	@POST
	@Path("/get")
	public DocumentFileTagResponse getDocumentFileTags(GetDocumentFileTagRequest request) {
		logger.debug("Getting document file tags for file id: " + request.getDocumentFileId());
		DocumentFileTagResponse response = new DocumentFileTagResponse();
		try {
			List<DocumentFileTagBean> documentFileTags = documentFileTaggingService.getDocumentFileTags(request);
			response.setTags(documentFileTags);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved document file tags");
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);
		}
		return response;
	}

	@Override
	@POST
	@Path("/comment/add")
	public AddUpdateTagCommentResponse addUpdateComment(ProjectFileTagCommentRequest request) {
		logger.debug("Add/Update project file comment for tag id: " + request.getProjectFileTagId());
		AddUpdateTagCommentResponse response = new AddUpdateTagCommentResponse();
		try {
			return projectFileTaggingService.addUpdateComment(request.getProjectFileTagId(), request.getComment(), request.getCommentId(),
					request.getBaseRequest().getLoggedInUserId());
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);
		}
		return response;
	}

	@Override
	@POST
	@Path("/comment/delete")
	public OnTargetResponse deleteComment(DeleteProjectFileTagCommentRequest request) {
		logger.debug("Delete document file comment for id: " + request.getCommentId());
		OnTargetResponse response = new OnTargetResponse();
		try {
			boolean success = projectFileTaggingService.deleteComment(request.getCommentId(), request.getBaseRequest().getLoggedInUserId());
			logger.debug("delete success: " + success);
			if (success) {
				response.setReturnVal(OnTargetConstant.SUCCESS);
				response.setReturnMessage("Successfully deleted comment.");
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Error while deleting comment.");
			}
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);
		}
		return response;
	}

	@Override
	@POST
	@Path("/comment/list")
	public ProjectFileTagCommentResponse getComments(GetProjectFileTagCommentRequest request) {
		logger.debug("Getting comments for document file tag id : " + request.getProjectFileTagId());
		ProjectFileTagCommentResponse response = new ProjectFileTagCommentResponse();
		try {
			List<CommentDTO> comments = projectFileTaggingService.getComments(request.getProjectFileTagId());
			response.setComments(comments);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved comments");
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);
		}
		return response;
	}

}
