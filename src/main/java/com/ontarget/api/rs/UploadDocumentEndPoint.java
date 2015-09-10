package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.FileUploadResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.ProjectFileCategoryRequest;
import com.ontarget.request.bean.ProjectFileCommentDeleteRequest;
import com.ontarget.request.bean.ProjectFileCommentListRequest;
import com.ontarget.request.bean.ProjectFileCommentRequest;
import com.ontarget.request.bean.ProjectFileDeleteRequest;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.request.bean.UploadedFileDetail;
import com.ontarget.response.bean.ProjectFileCategoryListResponse;
import com.ontarget.response.bean.ProjectFileCommentListResponse;

public interface UploadDocumentEndPoint {
	public OnTargetResponse saveUploadedDocsInfo(@Valid UploadDocumentRequest requestData);

	public FileUploadResponse getUploadedFile(@Valid UploadedFileDetail uploadedFileDetailBean);

	public OnTargetResponse deleteProjectFile(@Valid ProjectFileDeleteRequest request);

	public ProjectFileCategoryListResponse projectFileCategoryList(@Valid ProjectFileCategoryRequest request);

	public OnTargetResponse addUpdateComment(ProjectFileCommentRequest request);

	public OnTargetResponse deleteComment(ProjectFileCommentDeleteRequest request);

	public ProjectFileCommentListResponse projectFileCommentList(ProjectFileCommentListRequest request);
}
