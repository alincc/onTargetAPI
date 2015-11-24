package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.entities.ProjectFileTag;
import com.ontarget.entities.ProjectFileTagComment;
import com.ontarget.entities.ProjectFileTagTaskLink;

public interface ProjectFileTaggingDAO {
	boolean save(List<ProjectFileTagBean> tags, int userId) throws Exception;

	List<ProjectFileTag> getProjectFileTags(int projectFileId) throws Exception;

	ProjectFileTagComment saveComment(Long projectFileTagId, String comment, Long commentId, int userId) throws Exception;

	boolean deleteComment(Long commentId, int userId) throws Exception;

	List<ProjectFileTagComment> getComments(Long projectFileTagId) throws Exception;

	boolean saveTagToTaskLink(Long projectFileTagId, int taskId, int userId, String status) throws Exception;

	ProjectFileTagTaskLink getProjectFileTagTaskLink(Long projectFileTagId, int taskId);

	boolean updateTagToTaskLink(Long projectFileTagTaskLinkId, int userId, String status) throws Exception;
}
