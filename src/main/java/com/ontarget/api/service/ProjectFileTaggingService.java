package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.CommentDTO;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.request.bean.UpdateProjectFileTagToTaskLink;
import com.ontarget.response.bean.AddUpdateTagCommentResponse;
import com.ontarget.response.bean.ProjectFileTagResponse;

public interface ProjectFileTaggingService {

	ProjectFileTagResponse save(List<ProjectFileTagBean> tags, int userId) throws Exception;

	List<ProjectFileTagBean> getProjectFileTags(GetProjectFileTagRequest request) throws Exception;

	AddUpdateTagCommentResponse addUpdateComment(Long projectFileTagId, String comment, Long commentId, int userId) throws Exception;

	boolean deleteComment(Long commentId, int userId) throws Exception;

	List<CommentDTO> getComments(Long projectFileTagId) throws Exception;

	boolean addUpdateTagToTaskLink(UpdateProjectFileTagToTaskLink request, boolean toLink) throws Exception;

}
