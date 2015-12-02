package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.UploadDocument;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.entities.ProjectFileComment;
import com.ontarget.request.bean.ProjectFileCommentRequest;

public interface UploadDocumentDAO {
	public UploadedDocumentDetail saveUploadedDocsInfo(UploadDocument documentBean) throws Exception;

	public List<UploadedDocumentDetail> getFilesByProjectId(int projectId);

    UploadedDocumentDetail updateProjectFile(UploadDocument documentBean) throws Exception;

    public boolean deleteProjectFile(Integer projectFileId, int userId) throws Exception;

	public ProjectFileComment addComment(ProjectFileCommentRequest request) throws Exception;

	public boolean deleteComment(Integer commentId) throws Exception;

	public List<ProjectFileComment> getCommentsByFileId(int projectFileId);

    public UploadedDocumentDetail getFilesByProjectAndFileId(Integer projectId, Integer projectFileId) throws Exception;

    public int getVersionNumberByParentProjectFileId(int parentProjectFileId) throws Exception;

    public boolean updateConversionComplete(Integer projectFileId, Integer loggedInUserId, String isConversionComplete);
}
