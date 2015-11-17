package com.ontarget.response.bean;

import java.util.List;

import lombok.Data;

import com.ontarget.bean.ProjectBIMFileCommentDTO;
import com.ontarget.dto.OnTargetResponse;

@Data
public class ProjectBIMFileCommentListResponse extends OnTargetResponse {
	private List<ProjectBIMFileCommentDTO> comments;

}
