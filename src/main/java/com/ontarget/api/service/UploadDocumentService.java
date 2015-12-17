package com.ontarget.api.service;

import java.util.List;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectFilePageDTO;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.request.bean.ProjectFileCommentRequest;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.response.bean.*;
import org.springframework.transaction.annotation.Transactional;

public interface UploadDocumentService {
	public UploadDocumentDetailResponse saveUploadedDocsInfo(UploadDocumentRequest documentInfo) throws Exception;

	public List<UploadedDocumentDetail> getUploadedFile(int projectId) throws Exception;
	
	public OnTargetResponse deleteProjectFile(Integer projectFileId,int userId) throws Exception;

	public ProjectFileCategoryListResponse getProjectFileCategories() throws Exception;

	public ProjectFileCommentObjResponse addUpdateComment(ProjectFileCommentRequest request) throws Exception;

	public OnTargetResponse deleteComment(Integer commentId) throws Exception;
	
	public ProjectFileCommentListResponse getCommentList(Integer projectFileId) throws Exception;

    public UploadedDocumentDetail getUploadedFileByProjectFileId(Integer projectId, Integer porjectFileId) throws Exception;

    public OnTargetResponse udpateConversionComplete(Integer projectFileId, Integer loggedInUserId, Boolean isConversioinComplete) throws Exception;

    public ProjectFilePageDTO saveProjectFilePage(ProjectFilePageDTO projectFilePageDTO,Integer projectFileId) throws Exception;
}
