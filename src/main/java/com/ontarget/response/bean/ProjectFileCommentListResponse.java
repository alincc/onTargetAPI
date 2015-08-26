package com.ontarget.response.bean;

import java.util.List;

import lombok.Data;

import com.ontarget.dto.OnTargetResponse;

@Data
public class ProjectFileCommentListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<ProjectFileCommentResponse> comments;
}
