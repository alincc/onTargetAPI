package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.ProjectBimFileComment;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileDAO {

	List<ProjectBimFile> getBIMPoids(Long projectId) throws Exception;

	boolean saveBIMPoid(ProjectBimFile projectBimFile) throws Exception;

	boolean deleteBIMPoid(Integer projectBimFileId, Integer userId) throws Exception;

	boolean updateThumbnailPath(Integer projectBimFileId, String thumbnailPath, Integer userId) throws Exception;

    ProjectBimFileComment saveComment(ProjectBimFileComment comment) throws Exception;

	boolean deleteComment(Integer commentId) throws Exception;

	List<ProjectBimFileComment> getCommentsByFileId(int projectBimFileId);
}
