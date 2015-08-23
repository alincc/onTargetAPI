package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.UploadDocument;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.entities.ProjectFileComment;
import com.ontarget.request.bean.ProjectFileCommentRequest;

public interface UploadDocumentDAO {
	public UploadDocument saveUploadedDocsInfo(UploadDocument documentBean) throws Exception;

	public List<UploadedDocumentDetail> getFilesByProjectId(int projectId);

	public boolean addComment(ProjectFileCommentRequest request) throws Exception;
	
	public boolean deleteComment(Integer commentId) throws Exception;
	
	public List<ProjectFileComment> getCommentsByFileId(int projectFileId);
}
