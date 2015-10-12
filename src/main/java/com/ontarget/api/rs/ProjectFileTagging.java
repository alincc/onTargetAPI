package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddProjectFileTagRequest;
import com.ontarget.request.bean.DeleteProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetProjectFileTagCommentRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.request.bean.ProjectFileTagCommentRequest;
import com.ontarget.response.bean.ProjectFileTagCommentResponse;
import com.ontarget.response.bean.ProjectFileTagResponse;

public interface ProjectFileTagging {

	OnTargetResponse save(@Valid AddProjectFileTagRequest request);

	ProjectFileTagResponse getProjectFileTags(@Valid GetProjectFileTagRequest request);

	OnTargetResponse addUpdateComment(@Valid ProjectFileTagCommentRequest request);

	OnTargetResponse deleteComment(@Valid DeleteProjectFileTagCommentRequest request);

	ProjectFileTagCommentResponse getComments(@Valid GetProjectFileTagCommentRequest request);
}
