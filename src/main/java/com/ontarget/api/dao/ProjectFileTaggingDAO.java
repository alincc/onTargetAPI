package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagComment;

public interface ProjectFileTaggingDAO {
	boolean save(List<ProjectFileTagBean> tags, int userId) throws Exception;

	List<ProjectFileTag> getProjectFileTags(int projectFileId) throws Exception;

	boolean saveComment(Long projectFileTagId, String comment, Long commentId, int userId) throws Exception;

	boolean deleteComment(Long commentId, int userId) throws Exception;

	List<ProjectFileTagComment> getComments(Long projectFileTagId) throws Exception;
}
