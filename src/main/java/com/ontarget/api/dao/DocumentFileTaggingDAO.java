package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.entities.ProjectFileTag;

public interface DocumentFileTaggingDAO {
	boolean save(List<DocumentFileTagBean> tags, int userId) throws Exception;

	List<ProjectFileTag> getProjectFileTags(int projectFileId) throws Exception;

}
