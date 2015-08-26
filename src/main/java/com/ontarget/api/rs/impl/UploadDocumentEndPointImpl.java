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

import com.ontarget.api.rs.UploadDocumentEndPoint;
import com.ontarget.api.service.UploadDocumentService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.FileUploadResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.request.bean.ProjectFileCategoryRequest;
import com.ontarget.request.bean.ProjectFileCommentDeleteRequest;
import com.ontarget.request.bean.ProjectFileCommentListRequest;
import com.ontarget.request.bean.ProjectFileCommentRequest;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.request.bean.UploadedFileDetail;
import com.ontarget.response.bean.ProjectFileCategoryListResponse;
import com.ontarget.response.bean.ProjectFileCommentListResponse;

/**
 * This class deals with file upload associated with the project
 * 
 *
 */

@Component
@Path("/upload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UploadDocumentEndPointImpl implements UploadDocumentEndPoint {

	private Logger logger = Logger.getLogger(UploadDocumentEndPointImpl.class);

	@Autowired
	private UploadDocumentService documentService;

	@Override
	@Path("/saveUploadedDocsInfo")
	@POST
	public OnTargetResponse saveUploadedDocsInfo(UploadDocumentRequest requestData) {
		logger.info("Starting document upload call");
		OnTargetResponse response = new OnTargetResponse(OnTargetConstant.INTERNAL_SERVER_ERROR_CODE, OnTargetConstant.ERROR,
				OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);

		if (requestData.getProjectId() == 0 || requestData.getName().isEmpty()) {
			response.setReturnMessage("Required information are missing.");
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setResponseCode(OnTargetConstant.SUCCESS_CODE);
			return response;
		}
		try {
			Boolean success = documentService.saveUploadedDocsInfo(requestData);
			return ((success) ? (new OnTargetResponse(OnTargetConstant.SUCCESS_CODE, OnTargetConstant.SUCCESS, OnTargetConstant.SUCCESS))
					: response);
		} catch (Exception ex) {
			logger.error(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG, ex);
		}

		return response;
	}

	@Override
	@Path("/projectFileCategoryList")
	@POST
	public ProjectFileCategoryListResponse projectFileCategoryList(ProjectFileCategoryRequest request) {
		logger.info("Starting call to retrieve projectFileCategoryList");
		ProjectFileCategoryListResponse response = new ProjectFileCategoryListResponse();
		try {
			return documentService.getProjectFileCategories();
		} catch (Exception ex) {
			logger.error(ex);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while retrieving project file category list");
		}
		return response;
	}

	@Override
	@POST
	@Path("/addComment")
	public OnTargetResponse addUpdateComment(ProjectFileCommentRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			return documentService.addUpdateComment(request);
		} catch (Exception e) {
			logger.error("Add/Update project file comment failed." + e);
			response.setReturnMessage("Add/Update project file comment failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/deleteComment")
	public OnTargetResponse deleteComment(ProjectFileCommentDeleteRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			return documentService.deleteComment(request.getCommentId());
		} catch (Exception e) {
			logger.error("Delete project file comment failed." + e);
			response.setReturnMessage("Delete project file comment failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	public FileUploadResponse getUploadedFile(UploadedFileDetail uploadedFileDetailBean) {
		logger.info("Starting call to retrieve uploaded document by project id");
		FileUploadResponse response = new FileUploadResponse(OnTargetConstant.INTERNAL_SERVER_ERROR_CODE, OnTargetConstant.ERROR,
				OnTargetConstant.INTERNAL_SERVER_ERROR_MSG);

		response.setProjectId(uploadedFileDetailBean.getProjectId());
		List<UploadedDocumentDetail> uploadedDocumentDetailList = null;
		try {
			uploadedDocumentDetailList = documentService.getUploadedFile(uploadedFileDetailBean.getProjectId());
			response.setUploadedDocumentList(uploadedDocumentDetailList);
			response.setResponseCode(OnTargetConstant.SUCCESS_CODE);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage(OnTargetConstant.DEFAULT_SUCCESS_MESSAGE);
		} catch (Exception ex) {
			logger.error(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG, ex);
		}

		return response;
	}

	@Override
	@POST
	@Path("/projectFileCommentList")
	public ProjectFileCommentListResponse projectFileCommentList(ProjectFileCommentListRequest request) {
		ProjectFileCommentListResponse response = new ProjectFileCommentListResponse();
		try {
			return documentService.getCommentList(request.getProjectFileId());
		} catch (Exception e) {
			logger.error("Error while retrieving project file comment list." + e);
			response.setReturnMessage("Error while retrieving project file comment list.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
