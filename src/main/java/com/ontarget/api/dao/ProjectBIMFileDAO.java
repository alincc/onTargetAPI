package com.ontarget.api.dao;

import com.ontarget.entities.ProjectBimFile;

import java.util.List;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileDAO {

    public List<ProjectBimFile> getBIMPoids(Long projectId) throws Exception;

    public boolean saveBIMPoid(ProjectBimFile projectBimFile) throws Exception;

    boolean deleteBIMPoid(Integer projectBimFileId, Integer userId) throws Exception;

    boolean updateThumbnailPath(Integer projectBimFileId, String thumbnailPath, Integer userId) throws Exception;
}
