package com.ontarget.api.rs.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ontarget.api.request.UpdateIsConversionCompleteRequest;
import com.ontarget.dto.ProjectFileResponse;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.UploadDocumentDetailResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.UploadDocumentEndPoint;
import com.ontarget.api.service.UploadDocumentService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.FileUploadResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UploadedDocumentDetail;
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
	public UploadDocumentDetailResponse saveUploadedDocsInfo(UploadDocumentRequest requestData) {
		logger.info("Starting document upload call");
        UploadDocumentDetailResponse response = new UploadDocumentDetailResponse();

		if (requestData.getProjectId() == 0 || requestData.getName().isEmpty()) {
			response.setReturnMessage("Required information are missing.");
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setResponseCode(OnTargetConstant.SUCCESS_CODE);
			return response;
		}
		try {
			response = documentService.saveUploadedDocsInfo(requestData);
            if(response == null){
                throw new Exception("Error while saving project file.");
            }

		} catch (Exception ex) {
			logger.error(OnTargetConstant.INTERNAL_SERVER_ERROR_MSG, ex);
            response.setReturnMessage("upload project file failed");
            response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}


    public OnTargetResponse updateIsConversionComplete(UpdateIsConversionCompleteRequest request){
        OnTargetResponse response = new OnTargetResponse();
        try {
            return documentService.udpateConversionComplete(request.getProjectFileId(), request.getBaseRequest().getLoggedInUserId(), request.getIsConversioinComplete());
        } catch (Exception e) {
            logger.error("Delete project file failed." + e);
            response.setReturnMessage("Delete project file failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }
        return response;
    }



	@Override
	@POST
	@Path("/delete")
	public OnTargetResponse deleteProjectFile(ProjectFileDeleteRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			return documentService.deleteProjectFile(request.getProjectFileId(), request.getBaseRequest().getLoggedInUserId());
		} catch (Exception e) {
			logger.error("Delete project file failed." + e);
			response.setReturnMessage("Delete project file failed");
			response.setReturnVal(OnTargetConstant.ERROR);
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
    @Path("/getDocumentById")
    public ProjectFileResponse getUploadedFileByDocumentId(ProjectFileRequest projectFileRequest) {
        logger.info("Starting call to retrieve uploaded document by project id");
        ProjectFileResponse response = new ProjectFileResponse();

        response.setProjectId(projectFileRequest.getProjectId());
        response.setProjectFileId(projectFileRequest.getProjectFileId());
        UploadedDocumentDetail projectFile = null;
        try {
            projectFile = documentService.getUploadedFileByProjectFileId(projectFileRequest.getProjectId(), projectFileRequest.getProjectFileId());
            response.setProjectFile(projectFile);
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
