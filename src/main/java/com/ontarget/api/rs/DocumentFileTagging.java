package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddDocumentFileTagRequest;
import com.ontarget.request.bean.DeleteProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetDocumentFileTagRequest;
import com.ontarget.request.bean.GetProjectFileTagCommentRequest;
import com.ontarget.request.bean.ProjectFileTagCommentRequest;
import com.ontarget.response.bean.AddUpdateTagCommentResponse;
import com.ontarget.response.bean.DocumentFileTagResponse;
import com.ontarget.response.bean.ProjectFileTagCommentResponse;

public interface DocumentFileTagging {

	DocumentFileTagResponse save(@Valid AddDocumentFileTagRequest request);

	DocumentFileTagResponse getDocumentFileTags(GetDocumentFileTagRequest request);

	AddUpdateTagCommentResponse addUpdateComment(ProjectFileTagCommentRequest request);

	OnTargetResponse deleteComment(DeleteProjectFileTagCommentRequest request);

	ProjectFileTagCommentResponse getComments(GetProjectFileTagCommentRequest request);

}
