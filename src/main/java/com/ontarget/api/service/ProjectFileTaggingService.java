package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.request.bean.GetProjectFileTagRequest;

public interface ProjectFileTaggingService {

	boolean addTag(List<ProjectFileTagBean> tags, int userId) throws Exception;

	List<ProjectFileTagBean> getProjectFileTags(GetProjectFileTagRequest request) throws Exception;

}
