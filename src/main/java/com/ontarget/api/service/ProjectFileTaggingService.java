package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.GetProjectFileTagRequest;

public interface ProjectFileTaggingService {

	OnTargetResponse save(List<ProjectFileTagBean> tags, int userId) throws Exception;

	List<ProjectFileTagBean> getProjectFileTags(GetProjectFileTagRequest request) throws Exception;

	OnTargetResponse addUpdateComment(Long projectFileTagId, String comment, Long commentId, int userId) throws Exception;

	boolean deleteComment(Long commentId, int userId) throws Exception;

	List<CommentDTO> getComments(Long projectFileTagId) throws Exception;

}
