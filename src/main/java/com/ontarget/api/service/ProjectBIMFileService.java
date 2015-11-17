package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.ProjectBIMFileCommentDTO;
import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.ProjectBIMFileCommentRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import com.ontarget.request.bean.UpdateBIMThumbnailPathRequest;
import com.ontarget.response.bean.GetBIMResponse;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileService {

	public GetBIMResponse getBIMPoids(Long projectId) throws Exception;

	public boolean saveProjectBIMFile(SaveBIMRequest request) throws Exception;

	public boolean deleteProjectBIMFile(DeleteBIMRequest request) throws Exception;

	boolean updateBimThumbnailPath(UpdateBIMThumbnailPathRequest request) throws Exception;

	public boolean addUpdateComment(ProjectBIMFileCommentRequest request) throws Exception;
	
	public boolean deleteComment(Integer commentId) throws Exception;
	
	public List<ProjectBIMFileCommentDTO> getCommentList(Integer projectBIMFileId) throws Exception;
}
