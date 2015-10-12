package com.ontarget.response.bean;

import java.util.List;

import lombok.Data;

import com.ontarget.bean.CommentDTO;
import com.ontarget.dto.OnTargetResponse;

@Data
public class ProjectFileTagCommentResponse extends OnTargetResponse {
	private List<CommentDTO> comments;

}
