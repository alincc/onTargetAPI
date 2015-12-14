package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.ProjectBimFileComment;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileDAO {

	public List<ProjectBimFile> getBIMProjects(Long projectId) throws Exception;

    ProjectBimFile getBIMProject(int projectBimFileId) throws Exception;

    public ProjectBimFile saveBIMProject(ProjectBimFile projectBimFile) throws Exception;

    public boolean deleteBIMProject(Integer projectBimFileId, Integer userId) throws Exception;

	public boolean updateThumbnailPath(Integer projectBimFileId, String thumbnailPath, Integer userId) throws Exception;

    public ProjectBimFileComment saveComment(ProjectBimFileComment comment) throws Exception;

	public boolean deleteComment(Integer commentId) throws Exception;

	public List<ProjectBimFileComment> getCommentsByFileId(int projectBimFileId);
}
