package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.ws.rs.POST;

import com.ontarget.dto.FileUploadResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectFileResponse;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.ProjectFileCategoryListResponse;
import com.ontarget.response.bean.ProjectFileCommentListResponse;

public interface UploadDocumentEndPoint {
	public OnTargetResponse saveUploadedDocsInfo(@Valid UploadDocumentRequest requestData);

	public FileUploadResponse getUploadedFile(@Valid UploadedFileDetail uploadedFileDetailBean);

	public OnTargetResponse deleteProjectFile(@Valid ProjectFileDeleteRequest request);

	public ProjectFileCategoryListResponse projectFileCategoryList(@Valid ProjectFileCategoryRequest request);

	public OnTargetResponse addUpdateComment(ProjectFileCommentRequest request);

	public OnTargetResponse deleteComment(ProjectFileCommentDeleteRequest request);

    public ProjectFileResponse getUploadedFileByDocumentId(ProjectFileRequest projectFileRequest);

    public ProjectFileCommentListResponse projectFileCommentList(ProjectFileCommentListRequest request);
}
