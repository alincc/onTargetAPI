package com.ontarget.util;

import com.ontarget.dto.ProjectFilePageDTO;
import com.ontarget.entities.ProjectFile;
import com.ontarget.entities.ProjectFilePage;

import java.util.Date;

/**
 * Created by sanjeevghimire on 12/16/15.
 */
public class ProjectFilePageUtil {


    /**
     * Return project file page entity from DTO
     * @param projectFilePageDTO
     * @return
     * @throws Exception
     */
    public static ProjectFilePage getEntityFromDTO(ProjectFilePageDTO projectFilePageDTO, Integer projectFileId) throws  Exception{
        ProjectFilePage projectFilePage=new ProjectFilePage();
        projectFilePage.setImageName(projectFilePageDTO.getImageName());
        projectFilePage.setImageType(projectFilePageDTO.getImageType());
        projectFilePage.setImagePath(projectFilePageDTO.getImagePath());
        projectFilePage.setImageHeight(projectFilePageDTO.getImageHeight());
        projectFilePage.setImageWidth(projectFilePageDTO.getImageWidth());
        projectFilePage.setImageSize(projectFilePageDTO.getImageSize());
        projectFilePage.setZoomLevel(projectFilePageDTO.getZoomLevel());
        projectFilePage.setCreatedDate(new Date());
        ProjectFile projectFile=new ProjectFile();
        projectFile.setProjectFileId(projectFileId);
        projectFilePage.setProjectFile(projectFile);
        projectFilePage.setProjectFilePageId(projectFilePageDTO.getProjectFilePageId());

        return projectFilePage;
    }


    /**
     * Return project file page entity from DTO
     * @param projectFilePage
     * @return
     * @throws Exception
     */
    public static ProjectFilePageDTO getDTOFromEntity(ProjectFilePage projectFilePage) throws  Exception{
        ProjectFilePageDTO projectFilePageDTO=new ProjectFilePageDTO();
        projectFilePageDTO.setImageName(projectFilePage.getImageName());
        projectFilePageDTO.setImageType(projectFilePage.getImageType());
        projectFilePageDTO.setImagePath(projectFilePage.getImagePath());
        projectFilePageDTO.setImageHeight(projectFilePage.getImageHeight());
        projectFilePageDTO.setImageWidth(projectFilePage.getImageWidth());
        projectFilePageDTO.setImageSize(projectFilePage.getImageSize());
        projectFilePageDTO.setCreatedDate(projectFilePage.getCreatedDate());
        projectFilePageDTO.setZoomLevel(projectFilePage.getZoomLevel());
        projectFilePageDTO.setProjectFilePageId(projectFilePage.getProjectFilePageId());
        return projectFilePageDTO;
    }


}
