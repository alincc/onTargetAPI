package com.ontarget.api.service;

import java.util.List;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.request.bean.ProjectFileCommentRequest;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.response.bean.ProjectFileCategoryListResponse;
import com.ontarget.response.bean.ProjectFileCommentListResponse;

public interface UploadDocumentService {
	public boolean saveUploadedDocsInfo(UploadDocumentRequest documentInfo) throws Exception;

	public List<UploadedDocumentDetail> getUploadedFile(int projectId) throws Exception;

	public ProjectFileCategoryListResponse getProjectFileCategories() throws Exception;

	public OnTargetResponse addUpdateComment(ProjectFileCommentRequest request) throws Exception;

	public OnTargetResponse deleteComment(Integer commentId) throws Exception;
	
	public ProjectFileCommentListResponse getCommentList(Integer projectFileId) throws Exception;
}
