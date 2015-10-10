package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.entities.ProjectFileTag;

public interface ProjectFileTaggingDAO {
	boolean save(List<ProjectFileTagBean> tags, int userId) throws Exception;

	List<ProjectFileTag> getProjectFileTags(int projectFileId) throws Exception;
}
